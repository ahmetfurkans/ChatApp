package com.galataapplab.chatapp.phonePicker

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.LocalTextStyle
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import com.galataapplab.chatapp.core.presentation.theme.Shapes
import com.galataapplab.chatapp.core.presentation.theme.placeHolderColor

@Composable
private fun CustomTextField(
    value: String = "",
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    leadingIcon: (@Composable () -> Unit)? = null,
    trailingIcon: (@Composable () -> Unit)? = null,
    placeholderText: String = "Placeholder",
    textStyle: TextStyle = MaterialTheme.typography.body1
) {
    BasicTextField(
        modifier = Modifier
            .fillMaxWidth()
            .background(shape = RoundedCornerShape(4.dp), color = Color(0xFFF7F7FC)),
        value = value,
        onValueChange = {
            onValueChange(it)
        },
        singleLine = true,
        cursorBrush = SolidColor(MaterialTheme.colors.primary),
        textStyle = textStyle,
        decorationBox = { innerTextField ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier
            ) {
                if (leadingIcon != null) leadingIcon()
                Box(Modifier.weight(1f)) {
                    if (value.isEmpty()) Text(
                        placeholderText,
                        style = textStyle.copy(color = MaterialTheme.colors.placeHolderColor)
                    )
                    innerTextField()
                }
                if (trailingIcon != null) trailingIcon()
            }
        })
}

@Composable
fun SearchWidget(
    value: String = "",
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    onCloseClicked: () -> Unit,
    placeholderText: String = "Search here...",
) {
    CustomTextField(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 6.dp),
        value = value,
        placeholderText = placeholderText,
        onValueChange = { onValueChange(it) },
        leadingIcon = {
            Icon(
                modifier = Modifier
                    .alpha(alpha = ContentAlpha.medium),
                imageVector = Icons.Default.Search,
                contentDescription = "search icon",
                tint = MaterialTheme.colors.placeHolderColor
            )
        },
        trailingIcon = {
            Icon(
                modifier = Modifier.clickable {
                    if (value.isNotEmpty()) {
                        onValueChange("")
                    } else {
                        onCloseClicked()
                    }
                },
                imageVector = Icons.Default.Close,
                contentDescription = "close icon",
                tint = MaterialTheme.colors.placeHolderColor
            )
        })
}