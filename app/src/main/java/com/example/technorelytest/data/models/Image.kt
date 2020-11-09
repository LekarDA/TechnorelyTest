package com.example.technorelytest.data.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Image(
    @SerializedName("#text")
    val link: String,
    val size: String
): Parcelable