package com.example.youtubeplaylists.ui.core

sealed class UIState<T> {
    class Loading<T> : UIState<T>()
    class Error<T>(val message: String) : UIState<T>()
    class Success<T>(val data: T) : UIState<T>()
}