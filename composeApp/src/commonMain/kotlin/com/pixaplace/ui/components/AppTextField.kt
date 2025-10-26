package com.pixaplace.ui.components

import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText

@Composable
fun AppTextField(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    isPassword: Boolean = false,
    keyboardType: KeyboardType = KeyboardType.Text,
    enabled: Boolean = true,
    isError: Boolean = false,
    supportingText: String? = null
) {
    var passwordVisible by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        label = { Text(label, style = MaterialTheme.typography.bodyMedium) },
        singleLine = true,
        enabled = enabled,
        isError = isError,
        modifier = Modifier.fillMaxWidth(),
        textStyle = LocalTextStyle.current.copy(
            color = MaterialTheme.colorScheme.onSurface
        ),
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Next,
            keyboardType = when {
                isPassword -> KeyboardType.Password
                keyboardType == KeyboardType.Email -> KeyboardType.Email
                else -> KeyboardType.Text
            }
        ),
        visualTransformation = if (isPassword && !passwordVisible) AppPasswordVisualTransformation() else VisualTransformation.None,
        trailingIcon = {
            if (isPassword) {
                val image = if (passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                val description = if (passwordVisible) "Hide password" else "Show password"
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(
                        imageVector = image,
                        contentDescription = description,
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }
        },
        supportingText = supportingText?.let {
            {
                Text(
                    it,
                    color = if (isError) MaterialTheme.colorScheme.error else MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
        },
//        colors = OutlinedTextFieldDefaults.colors(
//            // Focused state
//            focusedBorderColor = MaterialTheme.colorScheme.primary,
//            focusedLabelColor = MaterialTheme.colorScheme.primary,
//            focusedIndicatorColor = MaterialTheme.colorScheme.primary,
//
//            // Unfocused state
//            unfocusedBorderColor = MaterialTheme.colorScheme.outline,
//            unfocusedLabelColor = MaterialTheme.colorScheme.onSurfaceVariant,
//
//            // Cursor
//            cursorColor = MaterialTheme.colorScheme.primary,
//
//            // Text
//            textColor = MaterialTheme.colorScheme.onSurface,
//
//            // Error state
//            errorBorderColor = MaterialTheme.colorScheme.error,
//            errorLabelColor = MaterialTheme.colorScheme.error,
//            errorCursorColor = MaterialTheme.colorScheme.error,
//
//            // Disabled
//            disabledBorderColor = MaterialTheme.colorScheme.outline.copy(alpha = 0.5f),
//            disabledTextColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f),
//            disabledLabelColor = MaterialTheme.colorScheme.onSurfaceVariant.copy(alpha = 0.5f)
//        ),
        shape = MaterialTheme.shapes.small
    )
}

private class AppPasswordVisualTransformation : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        return TransformedText(
            AnnotatedString("*".repeat(text.text.length)),

            /**
             * [OffsetMapping.Identity] is a predefined [OffsetMapping] that can be used for the
             * transformation that does not change the character count.
             */
            OffsetMapping.Identity
        )
    }
}
