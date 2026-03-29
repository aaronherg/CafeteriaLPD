package com.aarondevs.cafeterialpd.presentation.screens.admin.ventas.historial

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafeterialaparada.composeapp.generated.resources.*
import com.aarondevs.binareus.ui.theme.VerdeModernoEnd
import com.aarondevs.binareus.ui.theme.VerdeModernoStart
import com.aarondevs.cafeterialpd.presentation.component.Calendar
import com.aarondevs.cafeterialpd.presentation.component.SlideSnapping
import com.aarondevs.cafeterialpd.presentation.component.SlideState
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun AdministradorHistorialVentaScreen(
    onRetroceder: () -> Unit = {},
    onInformacion: () -> Unit = {},
    onVistaPrevia: () -> Unit = {},
) {
    AdministradorHistorialVentaScreenBody(
        onRetroceder = onRetroceder,
        onInformacion = onInformacion,
        onVistaPrevia = onVistaPrevia
    )
}

@Composable
fun AdministradorHistorialVentaScreenBody(
    onRetroceder: () -> Unit = {},
    onInformacion: () -> Unit = {},
    onVistaPrevia: () -> Unit = {},
) {

    var selectedIndex by remember { mutableStateOf(0) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Transparent)
    ) {
        Image(
            painter = painterResource(resource = Res.drawable.bg_solido),
            contentDescription = "Background Image",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier.fillMaxSize()
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp, top = 40.dp, end = 16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Image(
                        painter = painterResource(resource = Res.drawable.ico_back),
                        contentDescription = "Back Icon",
                        modifier = Modifier
                            .clickable { onRetroceder() }
                            .padding(8.dp)
                            .width(38.dp)
                            .height(38.dp)
                    )

                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .padding(horizontal = 8.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = "Historial de Ventas",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }

                    Image(
                        painter = painterResource(resource = Res.drawable.ico_informacion),
                        contentDescription = "Information Icon",
                        modifier = Modifier
                            .clickable { onInformacion() }
                            .padding(8.dp)
                            .width(32.dp)
                            .height(32.dp)
                    )
                }

                Text(
                    text = "Consulta tu historial de ventas realizadas. Puedes usar los filtros especificados.",
                    color = Color.Gray,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center
                )

            }

            Spacer(modifier = Modifier.height(20.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .clip(RoundedCornerShape(topStart = 50.dp, topEnd = 50.dp))
            ) {

                Image(
                    painter = painterResource(resource = Res.drawable.bg_principal),
                    contentDescription = null,
                    modifier = Modifier
                        .matchParentSize()
                        .alpha(0.5f),
                    contentScale = ContentScale.Crop
                )

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(
                            bottom = WindowInsets.navigationBars
                                .asPaddingValues()
                                .calculateBottomPadding()
                        )
                ) {

                    Column(
                        modifier = Modifier
                            .fillMaxSize(),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        AdministradorHistorialVentaContenidoScreen(
                            selectedIndex = selectedIndex,
                            onSelectedChange = { selectedIndex = it },
                            onVistaPrevia = onVistaPrevia
                        )
                    }
                }
            }
        }
    }

}


