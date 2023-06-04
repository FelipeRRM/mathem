package com.feliperrm.mathem.datenetwork.data

import retrofit2.http.GET
import retrofit2.http.Path

interface DateService {

    @GET("delivery/dates")
    suspend fun getDates(): List<String>

    @GET("delivery/times/{dateString}")
    suspend fun getTimes(@Path("dateString") dateString: String): List<DeliveryDateNetworkModel>

}
