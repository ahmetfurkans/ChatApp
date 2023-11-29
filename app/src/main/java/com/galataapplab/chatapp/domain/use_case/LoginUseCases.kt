package com.galataapplab.chatapp.domain.use_case

data class LoginUseCases(
    val sendPhoneNumberVerification: SendPhoneNumberVerification,
    val checkVerificationCode: CheckVerificationCode
)