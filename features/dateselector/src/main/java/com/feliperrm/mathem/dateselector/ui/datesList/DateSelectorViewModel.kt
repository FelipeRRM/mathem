package com.feliperrm.mathem.dateselector.ui.datesList

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.feliperrm.mathem.datedatabase.data.LocalDateModel
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

    val stateUi: StateFlow<DateListUiState> = dateRepository.loadDatesFromNetwork()
        .map { DateListUiState.Ui(it.sortedBy { localDateModel -> localDateModel.date }) }
        .stateIn(viewModelScope, SharingStarted.Lazily, DateListUiState.Loading)

}

sealed class DateListUiState {
    object Loading : DateListUiState()
    data class Ui(val dates: List<LocalDateModel>) : DateListUiState()
}
