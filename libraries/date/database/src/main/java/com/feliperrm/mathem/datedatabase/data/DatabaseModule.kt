package com.feliperrm.mathem.datedatabase.data

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Singleton
    @Provides
    fun provideDataBase(@ApplicationContext context: Context): DateDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            DateDatabase::class.java,
            "DateDatabase.db"
        ).build()
    }

    @Provides
    fun provideTaskDao(database: DateDatabase): DateLocalDataSource = database.dateDao()

}
