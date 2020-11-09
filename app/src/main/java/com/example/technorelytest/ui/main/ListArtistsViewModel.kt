package com.example.technorelytest.ui.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.technorelytest.data.repository.ArtistsRepository
import com.example.technorelytest.data.models.Artist
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class ListArtistsViewModel @ViewModelInject constructor(private val repository : ArtistsRepository):
    ViewModel()  {

    private val parentJob = Job()

    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Default

    private val scope = CoroutineScope(coroutineContext)

    val popularArtistsLiveData = MutableLiveData<MutableList<Artist>>()

    fun fetchPopularArtistsByCountry(country:String){
        scope.launch {
            val popularArtists = repository.getPopularArtists(country)
            popularArtistsLiveData.postValue(popularArtists)
        }
    }

    fun cancelAllRequests() = coroutineContext.cancel()
}