package com.aarondevs.cafeterialpd.presentation.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup
import cafeterialaparada.composeapp.generated.resources.Res
import cafeterialaparada.composeapp.generated.resources.ico_calendar
import com.aarondevs.binareus.ui.theme.VerdeModernoEnd
import com.aarondevs.binareus.ui.theme.VerdeModernoStart
import org.jetbrains.compose.resources.painterResource


@Composable
fun Calendar(
    label: String,
    selectedDate: String,
    onDateChange: (String) -> Unit,
    borderRadius: Int,
    borderColor: Brush,
    textSize: Int,
    verticalPadding: Int,
    modifier: Modifier = Modifier
) {

    var isOpen by remember { mutableStateOf(false) }

    var year by remember { mutableStateOf(2025) }
    var month by remember { mutableStateOf<Int?>(null) }

    val months = listOf(
        "Ene","Feb","Mar",
        "Abr","May","Jun",
        "Jul","Ago","Sep",
        "Oct","Nov","Dic"
    )

    val shape = RoundedCornerShape(borderRadius.dp)

    Box(
        modifier = modifier.fillMaxWidth()
    ) {

        // ================= INPUT =================
        Box(
            modifier = Modifier
                .border(2.dp, borderColor, shape)
                .clickable { isOpen = !isOpen }
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = verticalPadding.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(
                    text = if (selectedDate.isNotEmpty()) selectedDate else label,
                    fontSize = textSize.sp,
                    color = Color.Gray,
                    modifier = Modifier.weight(1f)
                )

                Image(
                    painter = painterResource(Res.drawable.ico_calendar),
                    contentDescription = null,
                    modifier = Modifier.size(20.dp)
                )
            }
        }

        // ================= POPUP REAL =================
        if (isOpen) {

            Popup(
                alignment = Alignment.TopStart,
                onDismissRequest = { isOpen = false }
            ) {

                Box(
                    modifier = Modifier
                        .padding(top = 60.dp)
                        .width(300.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(Color(0xFF0B0B0F).copy(alpha = 0.97f))
                        .border(
                            BorderStroke(
                                0.6.dp,
                                Brush.linearGradient(
                                    listOf(
                                        Color.White.copy(alpha = 0.08f),
                                        Color.Transparent
                                    )
                                )
                            )
                        )
                ) {

                    Column(
                        modifier = Modifier.padding(14.dp)
                    ) {

                        // ===== HEADER =====
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 10.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Text(
                                "‹",
                                fontSize = 18.sp,
                                color = Color.White.copy(alpha = 0.5f),
                                modifier = Modifier
                                    .clip(RoundedCornerShape(8.dp))
                                    .clickable {
                                        year--
                                        month = null
                                    }
                                    .padding(6.dp)
                            )

                            Text(
                                year.toString(),
                                fontSize = 15.sp,
                                color = Color.White,
                                fontWeight = FontWeight.Medium
                            )

                            Text(
                                "›",
                                fontSize = 18.sp,
                                color = Color.White.copy(alpha = 0.5f),
                                modifier = Modifier
                                    .clip(RoundedCornerShape(8.dp))
                                    .clickable {
                                        year++
                                        month = null
                                    }
                                    .padding(6.dp)
                            )
                        }

                        // ===== CONTENIDO =====
                        if (month == null) {

                            months.chunked(3).forEach { row ->
                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                                ) {
                                    row.forEach { m ->

                                        val realMonth = months.indexOf(m) + 1

                                        Box(
                                            modifier = Modifier
                                                .weight(1f)
                                                .aspectRatio(2f)
                                                .clip(RoundedCornerShape(10.dp))
                                                .background(Color.White.copy(alpha = 0.03f))
                                                .clickable { month = realMonth },
                                            contentAlignment = Alignment.Center
                                        ) {
                                            Text(
                                                m,
                                                color = Color.White.copy(alpha = 0.85f),
                                                fontSize = 12.sp
                                            )
                                        }
                                    }
                                }
                                Spacer(Modifier.height(8.dp))
                            }

                        } else {

                            val days = getDaysInMonth(year, month!!)

                            (1..days).toList().chunked(7).forEach { row ->

                                Row(
                                    modifier = Modifier.fillMaxWidth(),
                                    horizontalArrangement = Arrangement.spacedBy(6.dp)
                                ) {

                                    row.forEach { day ->

                                        val formatted =
                                            "$year-${month.toString().padStart(2,'0')}-${day.toString().padStart(2,'0')}"

                                        val isSelected = selectedDate == formatted

                                        Box(
                                            modifier = Modifier
                                                .weight(1f)
                                                .aspectRatio(1f)
                                                .clip(RoundedCornerShape(8.dp))
                                                .background(
                                                    if (isSelected)
                                                        Color.White.copy(alpha = 0.12f)
                                                    else
                                                        Color.White.copy(alpha = 0.03f)
                                                )
                                                .border(
                                                    if (isSelected)
                                                        BorderStroke(
                                                            0.8.dp,
                                                            Color.White.copy(alpha = 0.25f)
                                                        )
                                                    else BorderStroke(0.dp, Color.Transparent)
                                                )
                                                .clickable {
                                                    onDateChange(formatted)
                                                    isOpen = false
                                                    month = null
                                                },
                                            contentAlignment = Alignment.Center
                                        ) {
                                            Text(
                                                day.toString(),
                                                color = if (isSelected)
                                                    Color.White
                                                else
                                                    Color.White.copy(alpha = 0.75f),
                                                fontSize = 11.sp
                                            )
                                        }
                                    }

                                    repeat(7 - row.size) {
                                        Spacer(modifier = Modifier.weight(1f))
                                    }
                                }

                                Spacer(Modifier.height(6.dp))
                            }
                        }
                    }
                }
            }
        }
    }
}

fun getDaysInMonth(year: Int, month: Int): Int {
    return when (month) {
        1,3,5,7,8,10,12 -> 31
        4,6,9,11 -> 30
        2 -> if (isLeapYear(year)) 29 else 28
        else -> 30
    }
}

fun isLeapYear(year: Int): Boolean {
    return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)
}

@Preview
@Composable
fun CalendarPreview() {

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Calendar(
            label = "Fecha",
            selectedDate = "",
            onDateChange = { },
            borderRadius = 50,
            borderColor = Brush.horizontalGradient(listOf(VerdeModernoStart, VerdeModernoEnd)),
            textSize = 14,
            verticalPadding = 14
        )
    }
}