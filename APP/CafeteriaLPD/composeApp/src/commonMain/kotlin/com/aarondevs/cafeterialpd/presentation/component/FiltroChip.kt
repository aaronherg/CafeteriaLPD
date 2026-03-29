package com.aarondevs.cafeterialpd.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FiltroChip(
    titulo: String,
    cantidad: Int,
    seleccionado: Boolean,
    borderBrush: Brush,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .padding(end = 6.dp)
            .height(32.dp)
            .clip(RoundedCornerShape(18.dp))
            .background(Color.Transparent)
            .border(
                width = 1.3.dp,
                brush = borderBrush,
                shape = RoundedCornerShape(18.dp)
            )
            .clickable { onClick() }
    ) {

        Row(
            modifier = Modifier
                .fillMaxHeight()
                .padding(start = 12.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = titulo,
                fontSize = 10.sp,
                fontWeight = FontWeight.Medium,
                color = if (seleccionado) Color.White else Color.White.copy(alpha = 0.85f),
                maxLines = 1
            )

            Spacer(modifier = Modifier.width(6.dp))

            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .clip(
                        RoundedCornerShape(
                            topStart = 6.dp,
                            bottomStart = 6.dp,
                            topEnd = 18.dp,
                            bottomEnd = 18.dp
                        )
                    )
                    .background(
                        if (cantidad > 0) {
                            borderBrush
                        } else {
                            Brush.verticalGradient(
                                listOf(
                                    Color.Gray.copy(alpha = 0.4f),
                                    Color.Gray.copy(alpha = 0.2f)
                                )
                            )
                        }
                    )
                    .padding(horizontal = 7.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = cantidad.toString(),
                    fontSize = 9.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
        }
    }
}