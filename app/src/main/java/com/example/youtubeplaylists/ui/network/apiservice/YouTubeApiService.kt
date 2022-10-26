package com.example.youtubeplaylists.ui.network.apiservice

import com.example.ytparser.model.YouTubeApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface YouTubeApiService {

    @GET("playlists")
    suspend fun fetchPlaylists(
        @Query("part") part: String,
        @Query("channelId") id: String,
        @Query("maxResults") maxResult: Int,
        @Query("key") Apikey: String
    ): Response<YouTubeApiResponse>

    @GET("playlistItems")
    suspend fun fetchPlaylistItems(
        @Query("part") part: String,
        @Query("playlistId") playlistId: String,
        @Query("key") Apikey: String,
        @Query("maxResults") maxResult: Int
    ): Response<YouTubeApiResponse>
}