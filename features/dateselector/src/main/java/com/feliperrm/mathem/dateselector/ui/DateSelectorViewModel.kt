package com.feliperrm.mathem.dateselector.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.feliperrm.mathem.daterepository.data.DataRepository
import kotlinx.coroutines.launch

class DateSelectorViewModel(
    private val dateRepository: DataRepository = DataRepository()
) : ViewModel() {

    init {
        viewModelScope.launch {
            dateRepository.getDates()
        }
    }

}
