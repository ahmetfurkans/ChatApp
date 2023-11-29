package com.galataapplab.chatapp.presentation.login

import android.app.Activity

sealed class LoginEvent {
    data class OnContinueClick(val activity: Activity) : LoginEvent()
    data class OnPhoneNumberChange(val phone: String) : LoginEvent()
    data class OnOTPChange(val otp: String) : LoginEvent()
    data object OnVerifyClick : LoginEvent()
}