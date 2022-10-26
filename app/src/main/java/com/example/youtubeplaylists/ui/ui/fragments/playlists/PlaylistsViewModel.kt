package com.example.youtubeplaylists.ui.ui.fragments.playlists

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.youtubeplaylists.ui.core.Resource
import com.example.ytparser.model.YouTubeApiResponse
import com.example.youtubeplaylists.ui.repository.Repository

class PlaylistsViewModel(private val repository: Repository): ViewModel() {

    fun fetchPlaylists() : LiveData<Resource<YouTubeApiResponse>> {
        return repository.fetchPlaylists()
    }
}