@Composable
fun FiltroEstadoVentaHorizontales(
    selectedIndex: Int,
    onOptionSelected: (Int) -> Unit
) {

    val opciones = listOf(
        "Todos",
        "Pendientes",
        "Transito",
        "Entregado",
        "Cancelado"
    )

    val gradientBrush = Brush.horizontalGradient(
        colors = listOf(VerdeModernoEnd, VerdeModernoStart)
    )

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp)
            .background(
                color = Color.Black.copy(alpha = 0.25f),
                shape = RoundedCornerShape(topStart = 50.dp, topEnd = 50.dp)
            )
            .border(
                width = 1.6.dp,
                brush = Brush.verticalGradient(
                    colors = listOf(
                        VerdeModernoEnd.copy(alpha = 0.30f),
                        VerdeModernoStart.copy(alpha = 0.55f),
                        VerdeModernoEnd.copy(alpha = 0.30f)
                    )
                ),
                shape = RoundedCornerShape(topStart = 50.dp, topEnd = 50.dp)
            )
    ) {

        Row(
            modifier = Modifier
                .fillMaxHeight()
                .horizontalScroll(rememberScrollState())
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            opciones.forEachIndexed { index, opcion ->

                Column(
                    modifier = Modifier
                        .padding(horizontal = 12.dp)
                        .clickable { onOptionSelected(index) },
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {

                    Text(
                        text = opcion,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = if (index == selectedIndex)
                            Color.White
                        else
                            Color.White.copy(alpha = 0.85f)
                    )

                    if (index == selectedIndex) {
                        Spacer(modifier = Modifier.height(6.dp))

                        Box(
                            modifier = Modifier
                                .width(22.dp)
                                .height(3.dp)
                                .background(
                                    brush = gradientBrush,
                                    shape = RoundedCornerShape(50)
                                )
                        )
                    }
                }

                if (index != opciones.lastIndex) {
                    Box(
                        modifier = Modifier
                            .fillMaxHeight()
                            .width(2.dp)
                            .background(
                                brush = Brush.verticalGradient(
                                    colors = listOf(
                                        VerdeModernoEnd.copy(alpha = 0.15f),
                                        VerdeModernoStart.copy(alpha = 0.55f),
                                        VerdeModernoEnd.copy(alpha = 0.15f)
                                    )
                                )
                            )
                    )
                }
            }
        }
    }
}


data class VentaUI(
    val estado: EstadoVenta,
    val fecha: String,
    val cliente: String,
    val codigo: String,
    val telefono: String,
    val subtotal: String,
    val envio: String,
    val metodoPago: String,
    val area: String,
    val direccion: String,
    val comentario: String,
    val total: String
)

data class EstadoVenta(
    val label: String,
    val icon: DrawableResource
)


