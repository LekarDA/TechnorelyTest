package com.example.technorelytest.ui.detail

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.technorelytest.data.models.EntityArtist
import com.example.technorelytest.data.repository.ArtistsRepository
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

class DetailViewModel @ViewModelInject constructor(private val repository : ArtistsRepository):
    ViewModel()  {

    private val parentJob = Job()

    private val coroutineContext: CoroutineContext
        get() = parentJob + Dispatchers.Default

    private val scope = CoroutineScope(coroutineContext)

    val artistLiveData = MutableLiveData<EntityArtist>()

    fun getArtistById(id : String?){
        scope.launch {
            val artist = repository.getArtist(id)
            artistLiveData.postValue(artist)
        }
    }

    fun cancelAllRequests() = coroutineContext.cancel()
}