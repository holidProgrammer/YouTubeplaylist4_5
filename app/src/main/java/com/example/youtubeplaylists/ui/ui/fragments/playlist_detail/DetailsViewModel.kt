package com.example.youtubeplaylists.ui.ui.fragments.playlist_detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.youtubeplaylists.ui.core.Resource
import com.example.ytparser.model.YouTubeApiResponse
import com.example.youtubeplaylists.ui.repository.Repository

class DetailsViewModel(private val repository: Repository): ViewModel() {

    fun fetchPlaylistItems(playlistId:String): LiveData<Resource<YouTubeApiResponse>>{
        return repository.fetchPlaylistItems(playlistId)
    }
}