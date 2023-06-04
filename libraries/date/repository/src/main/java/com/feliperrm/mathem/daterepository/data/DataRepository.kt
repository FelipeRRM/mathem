package com.feliperrm.mathem.daterepository.data

import com.feliperrm.mathem.datenetwork.data.DateRemoteDataSource

class DataRepository(
    private val remoteDataSource: DateRemoteDataSource = DateRemoteDataSource()
) {

    suspend fun getDates() = remoteDataSource.getDeliveryDate()

    suspend fun getTimes(dateString: String) = remoteDataSource.getDeliveryTimes(dateString)

}
