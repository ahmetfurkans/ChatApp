package com.galataapplab.chatapp.ui.login.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.galataapplab.chatapp.core.ui.theme.Shapes

@Composable
fun PhoneNumberInput(
    modifier: Modifier = Modifier, phoneNumber: String, onValueChange: (String) -> Unit
) {
    val keyboardOptions = KeyboardOptions.Default.copy(
        keyboardType = KeyboardType.Phone
    )

    Box(
        modifier = modifier
            .fillMaxWidth()
            .shadow(8.dp, shape = Shapes.small)
            .background(MaterialTheme.colors.surface, shape = Shapes.small),
    ) {
        BasicTextField(
            value = phoneNumber,
            onValueChange = { onValueChange(it) },
            keyboardOptions = keyboardOptions,
            textStyle = MaterialTheme.typography.body1,
            modifier = Modifier.padding(
                    horizontal = 12.dp, vertical = 8.dp
                ),
        )
        if (phoneNumber.isEmpty()) {
            Text(
                text = "Phone Number",
                style = MaterialTheme.typography.body1,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        horizontal = 12.dp, vertical = 8.dp
                    ),
            )
        }
    }
}
