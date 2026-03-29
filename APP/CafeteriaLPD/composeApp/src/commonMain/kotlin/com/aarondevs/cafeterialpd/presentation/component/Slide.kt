package com.aarondevs.cafeterialpd.presentation.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.gestures.waitForUpOrCancellation
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun Slide(
    title: String,
    estado: Boolean,
    direction: String = "RIGHT",
    borderColor: Brush,
    horizontalPadding: Int = 12,
    fontSize: Int = 15,
    height: Int = 48,
    icon: DrawableResource,
    onSlide: () -> Unit = {},
    onComplete: () -> Unit = {},
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier
) {

    val density = LocalDensity.current

    val slideHeight = height.dp
    val bubbleSize = slideHeight
    val borderRadius = slideHeight / 2

    var containerWidthPx by remember { mutableStateOf(0f) }

    val maxOffset = remember(containerWidthPx) {
        if (containerWidthPx == 0f) 0f
        else containerWidthPx - with(density) { bubbleSize.toPx() }
    }

    var offsetX by remember {
        mutableStateOf(
            if (direction.uppercase() == "LEFT") maxOffset else 0f
        )
    }

    var completed by remember { mutableStateOf(false) }
    var hasDragged by remember { mutableStateOf(false) }
    var bloqueadoHastaSoltar by remember { mutableStateOf(false) }

    LaunchedEffect(direction, maxOffset, estado) {
        if (maxOffset > 0f) {
            offsetX = if (direction.uppercase() == "LEFT") maxOffset else 0f
            completed = false
            hasDragged = false
            bloqueadoHastaSoltar = false
        }
    }

    val progress =
        if (maxOffset == 0f) 0f else (offsetX / maxOffset).coerceIn(0f, 1f)

    val textAlignment = when (direction.uppercase()) {
        "RIGHT" -> if (progress < 0.5f) Alignment.CenterEnd else Alignment.CenterStart
        "LEFT" -> if (progress > 0.5f) Alignment.CenterStart else Alignment.CenterEnd
        else -> Alignment.Center
    }

    val disabledAlpha = if (estado) 1f else 0.4f

    val effectiveBorderBrush =
        if (estado) borderColor
        else Brush.linearGradient(
            listOf(
                Color(0xFF9E9E9E).copy(alpha = 0.1f),
                Color(0xFF757575).copy(alpha = 0.1f)
            )
        )

    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(slideHeight)
            .onSizeChanged { containerWidthPx = it.width.toFloat() }
            .border(
                BorderStroke(2.dp, effectiveBorderBrush),
                RoundedCornerShape(borderRadius)
            )
            .background(Color.Transparent, RoundedCornerShape(borderRadius))
            .alpha(disabledAlpha)
            .pointerInput(Unit) {
                awaitPointerEventScope {
                    while (true) {
                        awaitFirstDown(requireUnconsumed = false)
                        bloqueadoHastaSoltar = false

                        onClick()
                        waitForUpOrCancellation()
                    }
                }
            }
    ) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = horizontalPadding.dp),
            contentAlignment = textAlignment
        ) {
            Text(
                text = title,
                color = Color.White.copy(alpha = 0.3f),
                fontSize = fontSize.sp,
                maxLines = 1
            )
        }

        Box(
            modifier = Modifier
                .offset {
                    val newOffset = offsetX.coerceIn(0f, maxOffset)

                    val reachedEnd =
                        (direction.uppercase() == "RIGHT" && newOffset >= maxOffset) ||
                                (direction.uppercase() == "LEFT" && newOffset <= 0f)

                    if (
                        estado &&
                        hasDragged &&
                        !completed &&
                        reachedEnd &&
                        !bloqueadoHastaSoltar
                    ) {
                        completed = true
                        onComplete()
                        offsetX = if (direction.uppercase() == "LEFT") maxOffset else 0f

                        bloqueadoHastaSoltar = true
                        hasDragged = false
                        completed = false
                    }

                    IntOffset(newOffset.toInt(), 0)
                }
                .size(bubbleSize)
                .background(
                    brush = effectiveBorderBrush,
                    shape = RoundedCornerShape(borderRadius)
                )
                .pointerInput(estado) {
                    if (estado) {
                        detectHorizontalDragGestures { change, dragAmount ->

                            if (bloqueadoHastaSoltar) return@detectHorizontalDragGestures

                            hasDragged = true
                            offsetX += dragAmount
                            change.consume()
                            onSlide()
                        }
                    }
                },
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(icon),
                contentDescription = null,
                modifier = Modifier.size(bubbleSize * 0.45f)
            )
        }
    }
}

