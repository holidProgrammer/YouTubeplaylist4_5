package com.example.youtubeplaylists.ui

import android.app.Application
import com.example.youtubeplaylists.ui.di.youTubeAppModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(youTubeAppModule)
        }
    }
}