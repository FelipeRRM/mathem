package com.feliperrm.mathem.dateselector.ui

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.feliperrm.mathem.daterepository.data.DataRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class DateSelectorViewModel @Inject constructor(
    private val savedStatesHandle: SavedStateHandle,
    private val dateRepository: DataRepository
) : ViewModel() {

    val stateUi: StateFlow<DateListUiState> = dateRepository.datesFlow.map { DateListUiState.Ui(it) }
        .stateIn(viewModelScope, SharingStarted.Lazily, DateListUiState.Loading)

    init {
        dateRepository.loadDatesFromNetwork()
    }

}

sealed class DateListUiState {
    object Loading : DateListUiState()
    data class Ui(val dates: List<String>) : DateListUiState()
}
