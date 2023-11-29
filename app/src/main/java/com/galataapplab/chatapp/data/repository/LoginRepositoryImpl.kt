package com.galataapplab.chatapp.data.repository

import android.app.Activity
import com.galataapplab.chatapp.core.util.Resource
import com.galataapplab.chatapp.core.util.isValidPhoneNumber
import com.galataapplab.chatapp.domain.repository.LoginRepository
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.callbackFlow
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(
    private val auth: FirebaseAuth
) : LoginRepository {

    private lateinit var otpVerificationCode: String

    override fun signInWithPhone(phone: String, activity: Activity) = callbackFlow {
        trySend(Resource.Loading)

        if (!isValidPhoneNumber(phoneNumber = phone)) {
            trySend(Resource.Failure("Invalid phone number"))
            awaitClose()
        }

        val onVerificationCallback =
            object : PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                override fun onVerificationCompleted(p0: PhoneAuthCredential) {
                    // 1 - Instant verification. In some cases the phone number can be instantly
                    // verified without needing to send or enter a verification code.
                    // TODO
                }

                override fun onVerificationFailed(p0: FirebaseException) {
                    trySend(Resource.Failure(p0.message ?: "Something went wrong"))
                }

                override fun onCodeSent(
                    verificationCode: String, p1: PhoneAuthProvider.ForceResendingToken
                ) {
                    super.onCodeSent(verificationCode, p1)
                    trySend(Resource.Success("OTP Sent Successfully"))
                    otpVerificationCode = verificationCode
                }
            }

        val options = PhoneAuthOptions.newBuilder(auth).setPhoneNumber(phone)
            .setTimeout(60L, TimeUnit.SECONDS).setActivity(activity)
            .setCallbacks(onVerificationCallback).build()
        PhoneAuthProvider.verifyPhoneNumber(options)
        awaitClose {
            close()
        }
    }

    override fun otpVerification(otp: String) = callbackFlow {
        trySend(Resource.Loading)
        val credential = PhoneAuthProvider.getCredential(otpVerificationCode, otp)
        auth.signInWithCredential(credential).addOnCompleteListener {
            if (it.isSuccessful) trySend(Resource.Success("otp verified"))
        }.addOnFailureListener {
            trySend(Resource.Failure(it.message ?: "Something went wrong"))
        }
        awaitClose {
            close()
        }
    }

}