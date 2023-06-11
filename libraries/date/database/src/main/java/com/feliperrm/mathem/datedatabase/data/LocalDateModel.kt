package com.feliperrm.mathem.datedatabase.data

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * This class represents a Date object, when saved locally in the App's DB
 */
@Entity(
    tableName = "date"
)
data class LocalDateModel(
    @PrimaryKey val date: String
)
