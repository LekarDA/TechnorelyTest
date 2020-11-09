package com.example.technorelytest.data.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TopArtistsResponse(
    @SerializedName("artist")
    val artists : List<Artist>,
    @SerializedName("@attr")
    val attributes : AttributesOfResponse
): Parcelable