package com.bernardomjunior.openlingo.components

import android.content.res.Configuration
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.bernardomjunior.openlingo.ui.theme.OpenLingoTheme

@Composable
internal fun TextButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    isEnabled: Boolean = true,
    isLoading: Boolean = false
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = isEnabled
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = text
            )
        }
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun TextButtonPreview() {
    OpenLingoTheme {
        Surface {
            TextButton(
                text = "Exemplo",
                onClick = {}
            )
        }
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun TextButtonPreviewDisabled() {
    OpenLingoTheme {
        Surface {
            TextButton(
                text = "Exemplo",
                isEnabled = false,
                onClick = {}
            )
        }
    }
}