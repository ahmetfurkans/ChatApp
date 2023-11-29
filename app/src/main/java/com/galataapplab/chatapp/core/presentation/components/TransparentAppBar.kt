package com.galataapplab.chatapp.core.presentation.components

import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.LocalMinimumTouchTargetEnforcement
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun TransparentAppBar(onNavigateUp: () -> Unit, title: String? = null) {
    CompositionLocalProvider(LocalMinimumTouchTargetEnforcement provides false) {
        TopAppBar(title = {
            if (!title.isNullOrBlank()) {
                Text(text = "Your profile", color = MaterialTheme.colors.onBackground)
            }
        }, navigationIcon = {
            IconButton(onClick = { onNavigateUp() }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBackIos,
                    contentDescription = "Navigate Up",
                    tint = MaterialTheme.colors.onBackground
                )
            }
        }, backgroundColor = Color.Transparent, contentColor = Color.White, elevation = 0.dp
        )
    }
}