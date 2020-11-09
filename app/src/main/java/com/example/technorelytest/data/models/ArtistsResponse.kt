package com.example.technorelytest.data.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ArtistsResponse(
    val topartists : TopArtistsResponse
): Parcelable