package com.aarondevs.cafeterialpd.presentation.screens.admin.inventario.categorias

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
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
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.TransformOrigin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafeterialaparada.composeapp.generated.resources.Res
import cafeterialaparada.composeapp.generated.resources.bg_principal
import cafeterialaparada.composeapp.generated.resources.bg_solido
import cafeterialaparada.composeapp.generated.resources.ico_back
import cafeterialaparada.composeapp.generated.resources.ico_informacion
import cafeterialaparada.composeapp.generated.resources.ico_search
import com.aarondevs.binareus.ui.theme.VerdeModernoEnd
import com.aarondevs.binareus.ui.theme.VerdeModernoStart
import com.aarondevs.cafeterialpd.librery.AnimDesplazarIzquierda
import com.aarondevs.cafeterialpd.librery.ColoresCategorias
import com.aarondevs.cafeterialpd.presentation.component.ColorChip
import com.aarondevs.cafeterialpd.presentation.screens.admin.inventario.CategoriasInventarioUI
import org.jetbrains.compose.resources.painterResource

@Composable
fun AdministradorInventarioCategoriaScreen(
    onRetroceder: () -> Unit = {},
    onInformacion: () -> Unit = {}
) {
    AdministradorInventarioCategoriaScreenBody(
        onRetroceder = onRetroceder,
        onInformacion = onInformacion
    )
}

@Composable
fun AdministradorInventarioCategoriaScreenBody(
    onRetroceder: () -> Unit = {},
    onInformacion: () -> Unit = {}
) {

    var colorSeleccionado by remember { mutableStateOf(ColoresCategorias.lista[0]) }

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
                            text = "Categorias",
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
                    text = "Complete el formulario para agregar una nueva categoria.",
                    color = Color.Gray,
                    fontSize = 16.sp,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(20.dp))

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                ) {

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .heightIn(min = 90.dp)
                    ) {

                        var textWidthPx by remember { mutableStateOf(0f) }

                        Canvas(
                            modifier = Modifier.matchParentSize()
                        ) {
                            val strokeWidth = 2f
                            val dash = PathEffect.dashPathEffect(floatArrayOf(12f, 6f))

                            val labelStart = 16.dp.toPx()
                            val labelEnd = labelStart + textWidthPx + 8.dp.toPx()

                            val radius = 10.dp.toPx()

                            val brush = Brush.horizontalGradient(listOf(VerdeModernoStart, VerdeModernoEnd))

                            val w = size.width
                            val h = size.height

                            drawLine(
                                brush = brush,
                                start = Offset(radius, 0f),
                                end = Offset(labelStart, 0f),
                                strokeWidth = strokeWidth,
                                pathEffect = dash
                            )

                            drawLine(
                                brush = brush,
                                start = Offset(labelEnd, 0f),
                                end = Offset(w - radius, 0f),
                                strokeWidth = strokeWidth,
                                pathEffect = dash
                            )

                            drawLine(
                                brush = brush,
                                start = Offset(w, radius),
                                end = Offset(w, h - radius),
                                strokeWidth = strokeWidth,
                                pathEffect = dash
                            )

                            drawLine(
                                brush = brush,
                                start = Offset(w - radius, h),
                                end = Offset(radius, h),
                                strokeWidth = strokeWidth,
                                pathEffect = dash
                            )

                            drawLine(
                                brush = brush,
                                start = Offset(0f, h - radius),
                                end = Offset(0f, radius),
                                strokeWidth = strokeWidth,
                                pathEffect = dash
                            )

                            drawArc(
                                brush = brush,
                                startAngle = 180f,
                                sweepAngle = 90f,
                                useCenter = false,
                                topLeft = Offset(0f, 0f),
                                size = Size(radius * 2, radius * 2),
                                style = Stroke(width = strokeWidth, pathEffect = dash)
                            )

                            drawArc(
                                brush = brush,
                                startAngle = 270f,
                                sweepAngle = 90f,
                                useCenter = false,
                                topLeft = Offset(w - radius * 2, 0f),
                                size = Size(radius * 2, radius * 2),
                                style = Stroke(width = strokeWidth, pathEffect = dash)
                            )

                            drawArc(
                                brush = brush,
                                startAngle = 0f,
                                sweepAngle = 90f,
                                useCenter = false,
                                topLeft = Offset(w - radius * 2, h - radius * 2),
                                size = Size(radius * 2, radius * 2),
                                style = Stroke(width = strokeWidth, pathEffect = dash)
                            )

                            drawArc(
                                brush = brush,
                                startAngle = 90f,
                                sweepAngle = 90f,
                                useCenter = false,
                                topLeft = Offset(0f, h - radius * 2),
                                size = Size(radius * 2, radius * 2),
                                style = Stroke(width = strokeWidth, pathEffect = dash)
                            )
                        }

                        Text(
                            text = "Formulario",
                            fontSize = 13.sp,
                            color = Color.Gray,
                            modifier = Modifier
                                .offset(x = 16.dp, y = (-8).dp)
                                .onGloballyPositioned {
                                    textWidthPx = it.size.width.toFloat()
                                }
                        )

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(12.dp),
                            verticalArrangement = Arrangement.spacedBy(12.dp)
                        ) {

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .horizontalScroll(rememberScrollState()),
                                horizontalArrangement = Arrangement.spacedBy(8.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                ColoresCategorias.lista.forEach { color ->
                                    ColorChip(
                                        color = color,
                                        seleccionado = color == colorSeleccionado,
                                        onClick = { colorSeleccionado = color }
                                    )
                                }
                            }

                            var text by remember { mutableStateOf("") }

                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(50.dp),
                                horizontalArrangement = Arrangement.spacedBy(8.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {

                                Box(
                                    modifier = Modifier
                                        .weight(1f)
                                        .fillMaxHeight()
                                ) {

                                    Canvas(modifier = Modifier.matchParentSize()) {
                                        drawRoundRect(
                                            brush = Brush.horizontalGradient(listOf(VerdeModernoStart, VerdeModernoEnd)),
                                            style = Stroke(
                                                width = 2f,
                                                pathEffect = PathEffect.dashPathEffect(floatArrayOf(12f, 6f))
                                            ),
                                            cornerRadius = CornerRadius(8f, 8f)
                                        )
                                    }

                                    BasicTextField(
                                        value = text,
                                        onValueChange = { text = it },
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .padding(horizontal = 12.dp),
                                        textStyle = TextStyle(
                                            color = Color.Gray,
                                            fontSize = 13.sp
                                        ),
                                        singleLine = true,
                                        cursorBrush = Brush.verticalGradient(listOf(VerdeModernoStart, VerdeModernoEnd)),
                                        decorationBox = { innerTextField ->
                                            Box(
                                                modifier = Modifier.fillMaxSize(),
                                                contentAlignment = Alignment.CenterStart
                                            ) {
                                                if (text.isEmpty()) {
                                                    Text(
                                                        text = "Descripcion",
                                                        fontSize = 13.sp,
                                                        color = Color.Gray
                                                    )
                                                }
                                                innerTextField()
                                            }
                                        }
                                    )
                                }

                                Box(
                                    modifier = Modifier
                                        .width(70.dp)
                                        .fillMaxHeight()
                                        .clickable { },
                                    contentAlignment = Alignment.Center
                                ) {

                                    Canvas(modifier = Modifier.matchParentSize()) {
                                        drawRoundRect(
                                            brush = Brush.horizontalGradient(listOf(VerdeModernoStart, VerdeModernoEnd)),
                                            style = Stroke(
                                                width = 2f,
                                                pathEffect = PathEffect.dashPathEffect(floatArrayOf(12f, 6f))
                                            ),
                                            cornerRadius = CornerRadius(8f, 8f)
                                        )
                                    }

                                    Text(
                                        text = "Agregar",
                                        fontSize = 12.sp,
                                        fontWeight = FontWeight.Bold,
                                        color = Color.White
                                    )
                                }
                            }
                        }
                    }
                }

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
                        AdministradorInventarioCategoriaContenidoScreen(
                            onRetroceder = onRetroceder
                        )
                    }
                }
            }
        }
    }

}


