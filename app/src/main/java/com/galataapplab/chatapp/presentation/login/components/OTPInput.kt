package com.galataapplab.chatapp.presentation.login.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@OptIn(ExperimentalComposeUiApi::class, ExperimentalFoundationApi::class)
@Composable
fun OTPInput(
    modifier: Modifier = Modifier,
    cellModifier: Modifier = Modifier
        .width(44.dp)
        .height(44.dp)
        .background(
            color = MaterialTheme.colors.secondary, shape = CircleShape
        ),
    spacerModifier: Modifier = Modifier.size(16.dp),
    length: Int = 6,
    value: String = "",
    onValueChanged: (String) -> Unit,
    disableKeypad: Boolean = false,
    cursorVisibleOnlyOnFocus: Boolean = false,
    sendOTP: () -> Unit
) {

    val focusRequester = remember { FocusRequester() }
    val keyboard = LocalSoftwareKeyboardController.current
    val isFocused = remember { mutableStateOf(false) }

    TextField(
        readOnly = disableKeypad, value = value, onValueChange = {
            if (it.length <= length) {
                if (it.all { c -> c in '0'..'9' }) {
                    onValueChanged(it)
                }
                if (it.length >= length) {
                    keyboard?.hide()
                    sendOTP()
                }
            }
        },
        // Hide the text field
        modifier = Modifier
            .size(0.dp)
            .focusRequester(focusRequester)
            .onFocusChanged {
                isFocused.value = it.isFocused
            }, keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Number
        )
    )

    Row(
        modifier = modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center
    ) {
        repeat(length) {
            OTPCell(
                modifier = cellModifier
                    .onFocusChanged { focusRequester.requestFocus() }
                    .clickable { keyboard?.show() },
                value = value.getOrNull(it),
                isCursorVisible = !disableKeypad && (isFocused.value || !cursorVisibleOnlyOnFocus) && value.length == it
            )
            if (it != length - 1) Spacer(modifier = spacerModifier)
        }
    }
}

@Composable
fun OTPCell(
    modifier: Modifier, value: Char?, isCursorVisible: Boolean = false
) {

    val scope = rememberCoroutineScope()
    val (cursorSymbol, setCursorSymbol) = remember { mutableStateOf("") }

    LaunchedEffect(key1 = cursorSymbol, isCursorVisible) {
        if (isCursorVisible) {
            scope.launch {
                delay(350)
                setCursorSymbol(if (cursorSymbol.isEmpty()) "|" else "")
            }
        }
    }

    Box(
        modifier = modifier, contentAlignment = Alignment.Center
    ) {
        Text(
            text = if (isCursorVisible) cursorSymbol else value?.toString() ?: "",
            modifier = modifier.align(Alignment.Center),
            style = MaterialTheme.typography.h1,
            textAlign = TextAlign.Center
        )
    }
}

