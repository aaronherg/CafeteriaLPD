package com.aarondevs.cafeterialpd.presentation.screens.admin.inventario

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
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layout
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafeterialaparada.composeapp.generated.resources.Res
import cafeterialaparada.composeapp.generated.resources.bg_decorative
import cafeterialaparada.composeapp.generated.resources.ico_box
import cafeterialaparada.composeapp.generated.resources.ico_categoria
import cafeterialaparada.composeapp.generated.resources.ico_editar
import cafeterialaparada.composeapp.generated.resources.ico_home
import cafeterialaparada.composeapp.generated.resources.ico_menu
import cafeterialaparada.composeapp.generated.resources.ico_plus
import cafeterialaparada.composeapp.generated.resources.ico_profile
import cafeterialaparada.composeapp.generated.resources.ico_search
import cafeterialaparada.composeapp.generated.resources.ico_setting
import cafeterialaparada.composeapp.generated.resources.ico_trash
import cafeterialaparada.composeapp.generated.resources.logocafeterialpd
import cafeterialaparada.composeapp.generated.resources.temp_kit_comida
import com.aarondevs.binareus.ui.theme.ButtonBackground
import com.aarondevs.binareus.ui.theme.SecondaryText
import com.aarondevs.binareus.ui.theme.VerdeModernoEnd
import com.aarondevs.binareus.ui.theme.VerdeModernoStart
import com.aarondevs.cafeterialpd.librery.AnimProfundidad
import com.aarondevs.cafeterialpd.presentation.component.FiltroChip
import com.aarondevs.cafeterialpd.presentation.component.FloatingButton
import com.aarondevs.cafeterialpd.presentation.component.NavItem
import com.aarondevs.cafeterialpd.presentation.component.NavigationBar
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun AdministradorInventarioScreen(
    onInicio: () -> Unit = {},
    onPerfil: () -> Unit = {},
    onVenta: () -> Unit = {},
    onConfiguracion: () -> Unit = {},
    onNuevoProducto: () -> Unit = {},
    onEditarProducto: () -> Unit = {},
    onCategoria: () -> Unit = {}

) {
    AdministradorInventarioScreenBody(
        onInicio = onInicio,
        onPerfil = onPerfil,
        onVenta = onVenta,
        onConfiguracion = onConfiguracion,
        onNuevoProducto = onNuevoProducto,
        onEditarProducto = onEditarProducto,
        onCategoria = onCategoria
    )
}

@Composable
fun AdministradorInventarioScreenBody(
    onInicio: () -> Unit = {},
    onPerfil: () -> Unit = {},
    onVenta: () -> Unit = {},
    onConfiguracion: () -> Unit = {},
    onNuevoProducto: () -> Unit = {},
    onEditarProducto: () -> Unit = {},
    onCategoria: () -> Unit = {}
) {
    var busqueda = ""

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Transparent)
    ) {

        Image(
            painter = painterResource(resource = Res.drawable.bg_decorative),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp, top = 30.dp, end = 16.dp)
        ) {

            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Image(
                    painter = painterResource(resource = Res.drawable.logocafeterialpd),
                    contentDescription = "Logo",
                    modifier = Modifier.size(75.dp)
                )

                Spacer(modifier = Modifier.height(6.dp))

                Text(
                    text = "Cafetería La Parada",
                    fontSize = 15.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = ButtonBackground
                )

                Text(
                    text = "809-000-0000 • ejemplo@gmail.com",
                    fontSize = 12.sp,
                    color = SecondaryText
                )

                Text(
                    text = "Av. Principal #123",
                    fontSize = 12.sp,
                    color = SecondaryText
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(48.dp)
                    .clip(RoundedCornerShape(25.dp))
                    .background(Color.White.copy(alpha = 0.06f))
                    .border(
                        BorderStroke(
                            1.5.dp,
                            Brush.horizontalGradient(
                                listOf(VerdeModernoStart, VerdeModernoEnd)
                            )
                        ),
                        shape = RoundedCornerShape(25.dp)
                    )
                    .padding(horizontal = 14.dp)
            ) {

                Image(
                    painter = painterResource(resource = Res.drawable.ico_search),
                    contentDescription = null,
                    modifier = Modifier.size(20.dp)
                )

                Spacer(modifier = Modifier.width(8.dp))

                BasicTextField(
                    value = "",
                    onValueChange = { },
                    modifier = Modifier.weight(1f),
                    singleLine = true,
                    textStyle = TextStyle(color = Color.White),
                    decorationBox = { innerTextField ->
                        Box {
                            if (busqueda.isEmpty()) {
                                Text(
                                    text = "Buscar...",
                                    color = Color.Gray
                                )
                            }
                            innerTextField()
                        }
                    }
                )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 230.dp)
                .clip(RoundedCornerShape(topStart = 50.dp, topEnd = 50.dp))
        ) {

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
                        .fillMaxSize()
                        .padding(bottom = 105.dp)
                ) {

                    AdministradorInventarioContenidoScreen(
                        onNuevoProducto = onNuevoProducto,
                        onEditarProducto = onEditarProducto,
                        onCategoria = onCategoria
                    )

                    Spacer(modifier = Modifier.height(50.dp))
                }

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.BottomCenter)
                        .padding(bottom = 10.dp, end = 15.dp)
                ) {

                    NavigationBar(
                        items = listOf(
                            NavItem("Inicio", Res.drawable.ico_home, onClick = onInicio),
                            NavItem("Inventario", Res.drawable.ico_box),
                            NavItem("Configuración", Res.drawable.ico_setting, onClick = onConfiguracion),
                            NavItem("Perfil", Res.drawable.ico_profile, onClick = onPerfil)
                        ),
                        centerItem = NavItem("Ventas", Res.drawable.ico_menu, onClick = onVenta),
                        initialSelectedItem = "Inventario"
                    )
                }
            }
        }
    }
}


