package com.di.retrofitdagger.retro

import com.di.retrofitdagger.TestData
import io.reactivex.Observable
import retrofit2.http.GET

//request mocky api using rxjava2
interface mainAPI {
    @GET("v3/345bfd6f-97e3-4e41-8113-b9584f571efc")
    fun getTestData(): Observable<TestData>
}