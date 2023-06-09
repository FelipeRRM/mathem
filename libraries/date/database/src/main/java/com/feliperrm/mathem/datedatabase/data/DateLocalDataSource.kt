package com.feliperrm.mathem.datedatabase.data

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow

@Dao
interface DateLocalDataSource {

    @Query("SELECT * FROM date")
    fun observeAll(): Flow<List<LocalDate>>

    @Upsert
    suspend fun upsert(date: LocalDate)

    @Upsert
    suspend fun upsertAll(dates: List<LocalDate>)
}