@Composable
fun HistorialVentaCard(
    venta: VentaUI,
    onEliminar: () -> Unit = {},
    modifier: Modifier = Modifier,
    onEstadoChange: (EstadoVenta) -> Unit,
    onVistaPrevia: () -> Unit,
) {

    val estadosSlide = listOf(
        SlideState("Pendiente"),
        SlideState("En Transito"),
        SlideState("Entregado"),
        SlideState("Cancelado")
    )

    var stepIndex by remember {
        mutableStateOf(
            when (venta.estado.label) {
                "Pendiente" -> 0
                "En Transito" -> 1
                "Entregado" -> 2
                "Cancelado" -> 3
                else -> 0
            }
        )
    }

    val estadoActual = when (stepIndex) {
        0 -> EstadoVenta("Pendiente", Res.drawable.ico_pendiente)
        1 -> EstadoVenta("En Transito", Res.drawable.ico_transito)
        2 -> EstadoVenta("Entregado", Res.drawable.ico_check)
        3 -> EstadoVenta("Cancelado", Res.drawable.ico_cancelado)
        else -> EstadoVenta("Pendiente", Res.drawable.ico_pendiente)
    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 6.dp)
    ) {

        Box(
            modifier = modifier
                .fillMaxWidth()
                .height(240.dp)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.linearGradient(
                            colors = listOf(
                                Color(0xFF8E2C2C),
                                Color(0xFFA33A3A)
                            )
                        ),
                        shape = RoundedCornerShape(20.dp)
                    )
            )

            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(60.dp)
                    .offset(x = 10.dp)
                    .align(Alignment.CenterEnd)
                    .graphicsLayer {
                        rotationZ = -90f
                        transformOrigin = TransformOrigin.Center
                    },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    modifier = Modifier.clickable { onEliminar() },
                    text = "ELIMINAR",
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.2.sp,
                    color = Color.White
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .padding(end = 40.dp)
                    .background(
                        Color(0xFFFAFAFA),
                        RoundedCornerShape(16.dp)
                    ),
                contentAlignment = Alignment.BottomCenter
            ) {
                Row(
                    modifier = Modifier
                        .padding(bottom = 6.dp)
                        .clickable {

                        },
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Column {

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clip(RoundedCornerShape(12.dp))
                                .padding(horizontal = 10.dp, vertical = 2.dp),
                            contentAlignment = Alignment.Center
                        ) {

                            SlideSnapping(
                                states = estadosSlide,
                                currentIndex = stepIndex,
                                onStateChange = { newIndex ->
                                    stepIndex = newIndex

                                    val nuevoEstado = when (newIndex) {
                                        0 -> EstadoVenta("Pendiente", Res.drawable.ico_pendiente)
                                        1 -> EstadoVenta("En Transito", Res.drawable.ico_transito)
                                        2 -> EstadoVenta("Entregado", Res.drawable.ico_check)
                                        3 -> EstadoVenta("Cancelado", Res.drawable.ico_cancelado)
                                        else -> EstadoVenta("Pendiente", Res.drawable.ico_pendiente)
                                    }

                                    onEstadoChange(nuevoEstado)
                                },
                                borderColor = Brush.horizontalGradient(
                                    listOf(VerdeModernoStart, VerdeModernoEnd)
                                ),
                                fontSize = 8,
                            )
                        }

                        Spacer(Modifier.height(6.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painterResource(Res.drawable.ico_show_black),
                                null,
                                Modifier.size(26.dp)
                                    .clickable {
                                    onVistaPrevia()
                                }
                            )
                            Image(
                                painterResource(Res.drawable.ico_print_color),
                                null,
                                Modifier.size(26.dp)
                                    .clickable {

                                    }
                            )
                            Image(
                                painterResource(Res.drawable.ico_whatsapp),
                                null,
                                Modifier.size(26.dp)
                                    .clickable {

                                    }
                            )
                            Image(
                                painterResource(Res.drawable.ico_download),
                                null,
                                Modifier.size(26.dp)
                                    .clickable {

                                    }
                            )
                        }
                    }
                }


            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 40.dp)
                    .background(Color.White, RoundedCornerShape(16.dp))
                    .border(
                        1.dp,
                        Color.Black.copy(alpha = 0.08f),
                        RoundedCornerShape(16.dp)
                    )
                    .padding(10.dp)
            ) {

                Row(verticalAlignment = Alignment.CenterVertically) {

                    Image(
                        painter = painterResource(estadoActual.icon),
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )

                    Spacer(Modifier.width(6.dp))

                    Column {
                        Text(
                            estadoActual.label,
                            fontSize = 10.sp,
                            fontWeight = FontWeight.Medium
                        )
                        Text(
                            venta.fecha,
                            fontSize = 8.sp,
                            color = Color.Gray
                        )
                    }
                }

                Spacer(Modifier.height(6.dp))

                Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {

                    Column(modifier = Modifier.weight(1f)) {
                        Text(venta.cliente, fontSize = 10.sp, fontWeight = FontWeight.Medium, maxLines = 1)
                        Text("Cliente", fontSize = 8.sp, color = Color.Gray)
                    }

                    Column(modifier = Modifier.weight(1f)) {
                        Text(venta.codigo, fontSize = 10.sp, fontWeight = FontWeight.Medium, maxLines = 1)
                        Text("Código", fontSize = 8.sp, color = Color.Gray)
                    }

                    Column(modifier = Modifier.weight(1f)) {
                        Text(venta.telefono, fontSize = 10.sp, fontWeight = FontWeight.Medium, maxLines = 1)
                        Text("Teléfono", fontSize = 8.sp, color = Color.Gray)
                    }
                }

                Spacer(Modifier.height(6.dp))

                Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {

                    Column(modifier = Modifier.weight(1f)) {
                        Text("Subtotal", fontSize = 7.sp, color = Color.Gray)
                        Text(venta.subtotal, fontSize = 9.sp)
                    }

                    Column(modifier = Modifier.weight(1f)) {
                        Text("Envío", fontSize = 7.sp, color = Color.Gray)
                        Text(venta.envio, fontSize = 9.sp)
                    }

                    Column(modifier = Modifier.weight(1f)) {
                        Text("Pago", fontSize = 7.sp, color = Color.Gray)
                        Text(venta.metodoPago, fontSize = 9.sp)
                    }

                    Column(modifier = Modifier.weight(1f)) {
                        Text("Área", fontSize = 7.sp, color = Color.Gray)
                        Text(venta.area, fontSize = 9.sp)
                    }
                }

                Spacer(Modifier.height(6.dp))

                Row(
                    horizontalArrangement = Arrangement.spacedBy(6.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {

                    Column(modifier = Modifier.weight(1f)) {
                        Text("Dirección", fontSize = 7.sp, color = Color.Gray)
                        Text(venta.direccion, fontSize = 9.sp, lineHeight = 11.sp)
                    }

                    Column(modifier = Modifier.weight(1f)) {
                        Text("Comentario", fontSize = 7.sp, color = Color.Gray)
                        Text(venta.comentario, fontSize = 9.sp, lineHeight = 11.sp)
                    }
                }

                Spacer(Modifier.height(6.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            Color.Black.copy(alpha = 0.04f),
                            RoundedCornerShape(10.dp)
                        )
                        .padding(horizontal = 8.dp, vertical = 5.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("Total", fontSize = 8.sp, color = Color.Gray)
                    Spacer(Modifier.weight(1f))
                    Text(
                        venta.total,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }
        }
    }
}


@Composable
fun AdministradorHistorialVentaContenidoScreen(
    selectedIndex: Int,
    onSelectedChange: (Int) -> Unit,
    onVistaPrevia: () -> Unit
) {
    val ventas = remember {
        mutableStateListOf(
            VentaUI(
                estado = EstadoVenta("Pendiente", Res.drawable.ico_pendiente),
                fecha = "25/03/2026",
                cliente = "Juan Pérez",
                codigo = "#0001",
                telefono = "809-111-1111",
                subtotal = "RD$ 500",
                envio = "RD$ 50",
                metodoPago = "Efectivo",
                area = "Yaroa",
                direccion = "Calle Duarte #10",
                comentario = "Sin cebolla",
                total = "RD$ 550"
            ),
            VentaUI(
                estado = EstadoVenta("En Transito", Res.drawable.ico_transito),
                fecha = "25/03/2026",
                cliente = "Maria Lopez",
                codigo = "#0002",
                telefono = "809-222-2222",
                subtotal = "RD$ 700",
                envio = "RD$ 80",
                metodoPago = "Transferencia",
                area = "Sandwich",
                direccion = "Av. España",
                comentario = "Extra queso",
                total = "RD$ 780"
            ),
            VentaUI(
                estado = EstadoVenta("Entregado", Res.drawable.ico_check),
                fecha = "24/03/2026",
                cliente = "Carlos Diaz",
                codigo = "#0003",
                telefono = "809-333-3333",
                subtotal = "RD$ 400",
                envio = "RD$ 60",
                metodoPago = "Efectivo",
                area = "Yaroa",
                direccion = "Los Prados",
                comentario = "",
                total = "RD$ 460"
            ),
            VentaUI(
                estado = EstadoVenta("Cancelado", Res.drawable.ico_cancelado),
                fecha = "23/03/2026",
                cliente = "Ana Torres",
                codigo = "#0004",
                telefono = "809-444-4444",
                subtotal = "RD$ 300",
                envio = "RD$ 40",
                metodoPago = "Efectivo",
                area = "Sandwich",
                direccion = "Bella Vista",
                comentario = "Cliente no respondió",
                total = "RD$ 340"
            )
        )
    }

    Column(modifier = Modifier.fillMaxWidth()) {

        FiltroEstadoVentaHorizontales(
            selectedIndex = selectedIndex,
            onOptionSelected = onSelectedChange
        )

        Spacer(modifier = Modifier.height(16.dp))

        val busqueda = ""

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 6.dp)
        ) {

            Column(modifier = Modifier.fillMaxWidth(0.6f)) {
                Calendar(
                    label = "Fecha",
                    selectedDate = "",
                    onDateChange = { },
                    borderRadius = 50,
                    borderColor = Brush.horizontalGradient(
                        listOf(VerdeModernoStart, VerdeModernoEnd)
                    ),
                    textSize = 13,
                    verticalPadding = 10
                )
            }

            Spacer(Modifier.height(6.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
                    .clip(RoundedCornerShape(25.dp))
                    .border(
                        BorderStroke(
                            2.dp,
                            Brush.horizontalGradient(
                                listOf(VerdeModernoStart, VerdeModernoEnd)
                            )
                        ),
                        shape = RoundedCornerShape(25.dp)
                    )
                    .padding(horizontal = 16.dp)
            ) {

                Image(
                    painter = painterResource(Res.drawable.ico_search),
                    contentDescription = null,
                    modifier = Modifier.size(24.dp)
                )

                Spacer(modifier = Modifier.width(8.dp))

                BasicTextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier.weight(1f),
                    singleLine = true,
                    textStyle = TextStyle(color = Color.Gray),
                    decorationBox = {
                        if (busqueda.isEmpty()) {
                            Text("Buscar...", color = Color.Gray)
                        }
                        it()
                    }
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
        ) {
            val filtradas = when (selectedIndex) {
                0 -> ventas
                1 -> ventas.filter { it.estado.label == "Pendiente" }
                2 -> ventas.filter { it.estado.label == "En Transito" }
                3 -> ventas.filter { it.estado.label == "Entregado" }
                4 -> ventas.filter { it.estado.label == "Cancelado" }
                else -> ventas
            }

            if (filtradas.isEmpty()) {
                val (iconRes, estadoText) = when (selectedIndex) {
                    1 -> Res.drawable.ico_pendiente to "PENDIENTES"
                    2 -> Res.drawable.ico_transito to "EN TRANSITO"
                    3 -> Res.drawable.ico_check to "ENTREGADAS"
                    4 -> Res.drawable.ico_cancelado to "CANCELADAS"
                    else -> Res.drawable.ico_pendiente to "VENTAS"
                }

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 40.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(
                        painter = painterResource(iconRes),
                        contentDescription = null,
                        modifier = Modifier.size(48.dp)
                    )
                    Spacer(Modifier.height(12.dp))
                    Text(
                        text = "NO SE ENCONTRARON VENTAS $estadoText",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.Gray,
                        textAlign = TextAlign.Center
                    )
                }
            } else {
                filtradas.forEach { venta ->
                    key(venta.codigo) {
                        HistorialVentaCard(
                            venta = venta,
                            onEstadoChange = { nuevoEstado ->
                                val index = ventas.indexOfFirst { it.codigo == venta.codigo }
                                if (index >= 0) {
                                    ventas[index] = ventas[index].copy(estado = nuevoEstado)
                                }
                            },
                            onEliminar = {
                                val index = ventas.indexOfFirst { it.codigo == venta.codigo }
                                if (index >= 0) {
                                    ventas.removeAt(index)
                                }
                            },
                            onVistaPrevia = onVistaPrevia
                        )
                        Spacer(Modifier.height(12.dp))
                    }
                }
            }
        }
    }
}



@Preview
@Composable
fun AdministradorHistorialVentaScreenPreview() {
    AdministradorHistorialVentaScreen()
}