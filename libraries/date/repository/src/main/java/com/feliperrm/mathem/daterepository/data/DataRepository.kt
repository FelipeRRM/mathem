package com.feliperrm.mathem.daterepository.data

import com.feliperrm.mathem.datenetwork.data.DateRemoteDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.withContext

class DataRepository(
    private val remoteDataSource: DateRemoteDataSource = DateRemoteDataSource()
) {

    val datesFlow: MutableSharedFlow<List<String>> = MutableSharedFlow()

    suspend fun loadDatesFromNetwork() {
        withContext(Dispatchers.IO) {
            val dates = remoteDataSource.getDeliveryDate()
            datesFlow.emit(dates)
        }
    }

    suspend fun getTimes(dateString: String) = remoteDataSource.getDeliveryTimes(dateString)

}
