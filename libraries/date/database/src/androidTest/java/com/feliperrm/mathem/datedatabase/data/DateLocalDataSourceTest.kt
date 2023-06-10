package com.feliperrm.mathem.datedatabase.data

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider.getApplicationContext
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class DateLocalDataSourceTest {

    private lateinit var db: DateDatabase

    @Before
    fun initDb() {
        db = Room.inMemoryDatabaseBuilder(
            getApplicationContext(),
            DateDatabase::class.java
        ).allowMainThreadQueries().build()
    }


    // Given: A new DB
    // Then: Then the DB should be empty
    @Test
    fun testNewDbIsEmpty() = runTest {
        val dates = db.dateDao().observeAll().first()
        assertEquals(0, dates.size)
    }

    // Given: An Empty DB
    // When: a date is inserted and we start observing the date stream
    // Then: The stream has only one item, that matches the inserted date
    @Test
    fun insertDateAndObserve() = runTest {
        val dateString = "2023-09-18"
        val newDate = LocalDate(dateString)
        db.dateDao().upsert(newDate)
        val dates = db.dateDao().observeAll().first()
        assertEquals(1, dates.size)
        assertEquals(dateString, dates.first().date)
    }

}
