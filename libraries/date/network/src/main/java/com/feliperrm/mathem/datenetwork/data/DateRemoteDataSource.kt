package com.feliperrm.mathem.datenetwork.data

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class DateRemoteDataSource {

    private val okHttpClient by lazy {
        OkHttpClient.Builder()
            .addNetworkInterceptor { chain ->
                val requestBuilder = chain.request().newBuilder()
                val versionNumber = 1
                requestBuilder.header(
                    "User-Agent",
                    "Android: $versionNumber"
                )
                chain.proceed(requestBuilder.build())
            }
            .addNetworkInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
            .build()
    }

    // Moshi Set Up
    private fun moshi() =
        MoshiConverterFactory.create(
            Moshi.Builder()
                .addLast(KotlinJsonAdapterFactory())
                .build()
        )


    // Config Services

    private val configRetrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.mathem.io/mh-test-assignment/")
            .addConverterFactory(moshi())
            .client(okHttpClient)
            .build()
    }

    private val service by lazy { configRetrofit.create(DateService::class.java) }

    suspend fun getDeliveryDate() = service.getDates()

    suspend fun getDeliveryTimes(dateString: String) = service.getTimes(dateString)

}
