package com.galataapplab.chatapp.ui.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavController
import com.galataapplab.chatapp.core.ui.components.PrimaryButton
import com.galataapplab.chatapp.core.ui.components.TransparentAppBar
import com.galataapplab.chatapp.core.ui.theme.LocalSpacing
import com.galataapplab.chatapp.core.util.Routes
import com.galataapplab.chatapp.ui.login.components.PhoneNumberInput
import com.galataapplab.chatapp.ui.profile.components.TransparentHintTextField

@Composable
fun LoginScreen(navController: NavController) {

    val spacing = LocalSpacing.current


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
        TransparentHintTextField(
            value = "",
            hint = "Phone Number",
            onValueChange = {})
        Spacer(modifier = Modifier.height(spacing.spaceExtraLarge))
        // TODO if authentication return true value then navigate
        PrimaryButton(onClick = { navController.navigate(Routes.VERIFY) }, text = "Continue")
    }

}