package com.feliperrm.mathem.datedatabase.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [LocalDateModel::class, LocalDeliveryDateModel::class], version = 1, exportSchema = false)
abstract class DateDatabase : RoomDatabase() {
    abstract fun dateDao(): DateLocalDataSource
}
