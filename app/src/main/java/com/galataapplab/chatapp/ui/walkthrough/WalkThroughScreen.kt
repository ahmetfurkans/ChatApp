package com.galataapplab.chatapp.ui.walkthrough

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import com.galataapplab.chatapp.R.drawable.ic_walkthrough
import com.galataapplab.chatapp.core.ui.components.PrimaryButton
import com.galataapplab.chatapp.core.ui.theme.LocalSpacing

@Composable
fun WalkthroughScreen(
    onNextClick: () -> Unit
) {

    val spacing = LocalSpacing.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                top = spacing.spaceExtraLarge,
                bottom = spacing.spaceLarge,
                end = spacing.spaceLarge,
                start = spacing.spaceLarge
            ),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column {
            Image(
                painter = painterResource(ic_walkthrough), contentDescription = null
            )
            Spacer(modifier = Modifier.height(spacing.spaceLarge))
            Text(
                text = "Connect easily with \nyour family and friends \nover countries",
                style = MaterialTheme.typography.h2,
                color = MaterialTheme.colors.onSurface,
                textAlign = TextAlign.Center
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Terms & Privacy Policy",
                style = MaterialTheme.typography.body1,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colors.onSurface,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(spacing.spaceMedium))
            PrimaryButton(onClick = { onNextClick() }, text = "Start Messaging")
        }
    }
}