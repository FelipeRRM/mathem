package com.feliperrm.mathem.datenetwork.data

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DeliveryDateNetworkModel(
    val deliveryTimeId: String,
    val deliveryDate: String,
    val startTime: String,
    val stopTime: String,
    val inHomeAvailable: Boolean
)
