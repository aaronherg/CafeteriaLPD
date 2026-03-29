package com.aarondevs.cafeterialpd.librery

import androidx.compose.animation.core.Animatable
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.withFrameNanos
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer

@Composable
fun AnimDesplazarIzquierda(
    animar: Boolean,
    duracionMs: Int,
    onFin: () -> Unit = {},
    content: @Composable (Modifier) -> Unit
) {
    val offsetX = remember { Animatable(0f) }

    LaunchedEffect(animar) {
        if (animar) {
            offsetX.snapTo(0f)

            val duracion = duracionMs
            val startTime = withFrameNanos { it }

            while (true) {
                val currentTime = withFrameNanos { it }
                val elapsed = (currentTime - startTime) / 1_000_000

                val progress = (elapsed / duracion.toFloat()).coerceIn(0f, 1f)

                val value = -1500f * progress
                offsetX.snapTo(value)

                if (progress >= 1f) break
            }

            onFin()
        }
    }

    content(
        Modifier.graphicsLayer {
            translationX = offsetX.value
        }
    )
}




@Composable
fun AnimDesplazarDerecha(
    animar: Boolean,
    duracionMs: Int,
    onFin: () -> Unit = {},
    content: @Composable (Modifier) -> Unit
) {
    val offsetX = remember { Animatable(0f) }

    LaunchedEffect(animar) {
        if (animar) {
            offsetX.snapTo(0f)

            val duracion = duracionMs
            val startTime = withFrameNanos { it }

            while (true) {
                val currentTime = withFrameNanos { it }
                val elapsed = (currentTime - startTime) / 1_000_000

                val progress = (elapsed / duracion.toFloat()).coerceIn(0f, 1f)

                val value = 1500f * progress
                offsetX.snapTo(value)

                if (progress >= 1f) break
            }

            onFin()
        }
    }

    content(
        Modifier.graphicsLayer {
            translationX = offsetX.value
        }
    )
}



@Composable
fun AnimDesvanecer(
    animar: Boolean,
    duracionMs: Int,
    onFin: () -> Unit = {},
    content: @Composable (Modifier) -> Unit
) {
    val alpha = remember { Animatable(1f) }

    LaunchedEffect(animar) {
        if (animar) {
            alpha.snapTo(1f)

            val duracion = duracionMs
            val startTime = withFrameNanos { it }

            while (true) {
                val currentTime = withFrameNanos { it }
                val elapsed = (currentTime - startTime) / 1_000_000

                val progress = (elapsed / duracion.toFloat()).coerceIn(0f, 1f)

                val value = 1f - progress
                alpha.snapTo(value)

                if (progress >= 1f) break
            }

            onFin()
        }
    }

    content(
        Modifier.graphicsLayer {
            this.alpha = alpha.value
        }
    )
}



@Composable
fun AnimProfundidad(
    animar: Boolean,
    duracionMs: Int = 800,
    onFin: () -> Unit = {},
    content: @Composable (Modifier) -> Unit
) {
    val progress = remember { Animatable(0f) }

    LaunchedEffect(animar) {
        if (animar) {
            progress.snapTo(0f)

            val duracion = duracionMs
            val startTime = withFrameNanos { it }

            while (true) {
                val currentTime = withFrameNanos { it }
                val elapsed = (currentTime - startTime) / 1_000_000

                val p = (elapsed / duracion.toFloat()).coerceIn(0f, 1f)
                progress.snapTo(p)

                if (p >= 1f) break
            }

            onFin()
        }
    }

    content(
        Modifier.graphicsLayer {
            val scale = 1f - 0.9f * progress.value
            scaleX = scale
            scaleY = scale

            transformOrigin = TransformOrigin(0.5f, 0.5f)

            alpha = 1f - progress.value
        }
    )
}