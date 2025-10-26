package com.pixaplace.ui.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.theme.WhiteLabelColors

@Composable
fun PrimaryButton(
    text: String,
    enabled: Boolean = true,
    loading: Boolean = false,
    onClick: () -> Unit
) {
    val colors = WhiteLabelColors

    Button(
        onClick = onClick,
        enabled = enabled && !loading,
        shape = MaterialTheme.shapes.large, // uses global shape
        elevation = ButtonDefaults.elevatedButtonElevation(defaultElevation = 4.dp, pressedElevation = 6.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = colors.Primary,
            contentColor = colors.OnPrimary,
            disabledContainerColor = colors.Primary.copy(alpha = 0.3f),
            disabledContentColor = colors.OnPrimary.copy(alpha = 0.5f)
        ),
        contentPadding = PaddingValues(horizontal = 24.dp, vertical = 14.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        if (loading) {
            CircularProgressIndicator(
                color = colors.OnPrimary,
                strokeWidth = 2.dp,
                modifier = Modifier.size(20.dp)
            )
        } else {
            Text(
                text = text,
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = FontWeight.Medium,
                    color = colors.OnPrimary
                )
            )
        }
    }
}
