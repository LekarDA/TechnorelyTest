package com.example.technorelytest.data.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Artist(
    val name : String,
    val listeners : String,
    val mbid : String,
    val url : String,
    val streamable : String,
    val image : List<Image>
): Parcelable