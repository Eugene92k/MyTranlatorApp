package com.example.mytranlatorapp.data.model

sealed class Resource<out T : Any> {
    data class Success<out T : Any>(val content: T) : Resource<T>()
    data class Error(val message: String) : Resource<Nothing>()
}