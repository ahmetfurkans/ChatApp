package com.galataapplab.chatapp.domain.use_case

import android.app.Activity
import com.galataapplab.chatapp.core.util.Resource
import com.galataapplab.chatapp.domain.repository.LoginRepository
import kotlinx.coroutines.flow.Flow

class SendPhoneNumberVerification(
    private val repository: LoginRepository
) {
    operator fun invoke(activity: Activity, phone: String): Flow<Resource<String>> {
        return repository.signInWithPhone(phone, activity)
    }
}

