package com.galataapplab.chatapp.core.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.galataapplab.chatapp.core.presentation.theme.LightGrey
import com.galataapplab.chatapp.core.presentation.theme.inactivePrimaryButton
import com.galataapplab.chatapp.core.presentation.theme.primaryButton

@Composable
fun PrimaryButton(
    modifier: Modifier = Modifier, onClick: () -> Unit, text: String, isActive: Boolean = true
) {

    val buttonColor =
        if (isActive) MaterialTheme.colors.primaryButton else MaterialTheme.colors.inactivePrimaryButton

    TextButton(
        onClick = {
            if (isActive) onClick()
        }, modifier = modifier
            .background(
                shape = RoundedCornerShape(30.dp), color = buttonColor
            )
            .fillMaxWidth()
    ) {
        Text(
            text = text,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.subtitle2,
            color = LightGrey
        )
    }

}