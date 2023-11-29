package com.galataapplab.chatapp.presentation.login

import android.annotation.SuppressLint
import android.app.Activity
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.galataapplab.chatapp.core.presentation.components.PrimaryButton
import com.galataapplab.chatapp.core.presentation.components.TransparentAppBar
import com.galataapplab.chatapp.core.presentation.components.TransparentHintTextField
import com.galataapplab.chatapp.core.presentation.theme.LocalSpacing
import com.galataapplab.chatapp.core.util.Routes
import com.galataapplab.chatapp.core.util.UiEvent
import kotlinx.coroutines.flow.collectLatest

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun LoginScreen(
    navController: NavController, viewModel: LoginViewModel = hiltViewModel()
) {

    val spacing = LocalSpacing.current
    val scaffoldState = rememberScaffoldState()
    val activity = LocalContext.current as Activity
    val sharedState = viewModel.sharedState.collectAsState()

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
                    navController.navigate(Routes.VERIFY)
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
                text = "Enter Your Phone Number",
                style = MaterialTheme.typography.h2,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colors.onSurface,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(spacing.spaceSmall))
            Text(
                text = "Please confirm your country code and enter\n your phone number",
                style = MaterialTheme.typography.body2,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colors.onSurface,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(spacing.spaceExtraLarge))
            TransparentHintTextField(value = sharedState.value.phone,
                hint = "Phone Number",
                onValueChange = {
                    viewModel.onEvent(LoginEvent.OnPhoneNumberChange(it))
                })
            Spacer(modifier = Modifier.height(spacing.spaceExtraLarge))
            PrimaryButton(
                onClick = { viewModel.onEvent(LoginEvent.OnContinueClick(activity)) },
                text = "Continue",
                isActive = sharedState.value.isContinueButtonActive
            )
        }
    }

}