data class CategoriasInventarioUI(
    val categoriaId: Int,
    val descripcion: String,
    val color: String
)

data class ProductoInventarioUI(
    val nombre: String,
    val categoriaId: Int,
    val precio: String,
    val imagen: DrawableResource
)

@Composable
fun ProductoInventarioCard(
    producto: ProductoInventarioUI,
    categorias: List<CategoriasInventarioUI>,
    onEditar: () -> Unit = {},
    onEliminar: () -> Unit = {},
    modifier: Modifier = Modifier
) {

    val categoria = categorias.firstOrNull { it.categoriaId == producto.categoriaId }
        ?: CategoriasInventarioUI(0, "Sin categoría", "#9E9E9E")

    val borderColor = Color.Black.copy(alpha = 0.06f)
    val density = LocalDensity.current
    val textMeasurer = rememberTextMeasurer()

    val textLayout = textMeasurer.measure(
        text = AnnotatedString(categoria.descripcion),
        style = TextStyle(
            fontSize = 10.sp,
            fontWeight = FontWeight.Bold,
            letterSpacing = 1.sp
        ),
        maxLines = 1,
        softWrap = false,
        constraints = Constraints(maxWidth = Int.MAX_VALUE)
    )

    val dynamicHeight = with(density) {
        val height = textLayout.size.width.toDp() + 20.dp
        if (height < 60.dp) 80.dp else if (height > 150.dp) 150.dp else height
    }

    Column(
        modifier = modifier
            .fillMaxWidth()
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = dynamicHeight)
        ) {
            Box(
                modifier = Modifier
                    .matchParentSize()
                    .background(
                        color = Color(
                            run {
                                val hex = categoria.color.removePrefix("#")
                                when (hex.length) {
                                    6 -> hex.toLong(16) or 0xFF000000
                                    8 -> hex.toLong(16)
                                    else -> 0xFF000000
                                }
                            }
                        ),
                        shape = RoundedCornerShape(18.dp)
                    )
            )

            Box(
                modifier = Modifier
                    .wrapContentSize()
                    .padding(horizontal = 5.dp)
                    .align(Alignment.CenterStart),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = categoria.descripcion,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 1.sp,
                    color = Color.White,
                    maxLines = 1,
                    softWrap = false,
                    modifier = Modifier.layout { measurable, constraints ->
                        val placeable = measurable.measure(constraints)
                        layout(placeable.height, placeable.width) {
                            placeable.place(
                                x = -(placeable.width / 2 - placeable.height / 2),
                                y = -(placeable.height / 2 - placeable.width / 2)
                            )
                        }
                    }.rotate(-90f)
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 20.dp, top = 6.dp)
                    .background(
                        Color(0xFFECECEC),
                        RoundedCornerShape(topStart = 16.dp, bottomStart = 16.dp, topEnd = 16.dp)
                    )
                    .border(
                        1.dp,
                        borderColor,
                        RoundedCornerShape(topStart = 16.dp, bottomStart = 16.dp, topEnd = 16.dp)
                    )
            ) {
                Column(
                    modifier = Modifier
                        .heightIn(min = dynamicHeight)
                        .fillMaxHeight()
                ) {
                    Row(
                        modifier = Modifier
                            .weight(1f)
                            .padding(10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Box(
                            modifier = Modifier
                                .heightIn(min = dynamicHeight, max = 100.dp)
                                .fillMaxHeight()
                                .aspectRatio(1f)
                                .clip(RoundedCornerShape(12.dp))
                                .background(Color.Transparent),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = painterResource(producto.imagen),
                                contentDescription = producto.nombre,
                                contentScale = ContentScale.Fit,
                                modifier = Modifier.fillMaxSize()
                            )
                        }

                        Spacer(Modifier.width(10.dp))

                        Box(
                            modifier = Modifier
                                .height(55.dp)
                                .width(1.dp)
                                .background(borderColor)
                        )

                        Spacer(Modifier.width(10.dp))

                        Column(
                            modifier = Modifier
                                .fillMaxHeight()
                                .fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = producto.nombre,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                maxLines = 1
                            )

                            Text(
                                text = producto.precio,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color(0xFF2E7D32)
                            )
                        }
                    }
                }
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp),
            horizontalArrangement = Arrangement.End
        ) {

            Row(
                modifier = Modifier
                    .background(
                        Color(0xFFECECEC),
                        RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp)
                    )
                    .border(
                        1.dp,
                        borderColor,
                        RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp)
                    )
                    .padding(horizontal = 8.dp, vertical = 6.dp),
                horizontalArrangement = Arrangement.spacedBy(6.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    modifier = Modifier
                        .clip(RoundedCornerShape(6.dp))
                        .background(
                            Brush.linearGradient(
                                listOf(
                                    Color(0xFF2E7D6B),
                                    Color(0xFF388E7B)
                                )
                            )
                        )
                        .clickable { onEditar() }
                        .padding(horizontal = 8.dp, vertical = 3.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(Res.drawable.ico_editar),
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(11.dp)
                    )
                    Spacer(Modifier.width(4.dp))
                    Text(
                        "Editar",
                        color = Color.White,
                        fontSize = 10.sp
                    )
                }

                Row(
                    modifier = Modifier
                        .clip(RoundedCornerShape(6.dp))
                        .background(
                            Brush.linearGradient(
                                listOf(
                                    Color(0xFF8E2C2C),
                                    Color(0xFFA33A3A)
                                )
                            )
                        )
                        .clickable { onEliminar() }
                        .padding(horizontal = 8.dp, vertical = 3.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        painter = painterResource(Res.drawable.ico_trash),
                        contentDescription = null,
                        tint = Color.White,
                        modifier = Modifier.size(11.dp)
                    )
                    Spacer(Modifier.width(4.dp))
                    Text(
                        "Eliminar",
                        color = Color.White,
                        fontSize = 10.sp
                    )
                }
            }
        }
    }
}

