package com.galataapplab.chatapp.presentation.login

import android.app.Activity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.galataapplab.chatapp.core.util.Resource
import com.galataapplab.chatapp.core.util.UiEvent
import com.galataapplab.chatapp.domain.use_case.LoginUseCases
import com.galataapplab.chatapp.presentation.login.LoginEvent.OnContinueClick
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private var loginUseCases: LoginUseCases
) : ViewModel() {

    private val _sharedState = MutableStateFlow(LoginState())
    val sharedState = _sharedState.asStateFlow()

    private val _uiEvent = Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    fun onEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.OnOTPChange -> {
                _sharedState.value = _sharedState.value.copy(
                    otp = event.otp
                )
            }

            is LoginEvent.OnPhoneNumberChange -> {
                _sharedState.value = _sharedState.value.copy(
                    phone = event.phone
                )
            }

            is LoginEvent.OnVerifyClick -> {
                checkVerificationCode()
            }

            is OnContinueClick -> {
                sendPhoneNumberVerification(event.activity)
            }
        }
    }

    private fun checkVerificationCode() {
        viewModelScope.launch {
            loginUseCases.checkVerificationCode(_sharedState.value.otp).collectLatest { data ->
                when (data) {
                    is Resource.Failure -> {
                        _uiEvent.send(UiEvent.ShowSnackbar(data.msg))
                    }

                    is Resource.Loading -> {
                        // TODO Handle loading effect
                    }

                    is Resource.Success -> {
                        _uiEvent.send(UiEvent.Success)
                    }
                }
            }
        }
    }

    private fun sendPhoneNumberVerification(activity: Activity) {
        viewModelScope.launch {
            loginUseCases.sendPhoneNumberVerification(activity, phone = _sharedState.value.phone)
                .collectLatest {
                    when (it) {
                        is Resource.Failure -> {
                            _sharedState.value = _sharedState.value.copy(
                                isContinueButtonActive = true
                            )
                            _uiEvent.send(UiEvent.ShowSnackbar(it.msg))
                        }

                        is Resource.Loading -> {
                            _sharedState.value = _sharedState.value.copy(
                                isContinueButtonActive = false
                            )
                        }

                        is Resource.Success -> {
                            _sharedState.value = _sharedState.value.copy(
                                isContinueButtonActive = true
                            )
                            _uiEvent.send(UiEvent.Success)
                        }
                    }
                }
        }
    }
}

