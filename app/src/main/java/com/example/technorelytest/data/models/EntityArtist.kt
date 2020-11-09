package com.example.technorelytest.data.models

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "artists")
@Parcelize
data class EntityArtist(
    val name : String,
    val listeners : String,
    @PrimaryKey
    val mbid : String,
    val url : String,
    val streamable : String,
    val imageSmall : String,
    val imageLarge : String
):Parcelable