package com.example.technorelytest.data.repository

import com.example.technorelytest.Utils.API_KEY
import com.example.technorelytest.Utils.FORMAT
import com.example.technorelytest.Utils.METHOD
import com.example.technorelytest.data.local.ArtistsDao
import com.example.technorelytest.data.models.Artist
import com.example.technorelytest.data.models.EntityArtist
import com.example.technorelytest.data.models.Mapper
import com.example.technorelytest.data.network.ApiService
import javax.inject.Inject

class ArtistsRepository @Inject constructor(
    private val apiService: ApiService,
    private val localDataSource: ArtistsDao,
    private val mapper:Mapper
) : BaseRepository() {

    suspend fun getPopularArtists(country: String): MutableList<Artist>?{
        val artistsResponse = safeApiCall(
            call = {
                apiService.getPopularArtists(METHOD,country, API_KEY, FORMAT).await()
            },
            errorMessage = "Error Fetching Popular Artists"
        )

        val entities = mapper.map(artistsResponse?.topartists?.artists)
        localDataSource.insertAll(entities)
        return artistsResponse?.topartists?.artists?.toMutableList()
    }

    suspend fun getArtist(id: String?): EntityArtist{
        return localDataSource.getArtist(id)
    }
}