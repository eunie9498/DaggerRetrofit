package com.di.retrofitdagger

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class TestData(
    var date: String? = "",
    var blog: String? = "",
    var title: String? = "",
    var summary: String? = ""
) : Parcelable