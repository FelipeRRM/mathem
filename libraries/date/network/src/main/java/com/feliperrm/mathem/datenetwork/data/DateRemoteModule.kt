package com.feliperrm.mathem.datenetwork.data

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object DateRemoteModule {

    @Provides
    fun providesDateRemoteDataSource(): DateRemoteDataSource = DateRemoteDataSource()

}
