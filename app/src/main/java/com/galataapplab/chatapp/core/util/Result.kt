package com.galataapplab.chatapp.core.util

sealed class Resource<out T> {

    data class Success<out R>(val data: R) : Resource<R>()
    data class Failure(val msg: String) : Resource<Nothing>()
    data object Loading : Resource<Nothing>()

}