package com.feliperrm.mathem.datedatabase.data

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface DateLocalDataSource {

    @Query("SELECT * FROM date")
    fun observeAllDates(): Flow<List<LocalDateModel>>

    @Upsert
    suspend fun upsertDate(date: LocalDateModel)

    @Upsert
    suspend fun upsertAllDates(dates: List<LocalDateModel>)

    @Query("SELECT * FROM dalivery WHERE date LIKE :dateString")
    fun observeAllDeliveriesFromDate(dateString: String): Flow<List<LocalDeliveryDateModel>>

    @Query("SELECT * FROM dalivery WHERE id LIKE :deliverySlotId LIMIT 1")
    fun observeDeliverySlotFromId(deliverySlotId: String): Flow<LocalDeliveryDateModel>

    @Upsert
    suspend fun upsertDelivery(delivery: LocalDeliveryDateModel)

    @Upsert
    suspend fun upsertAllDeliveries(deliveries: List<LocalDeliveryDateModel>)
}
