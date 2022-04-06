package com.di.retrofitdagger.di

import com.di.retrofitdagger.retro.mainAPI
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {
    @Provides
    @Singleton
    fun provideAPI(): mainAPI {
        val okHttpClient = OkHttpClient.Builder()
        okHttpClient.connectTimeout(3, TimeUnit.MINUTES)

        return Retrofit.Builder()
            .baseUrl("https://run.mocky.io/")
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient.build())
            .build()
            .create(mainAPI::class.java)
    }
}