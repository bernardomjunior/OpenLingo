package com.bernardomjunior.openlingo.ui.teste

import android.content.res.Configuration
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.bernardomjunior.openlingo.ui.theme.OpenLingoTheme
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

@Composable
internal fun LoadingAnimation(
    size: Dp = 24.dp,
    circleSize: Dp = 4.dp
) {
    Box(
        modifier = Modifier
            .height(size)
            .width(size)
    ) {
        val loadingColor = OpenLingoTheme.colorScheme.onPrimary

        val infiniteTransition = rememberInfiniteTransition(label = "")

        val loadingProgress by infiniteTransition.animateFloat(
            initialValue = (0 * PI).toFloat(),
            targetValue = (2 * PI).toFloat(),
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = 1500,
                    easing = FastOutSlowInEasing
                )
            ),
            label = "",
        )

        val loadingPosition by remember(loadingProgress) {
            val length = (size - (circleSize * 2)) / 2
            val x = length + (length * cos(loadingProgress))
            val y = length + (length * sin(loadingProgress))

            mutableStateOf(Pair(x,y))
        }



        Canvas(modifier = Modifier.fillMaxSize()) {
//            drawArc(
//                color = loadingColor,
//                startAngle = 0f,
//                sweepAngle = 180 * loadingProgress,
//                useCenter = false,
//                style = Stroke(
//                    width = 4.dp.toPx(),
//                    cap = StrokeCap.Butt
//                ),
//                size = Size(size.width, size.height)
//            )
            drawCircle(
                color = loadingColor,
                radius = circleSize.toPx(),
                center = Offset(
                    x = (loadingPosition.first + circleSize).toPx(),
                    y = (loadingPosition.second + circleSize).toPx()
                )
            )
        }
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun LoadingAnimationPreview() {
    OpenLingoTheme {
        Surface {
            LoadingAnimation()
        }
    }
}