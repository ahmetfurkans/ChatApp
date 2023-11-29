package com.galataapplab.chatapp.presentation.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.galataapplab.chatapp.R
import com.galataapplab.chatapp.core.presentation.components.PrimaryButton
import com.galataapplab.chatapp.core.presentation.components.TransparentAppBar
import com.galataapplab.chatapp.core.presentation.components.TransparentHintTextField
import com.galataapplab.chatapp.core.presentation.theme.LocalSpacing

@Composable
fun ProfileScreen(navController: NavHostController) {

    val spacing = LocalSpacing.current
    val userImgUrl =
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR7b-j2EbJOuBJGhWA1FV0Z6RdDuL2rA4wFdw&usqp=CAU"
    val nullImg: String? = ""

    // TODO dummy text
    val value = remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(
                spacing.spaceMedium
            ), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TransparentAppBar(title = "Your Profile", onNavigateUp = { navController.navigateUp() })
        Spacer(modifier = Modifier.height(32.dp))
        if (nullImg.isNullOrEmpty()) {
            Image(
                painter = painterResource(id = R.drawable.ic_empty_avatar),
                contentDescription = null
            )
        }
        Spacer(modifier = Modifier.height(spacing.spaceLarge))
        TransparentHintTextField(
            onValueChange = { value.value = it },
            value = value.value,
            hint = "First Name (Required)"
        )
        Spacer(modifier = Modifier.height(spacing.spaceMedium))
        TransparentHintTextField(
            onValueChange = { value.value = it },
            value = value.value,
            hint = "Last Name (Optional)"
        )
        Spacer(modifier = Modifier.height(spacing.spaceExtraLarge))
        PrimaryButton(onClick = { /*TODO*/ }, text = "Save")
    }
}