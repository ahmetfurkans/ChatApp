package com.galataapplab.chatapp.domain.use_case

import com.galataapplab.chatapp.core.util.Resource
import com.galataapplab.chatapp.domain.repository.LoginRepository
import kotlinx.coroutines.flow.Flow

class CheckVerificationCode(
    private val repository: LoginRepository
) {
    operator fun invoke(otp: String): Flow<Resource<String>> = repository.otpVerification(otp = otp)
}