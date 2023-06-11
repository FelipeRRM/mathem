package com.feliperrm.mathem.dateselector.ui.deliveryList

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.feliperrm.mathem.datedatabase.data.LocalDeliveryDateModel
import com.feliperrm.mathem.daterepository.data.DataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DeliverySelectorViewModel @Inject constructor(
    private val savedStatesHandle: SavedStateHandle,
    private val dateRepository: DataRepository
) : ViewModel() {

    val stateUi: StateFlow<DeliveryListUiState>
    private val isHomeDelivery: MutableSharedFlow<Boolean> = MutableSharedFlow(replay = 1)

    init {
        val dateStringArgument = savedStatesHandle.get<String>(DeliveryListScreenRoute.dateArgument) ?: throw Exception("Date Argument Was not Provided")
        stateUi = dateRepository.deliveryTimes(dateStringArgument).combine(isHomeDelivery) { deliveriesList, isHomeDeliveryOnly ->
            DeliveryListUiState.Ui(
                deliveriesList.filter {
                    if (isHomeDeliveryOnly) {
                        it.inHomeAvailable
                    } else {
                        true
                    }
                }.sortedBy {
                    it.startTime
                }, isHomeDeliveryOnly
            )
        }
            .stateIn(viewModelScope, SharingStarted.Lazily, DeliveryListUiState.Loading)
        isHomeDeliveryChanged(false)
    }

    fun isHomeDeliveryChanged(isHomeDeliveryChecked: Boolean) {
        viewModelScope.launch {
            isHomeDelivery.emit(isHomeDeliveryChecked)
        }
    }

}

sealed class DeliveryListUiState {
    object Loading : DeliveryListUiState()
    data class Ui(val deliverySlots: List<LocalDeliveryDateModel>, val isHomeDeliveryChecked: Boolean) : DeliveryListUiState()
}
