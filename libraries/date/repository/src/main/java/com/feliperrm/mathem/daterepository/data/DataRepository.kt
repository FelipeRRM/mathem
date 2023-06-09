package com.feliperrm.mathem.daterepository.data

import com.feliperrm.mathem.datenetwork.data.DateRemoteDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch

class DataRepository(
    private val remoteDataSource: DateRemoteDataSource = DateRemoteDataSource()
) {

    private val scope = CoroutineScope(Dispatchers.IO + SupervisorJob())

    val datesFlow: MutableSharedFlow<List<String>> = MutableSharedFlow(replay = 1)

    fun loadDatesFromNetwork() {
        scope.launch {
            val dates = remoteDataSource.getDeliveryDate()
            datesFlow.emit(dates)
        }
    }

    suspend fun getTimes(dateString: String) = remoteDataSource.getDeliveryTimes(dateString)

}
