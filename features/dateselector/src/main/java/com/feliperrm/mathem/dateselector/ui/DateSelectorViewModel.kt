package com.feliperrm.mathem.dateselector.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.feliperrm.mathem.daterepository.data.DataRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class DateSelectorViewModel(
    private val dateRepository: DataRepository = DataRepository()
) : ViewModel() {

    val stateUi: StateFlow<DateListUiState> = dateRepository.datesFlow.map { DateListUiState.Ui(it) }
        .stateIn(viewModelScope, SharingStarted.Eagerly, DateListUiState.Loading)

    init {
        viewModelScope.launch {
            dateRepository.loadDatesFromNetwork()
        }
    }

}

sealed class DateListUiState {
    object Loading : DateListUiState()
    data class Ui(val dates: List<String>) : DateListUiState()
}
