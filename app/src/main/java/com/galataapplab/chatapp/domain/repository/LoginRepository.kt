package com.galataapplab.chatapp.domain.repository

import android.app.Activity
import com.galataapplab.chatapp.core.util.Resource
import kotlinx.coroutines.flow.Flow

interface LoginRepository {

    fun signInWithPhone(
        phone: String, activity: Activity
    ): Flow<Resource<String>>

    fun otpVerification(
        otp: String
    ): Flow<Resource<String>>

}