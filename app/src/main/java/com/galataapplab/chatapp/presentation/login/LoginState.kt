package com.galataapplab.chatapp.presentation.login

data class LoginState(
    val phone: String = "",
    val otp: String = "",
    val isContinueButtonActive: Boolean = true,
)
