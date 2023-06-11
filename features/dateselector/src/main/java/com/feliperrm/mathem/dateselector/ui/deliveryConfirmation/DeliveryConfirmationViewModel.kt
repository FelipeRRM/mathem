package com.feliperrm.mathem.dateselector.ui.deliveryConfirmation

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.feliperrm.mathem.datedatabase.data.LocalDeliveryDateModel
import com.feliperrm.mathem.daterepository.data.DataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class DeliveryConfirmationViewModel @Inject constructor(
    private val savedStatesHandle: SavedStateHandle,
    private val dateRepository: DataRepository
) : ViewModel() {

    val stateUi: StateFlow<DeliveryConfirmationUiState>

    init {
        val deliveryIdArgument = savedStatesHandle.get<String>(DeliveryConfirmationScreenRoute.deliverySlotIdArgument) ?: throw Exception("Delivery ID was not Provided")
        stateUi = dateRepository.getDeliveryTime(deliveryIdArgument)
            .map { selectedDelivery -> DeliveryConfirmationUiState.Ui(selectedDelivery) }
            .stateIn(viewModelScope, SharingStarted.Lazily, DeliveryConfirmationUiState.Loading)
    }

}

sealed class DeliveryConfirmationUiState {
    object Loading : DeliveryConfirmationUiState()
    data class Ui(val selectedDelivery: LocalDeliveryDateModel) : DeliveryConfirmationUiState()
}
