package com.galataapplab.chatapp.core.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.galataapplab.chatapp.core.presentation.theme.Shapes

@Composable
fun TransparentHintTextField(
    modifier: Modifier = Modifier,
    hint: String = "",
    value: String = "",
    onValueChange: (String) -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .shadow(8.dp, shape = Shapes.small)
            .background(MaterialTheme.colors.surface, shape = Shapes.small),
    ) {
        BasicTextField(
            value = value,
            onValueChange = { onValueChange(it) },
            textStyle = MaterialTheme.typography.body1,
            modifier = Modifier.padding(
                horizontal = 12.dp, vertical = 12.dp
            ),
        )
        if (value.isEmpty()) {
            Text(
                text = hint,
                style = MaterialTheme.typography.body1,
                color = Color(0xFFADB5BD),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 12.dp, vertical = 12.dp
                    ),
            )
        }
    }
}