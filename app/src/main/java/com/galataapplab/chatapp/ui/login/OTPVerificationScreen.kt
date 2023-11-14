package com.galataapplab.chatapp.ui.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import com.galataapplab.chatapp.core.ui.components.TransparentAppBar
import com.galataapplab.chatapp.core.ui.theme.LocalSpacing
import com.galataapplab.chatapp.ui.login.components.OTPInput

@Composable
fun OTPVerificationScreen(navController: NavController) {

    val spacing = LocalSpacing.current
    val phoneNumber = "+62 130917101920"

    val otpCode = remember {
        mutableStateOf("")
    }

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
            text = "We have sent you an SMS with the code \nto $phoneNumber",
            style = MaterialTheme.typography.body2,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colors.onSurface,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(spacing.spaceExtraLarge))
        OTPInput(onValueChanged = {
            otpCode.value = it
        }, value = otpCode.value)
        Spacer(modifier = Modifier.height(spacing.spaceExtraLarge))
        Text(text = "Resend Code",
            color = MaterialTheme.colors.primaryVariant,
            style = MaterialTheme.typography.subtitle2,
            modifier = Modifier.clickable { TODO() })
    }
}