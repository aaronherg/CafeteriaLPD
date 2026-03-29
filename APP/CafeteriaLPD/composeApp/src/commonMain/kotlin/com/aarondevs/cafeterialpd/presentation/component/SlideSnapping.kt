package com.aarondevs.cafeterialpd.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectHorizontalDragGestures
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.*
import kotlin.math.roundToInt

data class SlideState(
    val label: String
)

@Composable
fun SlideSnapping(
    states: List<SlideState>,
    currentIndex: Int,
    onStateChange: (Int) -> Unit,
    modifier: Modifier = Modifier,
    bubbleSize: Dp = 22.dp,
    borderColor: Brush = Brush.horizontalGradient(
        listOf(Color(0xFF4ADE80), Color(0xFFA7F3D0))
    ),
    fontSize: Int = 9,
) {

    require(states.size > 1)

    val density = LocalDensity.current

    var widthPx by remember { mutableStateOf(0f) }
    var offsetX by remember { mutableStateOf(0f) }

    val steps = states.size - 1
    val bubblePx = with(density) { bubbleSize.toPx() }

    val maxOffset = if (widthPx == 0f) 0f else widthPx - bubblePx
    val stepWidth = if (steps > 0) maxOffset / steps else 0f

    var lastIndex by remember { mutableStateOf(currentIndex) }

    LaunchedEffect(widthPx, currentIndex) {
        if (widthPx > 0f) {
            offsetX = stepWidth * currentIndex.coerceIn(0, states.lastIndex)
            lastIndex = currentIndex
        }
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
            .height(44.dp) // 🔥 ALTURA REAL CONTROLADA
            .onSizeChanged { widthPx = it.width.toFloat() },
        verticalArrangement = Arrangement.Center
    ) {

        // 🔹 TRACK + PROGRESS + BUBBLE
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(22.dp),
            contentAlignment = Alignment.CenterStart
        ) {

            // Línea base
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(3.dp)
                    .background(Color.Gray.copy(alpha = 0.25f), RoundedCornerShape(50))
            )

            // Progreso
            Box(
                modifier = Modifier
                    .height(3.dp)
                    .width(with(density) { (offsetX + bubblePx / 2f).toDp() })
                    .background(borderColor, RoundedCornerShape(50))
            )

            // 🔘 BUBBLE
            Box(
                modifier = Modifier
                    .offset { IntOffset(offsetX.roundToInt(), 0) }
                    .size(bubbleSize)
                    .background(borderColor, RoundedCornerShape(50))
                    .pointerInput(Unit) {
                        detectHorizontalDragGestures(
                            onHorizontalDrag = { _, dragAmount ->
                                offsetX = (offsetX + dragAmount)
                                    .coerceIn(0f, maxOffset)
                            },
                            onDragEnd = {

                                val index = if (stepWidth == 0f) 0 else
                                    (offsetX / stepWidth)
                                        .roundToInt()
                                        .coerceIn(0, states.lastIndex)

                                offsetX = stepWidth * index

                                if (index != lastIndex) {
                                    lastIndex = index
                                    onStateChange(index)
                                }
                            }
                        )
                    },
                contentAlignment = Alignment.Center
            ) {

                val index = if (stepWidth == 0f) 0 else
                    (offsetX / stepWidth).roundToInt().coerceIn(0, states.lastIndex)

                Text(
                    text = (index + 1).toString(),
                    fontSize = 10.sp,
                    color = Color.Black
                )
            }
        }

        Spacer(Modifier.height(4.dp))

        // 🔹 LABELS (compactos)
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            val currentStep = if (stepWidth == 0f) 0 else
                (offsetX / stepWidth).roundToInt().coerceIn(0, states.lastIndex)

            states.forEachIndexed { index, state ->

                val active = index <= currentStep

                Text(
                    text = state.label,
                    fontSize = fontSize.sp,
                    color = if (active) Color.Black else Color.Gray,
                    maxLines = 1
                )
            }
        }
    }
}

@Preview
@Composable
fun SlideSnappingPreview() {

    var index by remember { mutableStateOf(1) }

    val estados = listOf(
        SlideState("Pendiente"),
        SlideState("En Proceso"),
        SlideState("En Ruta"),
        SlideState("Entregado")
    )

    SlideSnapping(
        states = estados,
        currentIndex = index,
        onStateChange = { index = it },

        fontSize = 13,

        borderColor = Brush.horizontalGradient(
            listOf(Color(0xFF4ADE80), Color(0xFFA7F3D0))
        ),
    )
}