package com.aarondevs.cafeterialpd.presentation.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafeterialaparada.composeapp.generated.resources.Res
import cafeterialaparada.composeapp.generated.resources.ico_print
import cafeterialaparada.composeapp.generated.resources.ico_print_color
import com.aarondevs.binareus.ui.theme.VerdeModernoEnd
import com.aarondevs.binareus.ui.theme.VerdeModernoStart
import org.jetbrains.compose.resources.painterResource

data class PrinterDevice(
    val id: String,
    val nombre: String,
    val estado: String // "Disponible", "Conectada", "Desconectada"
)

@Composable
fun PrinterBluetooh(
    printers: List<PrinterDevice>,
    selectedId: String? = null,
    onSelected: (PrinterDevice) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    val selected = printers.find { it.id == selectedId }

    val selectedEstadoUI = when (selected?.estado) {
        "Disponible" -> "Conectada"
        else -> selected?.estado
    }

    val isActive = selectedEstadoUI == "Conectada"

    val borderBrush = if (isActive) {
        Brush.linearGradient(listOf(VerdeModernoStart, VerdeModernoEnd))
    } else {
        Brush.linearGradient(listOf(Color.Gray, Color.Gray.copy(alpha = 0.7f)))
    }

    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .animateContentSize()
        ) {

            Canvas(modifier = Modifier.matchParentSize()) {
                drawRoundRect(
                    brush = borderBrush,
                    style = Stroke(
                        width = 3f,
                        pathEffect = PathEffect.dashPathEffect(floatArrayOf(12f, 8f))
                    ),
                    cornerRadius = CornerRadius(40f, 40f)
                )
            }

            Column(modifier = Modifier.fillMaxWidth()) {

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(110.dp)
                        .clickable { expanded = !expanded },
                    contentAlignment = Alignment.Center
                ) {

                    Column(horizontalAlignment = Alignment.CenterHorizontally) {

                        Box(
                            modifier = Modifier.size(60.dp),
                            contentAlignment = Alignment.Center
                        ) {

                            Canvas(modifier = Modifier.matchParentSize()) {
                                drawCircle(
                                    brush = borderBrush,
                                    style = Stroke(
                                        width = 3f,
                                        pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 6f))
                                    )
                                )
                            }

                            Image(
                                painter = painterResource(
                                    if (selected == null)
                                        Res.drawable.ico_print
                                    else
                                        Res.drawable.ico_print_color
                                ),
                                contentDescription = null,
                                modifier = Modifier.size(28.dp)
                            )
                        }

                        Spacer(modifier = Modifier.height(6.dp))

                        if (selected != null) {

                            val estadoColor = when (selectedEstadoUI) {
                                "Conectada" -> VerdeModernoEnd
                                else -> Color.DarkGray
                            }

                            Text(
                                text = selected.nombre,
                                fontSize = 11.sp,
                                color = Color.White
                            )

                            Text(
                                text = selectedEstadoUI ?: "",
                                fontSize = 9.sp,
                                color = estadoColor
                            )
                        } else {
                            Text(
                                text = "Seleccionar impresora",
                                fontSize = 10.sp,
                                color = Color.Gray
                            )
                        }
                    }
                }

                AnimatedVisibility(visible = expanded) {

                    if (printers.isEmpty()) {

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 20.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "NO SE ENCUENTRAN DISPOSITIVOS",
                                color = Color.Gray,
                                fontSize = 11.sp
                            )
                        }

                    } else {

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(horizontal = 12.dp, vertical = 8.dp),
                            verticalArrangement = Arrangement.spacedBy(6.dp)
                        ) {

                            printers.forEachIndexed { index, device ->

                                val isDisponible = device.estado == "Disponible"
                                val isSelected = selected?.id == device.id
                                val isSelectable = device.estado == "Disponible"

                                Column {

                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .height(50.dp)
                                            .alpha(if (device.estado == "Desconectada") 0.5f else 1f)
                                            .clickable(enabled = isSelectable) {
                                                onSelected(device)
                                                expanded = false
                                            },
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {

                                        Column(modifier = Modifier.weight(1f)) {

                                            val estadoColor = when (device.estado) {
                                                "Conectada" -> VerdeModernoEnd
                                                "Disponible" -> VerdeModernoEnd
                                                else -> Color.Gray
                                            }

                                            Text(
                                                text = device.nombre,
                                                fontSize = 12.sp,
                                                color = Color.White
                                            )

                                            Text(
                                                text = device.estado,
                                                fontSize = 10.sp,
                                                color = estadoColor
                                            )
                                        }

                                        Box(
                                            modifier = Modifier.size(16.dp),
                                            contentAlignment = Alignment.Center
                                        ) {

                                            Canvas(modifier = Modifier.matchParentSize()) {
                                                drawCircle(
                                                    color = if (isSelected && isDisponible)
                                                        VerdeModernoEnd
                                                    else
                                                        Color.Gray,
                                                    style = Stroke(width = 2.5f)
                                                )

                                                if (isSelected && isDisponible) {
                                                    drawCircle(
                                                        color = VerdeModernoEnd,
                                                        radius = size.minDimension / 3
                                                    )
                                                }
                                            }
                                        }
                                    }

                                    if (index != printers.lastIndex) {
                                        Canvas(
                                            modifier = Modifier
                                                .fillMaxWidth()
                                                .height(1.dp)
                                        ) {
                                            drawLine(
                                                color = if (isActive)
                                                    VerdeModernoEnd
                                                else
                                                    Color.Gray,
                                                start = Offset(0f, 0f),
                                                end = Offset(size.width, 0f),
                                                strokeWidth = 2f,
                                                pathEffect = PathEffect.dashPathEffect(
                                                    floatArrayOf(10f, 6f)
                                                )
                                            )
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}