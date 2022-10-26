package com.example.youtubeplaylists.ui.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.example.youtubeplaylists.BuildConfig.API_KEY
import com.example.youtubeplaylists.ui.ext.Constants
import com.example.youtubeplaylists.ui.core.Resource
import com.example.ytparser.model.YouTubeApiResponse
import com.example.youtubeplaylists.ui.network.apiservice.YouTubeApiService
import kotlinx.coroutines.Dispatchers

class Repository(private val youTubeApiService: YouTubeApiService) {

    fun fetchPlaylists(): LiveData<Resource<YouTubeApiResponse>> {
        return liveData(Dispatchers.IO) {
            emit(Resource.Loading())
            val response = youTubeApiService.fetchPlaylists(
                Apikey = API_KEY,
                part = Constants.PART,
                maxResult = Constants.MAX_RESULT,
                id = Constants.CHANNEL_ID
            )
            if (response.isSuccessful && response.body() != null) {
                emit(Resource.Success(response.body()!!))
            } else {
                emit(Resource.Error(response.message()))
            }
        }
    }

    fun fetchPlaylistItems(playlistId: String): LiveData<Resource<YouTubeApiResponse>> {
        return liveData(Dispatchers.IO) {
            emit(Resource.Loading())
            val response = youTubeApiService.fetchPlaylistItems(
                part = Constants.PART,
                playlistId = playlistId,
                Apikey = API_KEY,
                maxResult = 50
            )
            if (response.isSuccessful && response.body() != null) {
                emit(Resource.Success(response.body()!!))
            } else {
                emit(Resource.Error(response.message()))
            }
        }
    }
}