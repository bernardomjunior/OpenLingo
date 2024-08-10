package com.bernardomjunior.openlingo.components

import android.content.res.Configuration
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bernardomjunior.openlingo.R
import com.bernardomjunior.openlingo.ui.teste.LoadingAnimation
import com.bernardomjunior.openlingo.ui.theme.OpenLingoTheme

@Composable
internal fun TextButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    @DrawableRes leftIcon:  Int? = null,
    leftIconContentDescription: String? = null,
    @DrawableRes rightIcon: Int? = null,
    rightIconContentDescription: String? = null,
    isEnabled: Boolean = true,
    isLoading: Boolean = false
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = isEnabled
    ) {
        Row{
            if (leftIcon != null) {
                Image(
                    painter = painterResource(id = leftIcon),
                    contentDescription = leftIconContentDescription,
                    modifier = Modifier
                        .height(24.dp)
                        .width(24.dp)
                )
            } else {
                Spacer(modifier = Modifier.width(24.dp))
            }

            Spacer(modifier = Modifier.weight(1f))

            if (isLoading) LoadingAnimation()
            else Text(
                text = text
            )

            Spacer(modifier = Modifier.weight(1f))

            if (rightIcon != null) {
                Image(
                    painter = painterResource(id = rightIcon),
                    contentDescription = rightIconContentDescription,
                    modifier = Modifier
                        .height(24.dp)
                        .width(24.dp)
                )
            } else {
                Spacer(modifier = Modifier.width(24.dp))
            }
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
                onClick = {},
                leftIcon = R.drawable.ic_launcher_background,
                rightIcon = R.drawable.ic_launcher_background,
                isLoading = true
            )
        }
    }
}