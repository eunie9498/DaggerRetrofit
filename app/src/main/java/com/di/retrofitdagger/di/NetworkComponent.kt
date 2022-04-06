package com.di.retrofitdagger.di

import com.di.retrofitdagger.MainActivity
import dagger.Component
import javax.inject.Singleton

@Component(modules = [NetworkModule::class])
@Singleton
interface NetworkComponent {
    fun inject(activity: MainActivity)
}