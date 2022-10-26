package com.example.youtubeplaylists.ui.di

import com.example.youtubeplaylists.ui.network.client.provideApi
import com.example.youtubeplaylists.ui.network.client.provideOkHttp
import com.example.youtubeplaylists.ui.network.client.provideRetrofit
import com.example.youtubeplaylists.ui.repository.Repository
import com.example.youtubeplaylists.ui.ui.fragments.playlist_detail.DetailsViewModel
import com.example.youtubeplaylists.ui.ui.fragments.playlists.PlaylistsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val youTubeAppModule = module {
    single {
        provideRetrofit(get())
    }
    factory {
        provideOkHttp()
    }
    single {
        provideApi(get())
    }
    single {
        Repository(get())
    }
    viewModel {
        PlaylistsViewModel(get())
    }
    viewModel {
        DetailsViewModel(get())
    }
}