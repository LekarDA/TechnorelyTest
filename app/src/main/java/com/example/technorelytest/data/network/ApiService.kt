package com.example.technorelytest.data.network

import com.example.technorelytest.data.models.ArtistsResponse
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/2.0/")
    fun getPopularArtists(
        @Query("method") method: String,
        @Query("country") country: String,
        @Query("api_key") api_key: String,
        @Query("format") format: String
    ): Deferred<Response<ArtistsResponse>>
}