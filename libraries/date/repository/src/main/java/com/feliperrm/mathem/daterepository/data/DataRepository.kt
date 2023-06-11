package com.feliperrm.mathem.daterepository.data

import com.feliperrm.mathem.datedatabase.data.DateLocalDataSource
import com.feliperrm.mathem.datedatabase.data.LocalDateModel
import com.feliperrm.mathem.datedatabase.data.LocalDeliveryDateModel
import com.feliperrm.mathem.datenetwork.data.DateRemoteDataSource
import com.feliperrm.mathem.datenetwork.data.DeliveryDateNetworkModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class DataRepository @Inject constructor(
    private val remoteDataSource: DateRemoteDataSource,
    private val localDataSource: DateLocalDataSource
) {

    /**
     * Returns a  flow observing the DB for available delivery dates. If the returned query is empty,
     * fetches the data from the network and inserts it into the DB (since the result of the query itself is a flow,
     * it gets updated automatically after insertion happens).
     */
    fun loadDatesFromNetwork() =
        localDataSource.observeAllDates().flowOn(Dispatchers.IO).onEach {
            if (it.isEmpty()) {
                val deliveryDates = remoteDataSource.getDeliveryDate()
                localDataSource.upsertAllDates(deliveryDates.map { deliveryDateString -> LocalDateModel(deliveryDateString) })
            }
        }

    /**
     * Returns a  flow observing the DB for deliveries slots on the provided date. If the returned query is empty,
     * fetches the data from the network and inserts it into the DB (since the result of the query itself is a flow,
     * it gets updated automatically after insertion happens).
     */
    fun deliveryTimes(dateString: String) =
        localDataSource.observeAllDeliveriesFromDate(dateString).flowOn(Dispatchers.IO).onEach {
            if (it.isEmpty()) {
                val deliveryTimes = remoteDataSource.getDeliveryTimes(dateString)
                localDataSource.upsertAllDeliveries(deliveryTimes.map { it.toLocalModel() })
            }
        }

    /**
     * Returns a flow with a delivery slot corresponding to the provided ID
     */
    fun getDeliveryTime(deliverySlotId: String) = localDataSource.observeDeliverySlotFromId(deliverySlotId).flowOn(Dispatchers.IO)

}

/* Model Converters */
fun DeliveryDateNetworkModel.toLocalModel(): LocalDeliveryDateModel {
    return LocalDeliveryDateModel(
        id = this.deliveryTimeId,
        date = this.deliveryDate,
        startTime = this.startTime,
        stopTime = this.stopTime,
        inHomeAvailable = this.inHomeAvailable
    )
}