@Composable
fun CategoriasCard(
    categoria: CategoriasInventarioUI,
    onEliminar: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Box(
            modifier = modifier
                .fillMaxWidth()
        ) {
            Box {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            Brush.linearGradient(
                                colors = listOf(
                                    Color(0xFF8E2C2C),
                                    Color(0xFFA33A3A)
                                )
                            ),
                            shape = RoundedCornerShape(20.dp)
                        )
                        .padding(end = 40.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .heightIn(min = 70.dp)
                            .background(Color(0xFFECECEC), RoundedCornerShape(16.dp))
                            .border(
                                1.dp,
                                Color.Black.copy(alpha = 0.08f),
                                RoundedCornerShape(16.dp)
                            )
                            .padding(10.dp),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Box(
                                modifier = Modifier
                                    .size(40.dp)
                                    .clip(CircleShape)
                                    .background(
                                        Color(
                                            run {
                                                val hex = categoria.color.removePrefix("#")
                                                when (hex.length) {
                                                    6 -> hex.toLong(16) or 0xFF000000
                                                    8 -> hex.toLong(16)
                                                    else -> 0xFF000000
                                                }
                                            }
                                        )
                                    )
                            )

                            Spacer(Modifier.width(6.dp))

                            Text(
                                text = categoria.descripcion,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Medium
                            )
                        }
                    }
                }
            }

            Box(
                modifier = Modifier
                    .width(60.dp)
                    .align(Alignment.CenterEnd)
                    .offset(x = 10.dp)
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
        }
    }
}


@Composable
fun AdministradorInventarioCategoriaContenidoScreen(
    onRetroceder: () -> Unit = {}
){
    var categorias by remember {
        mutableStateOf(
            listOf(
                CategoriasInventarioUI(1, "Sandwich", "#4CAF50"),
                CategoriasInventarioUI(2, "Yaroas", "#FF9800"),
                CategoriasInventarioUI(3, "Empanadas", "#E91E63"),
                CategoriasInventarioUI(4, "Jugos Naturales", "#2196F3"),
                CategoriasInventarioUI(5, "Ensaladas", "#9C27B0"),
                CategoriasInventarioUI(6, "Postres", "#FFC107")
            )
        )
    }

    var busqueda by remember { mutableStateOf("") }

    val categoriasFiltradas = categorias.filter {
        it.descripcion.contains(busqueda, ignoreCase = true)
    }

    Box(modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 16.dp, vertical = 30.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

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
                    value = busqueda,
                    onValueChange = { busqueda = it },
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

            Spacer(Modifier.height(6.dp))

            categoriasFiltradas.forEach { categoria ->
                key(categoria.categoriaId) {

                    var animar by remember { mutableStateOf(false) }

                    AnimDesplazarIzquierda(
                        animar = animar,
                        duracionMs = 300,
                        onFin = {
                            categorias = categorias - categoria
                        }
                    ) { modifier ->

                        CategoriasCard(
                            categoria = categoria,
                            modifier = modifier,
                            onEliminar = {
                                animar = true
                            }
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun AdministradorInventarioCategoriaScreenPreview() {
    AdministradorInventarioCategoriaScreen()
}