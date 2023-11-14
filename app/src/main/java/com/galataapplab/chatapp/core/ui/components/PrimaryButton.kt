package com.galataapplab.chatapp.core.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.galataapplab.chatapp.core.ui.theme.LightGrey

@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier, onClick: () -> Unit, text: String
) {
    TextButton(
        onClick = { onClick() }, modifier = modifier
            .background(
                shape = RoundedCornerShape(30.dp), color = MaterialTheme.colors.primary
            )
            .padding(vertical = 2.dp, horizontal = 94.dp)
    ) {
        Text(
            text = text,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.subtitle2,
            color = LightGrey
        )
    }

}