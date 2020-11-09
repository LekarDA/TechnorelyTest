package com.example.technorelytest.data.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AttributesOfResponse(
    val country: String,
    val page: String,
    val perPage: String,
    val totalPages: String,
    val total: String
): Parcelable