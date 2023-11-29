package com.galataapplab.chatapp.presentation.login

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.galataapplab.chatapp.core.presentation.components.TransparentAppBar
import com.galataapplab.chatapp.core.presentation.theme.LocalSpacing
import com.galataapplab.chatapp.core.util.Routes
import com.galataapplab.chatapp.core.util.UiEvent
import com.galataapplab.chatapp.presentation.login.components.OTPInput
import kotlinx.coroutines.flow.collectLatest

@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "UnrememberedGetBackStackEntry")
@Composable
fun OTPVerificationScreen(
    navController: NavController
) {

    val backStackEntry = remember {
        navController.getBackStackEntry(Routes.LOGIN)
    }

    val viewModel: LoginViewModel = hiltViewModel(backStackEntry)
    val sharedState = viewModel.sharedState.collectAsState()

    val spacing = LocalSpacing.current
    val scaffoldState = rememberScaffoldState()

    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collectLatest { event ->
            when (event) {
                is UiEvent.NavigateUp -> {
                    navController.navigateUp()
                }

                is UiEvent.ShowSnackbar -> {
                    scaffoldState.snackbarHostState.showSnackbar(
                        event.message
                    )
                }

                is UiEvent.Success -> {
                    navController.navigate(Routes.PROFILE)
                }
            }
        }
    }


    Scaffold(
        scaffoldState = scaffoldState
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    spacing.spaceMedium
                ), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TransparentAppBar(onNavigateUp = { navController.navigateUp() })
            Spacer(modifier = Modifier.height(spacing.spaceExtraLarge))
            Text(
                text = "Enter Code",
                style = MaterialTheme.typography.h2,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colors.onSurface,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(spacing.spaceSmall))
            Text(
                text = "We have sent you an SMS with the code \nto ${sharedState.value.phone}",
                style = MaterialTheme.typography.body2,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colors.onSurface,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(spacing.spaceExtraLarge))
            OTPInput(onValueChanged = {
                viewModel.onEvent(LoginEvent.OnOTPChange(it))
            },
                value = sharedState.value.otp,
                sendOTP = { viewModel.onEvent(LoginEvent.OnVerifyClick) })
            Spacer(modifier = Modifier.height(spacing.spaceExtraLarge))
            Text(text = "Resend Code",
                color = MaterialTheme.colors.primaryVariant,
                style = MaterialTheme.typography.subtitle2,
                modifier = Modifier.clickable { TODO() })
        }
    }
}