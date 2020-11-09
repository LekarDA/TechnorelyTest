package com.example.technorelytest.data.local

import androidx.annotation.Nullable
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.technorelytest.data.models.EntityArtist

@Dao
interface ArtistsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(artists: List<EntityArtist>?)

    @Query("SELECT * FROM artists WHERE mbid = :id")
    suspend fun getArtist(id: String?): EntityArtist
}