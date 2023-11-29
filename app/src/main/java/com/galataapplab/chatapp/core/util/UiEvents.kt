package com.galataapplab.chatapp.core.util

sealed class UiEvent {
    data object Success: UiEvent()
    data object NavigateUp: UiEvent()
    data class ShowSnackbar(val message: String): UiEvent()
}