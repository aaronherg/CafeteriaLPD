package com.aarondevs.cafeterialpd.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Counter(
    cantidad: Int,
    onChange: (Int) -> Unit,
    modifier: Modifier = Modifier
) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .clip(RoundedCornerShape(50))
            .border(
                0.8.dp,
                Color.White.copy(alpha = 0.15f),
                RoundedCornerShape(50)
            )
            .background(Color.White.copy(alpha = 0.04f))
    ) {

        Box(
            modifier = Modifier
                .fillMaxHeight()
                .heightIn(min = 28.dp)
                .width(28.dp)
                .clip(RoundedCornerShape(topStart = 50.dp, bottomStart = 50.dp))
                .background(
                    Brush.verticalGradient(
                        listOf(Color(0xFFE53935), Color(0xFFD32F2F))
                    )
                )
                .clickable {
                    if (cantidad > 0) onChange(cantidad - 1)
                },
            contentAlignment = Alignment.Center
        ) {
            Text("−", color = Color.White, fontSize = 12.sp, fontWeight = FontWeight.Bold)
        }

        Text(
            text = cantidad.toString(),
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 6.dp),
            color = Color.White,
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center
        )

        Box(
            modifier = Modifier
                .fillMaxHeight()
                .heightIn(min = 28.dp)
                .width(28.dp)
                .clip(RoundedCornerShape(topEnd = 50.dp, bottomEnd = 50.dp))
                .background(
                    Brush.verticalGradient(
                        listOf(Color(0xFF43A047), Color(0xFF2E7D32))
                    )
                )
                .clickable { onChange(cantidad + 1) },
            contentAlignment = Alignment.Center
        ) {
            Text("+", color = Color.White, fontSize = 12.sp, fontWeight = FontWeight.Bold)
        }
    }
}