@Composable
fun AdministradorInventarioContenidoScreen(
    onNuevoProducto: () -> Unit = {},
    onEditarProducto: () -> Unit = {},
    onCategoria: () -> Unit = {}
) {

    val categorias = listOf(
        CategoriasInventarioUI(0, "Todos", "#795548"),
        CategoriasInventarioUI(1, "Sandwich", "#4CAF50"),
        CategoriasInventarioUI(2, "Yaroas", "#FF9800"),
        CategoriasInventarioUI(3, "Empanadas", "#E91E63"),
        CategoriasInventarioUI(4, "Jugos Naturales", "#2196F3"),
        CategoriasInventarioUI(5, "Ensaladas", "#9C27B0"),
        CategoriasInventarioUI(6, "Postres", "#FFC107")
    )

    var productos by remember {
        mutableStateOf(
            listOf(
                ProductoInventarioUI("Sandwich Clásico", 1, "RD$ 150", Res.drawable.temp_kit_comida),
                ProductoInventarioUI("Sandwich Jamón y Queso", 1, "RD$ 180", Res.drawable.temp_kit_comida),
                ProductoInventarioUI("Yaroa de Pollo", 2, "RD$ 250", Res.drawable.temp_kit_comida),
                ProductoInventarioUI("Yaroa Mixta", 2, "RD$ 300", Res.drawable.temp_kit_comida),
                ProductoInventarioUI("Empanada de Carne", 3, "RD$ 50", Res.drawable.temp_kit_comida),
                ProductoInventarioUI("Jugo de Naranja", 4, "RD$ 80", Res.drawable.temp_kit_comida),
                ProductoInventarioUI("Ensalada César", 5, "RD$ 120", Res.drawable.temp_kit_comida),
                ProductoInventarioUI("Flan", 6, "RD$ 90", Res.drawable.temp_kit_comida)
            )
        )
    }

    val cantidadPorCategoria = remember(productos) {
        productos.groupingBy { it.categoriaId }.eachCount()
    }

    var selectedCategoria by remember { mutableStateOf(0) }

    Box(modifier = Modifier.fillMaxSize()) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            VerdeModernoStart.copy(alpha = 0.05f),
                            VerdeModernoEnd.copy(alpha = 0.05f)
                        )
                    )
                )
        ) {

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 10.dp, vertical = 15.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(top = 6.dp, bottom = 4.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .width(4.dp)
                            .height(14.dp)
                            .clip(RoundedCornerShape(50))
                            .background(
                                Brush.verticalGradient(
                                    listOf(VerdeModernoStart, VerdeModernoEnd)
                                )
                            )
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = "Categorías",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White.copy(alpha = 0.85f)
                    )
                }

                Row(
                    modifier = Modifier
                        .horizontalScroll(rememberScrollState())
                        .padding(bottom = 6.dp)
                ) {
                    categorias.forEach { categoria ->
                        val cantidad = if (categoria.categoriaId == 0) {
                            productos.size
                        } else {
                            cantidadPorCategoria[categoria.categoriaId] ?: 0
                        }

                        FiltroChip(
                            titulo = categoria.descripcion,
                            cantidad = cantidad,
                            seleccionado = categoria.categoriaId == selectedCategoria,
                            borderBrush = Brush.horizontalGradient(
                                listOf(
                                    Color(
                                        run {
                                            val hex = categoria.color.removePrefix("#")
                                            when (hex.length) {
                                                6 -> hex.toLong(16) or 0xFF000000
                                                8 -> hex.toLong(16)
                                                else -> 0xFF000000
                                            }
                                        }
                                    ),
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
                            ),
                            onClick = { selectedCategoria = categoria.categoriaId }
                        )
                    }
                }

                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.End,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 6.dp, bottom = 4.dp)
                ) {
                    Text(
                        text = "Articulos",
                        fontSize = 11.sp,
                        fontWeight = FontWeight.SemiBold,
                        color = Color.White.copy(alpha = 0.85f)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Box(
                        modifier = Modifier
                            .width(4.dp)
                            .height(14.dp)
                            .clip(RoundedCornerShape(50))
                            .background(
                                Brush.verticalGradient(
                                    listOf(VerdeModernoStart, VerdeModernoEnd)
                                )
                            )
                    )
                }

                val productosFiltrados = if (selectedCategoria == 0) {
                    productos
                } else {
                    productos.filter { it.categoriaId == selectedCategoria }
                }

                productosFiltrados.forEach { producto ->
                    key(producto.nombre) {
                        var animar by remember { mutableStateOf(false) }

                        AnimProfundidad(
                            animar = animar,
                            duracionMs = 300,
                            onFin = { productos = productos - producto }
                        ) { modifier ->
                            ProductoInventarioCard(
                                producto = producto,
                                categorias = categorias,
                                onEditar = onEditarProducto,
                                onEliminar = {
                                    animar = true
                                             },
                                modifier = modifier
                            )
                        }
                    }
                }
            }
        }

        Column(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(start = 16.dp, bottom = 8.dp, end = 16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            FloatingButton(
                icon = Res.drawable.ico_categoria,
                label = "Categoria",
                size = 48,
                iconSize = 24,
                borderColor = Brush.horizontalGradient(
                    listOf(Color(0xFFFF7043), Color(0xFFD84315))
                ),
                onClick = {
                    onCategoria()
                }
            )

            FloatingButton(
                icon = Res.drawable.ico_plus,
                label = "Producto",
                size = 48,
                iconSize = 24,
                borderColor = Brush.horizontalGradient(
                    listOf(Color(0xFFA5D6A7), Color(0xFF66BB6A))
                ),
                onClick = {
                    onNuevoProducto()
                }
            )
        }
    }
}


@Preview
@Composable
fun AdministradorInventarioScreenPreview() {
    AdministradorInventarioScreen()
}