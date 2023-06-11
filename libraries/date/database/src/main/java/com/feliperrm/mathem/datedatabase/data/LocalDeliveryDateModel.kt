package com.feliperrm.mathem.datedatabase.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "dalivery"
)
data class LocalDeliveryDateModel(
    @PrimaryKey val id: String,
    val date: String,
    val startTime: String,
    val stopTime: String,
    val inHomeAvailable: Boolean
)
