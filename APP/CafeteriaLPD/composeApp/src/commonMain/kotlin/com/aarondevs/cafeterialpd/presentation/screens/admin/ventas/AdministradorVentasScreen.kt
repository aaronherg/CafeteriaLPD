package com.aarondevs.cafeterialpd.presentation.screens.admin.ventas

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafeterialaparada.composeapp.generated.resources.*
import com.aarondevs.binareus.ui.theme.ButtonBackground
import com.aarondevs.binareus.ui.theme.VerdeModernoEnd
import com.aarondevs.binareus.ui.theme.VerdeModernoStart
import com.aarondevs.binareus.ui.theme.SecondaryText
import com.aarondevs.cafeterialpd.presentation.component.Counter
import com.aarondevs.cafeterialpd.presentation.component.FiltroChip
import com.aarondevs.cafeterialpd.presentation.component.FloatingButton
import com.aarondevs.cafeterialpd.presentation.component.Input
import com.aarondevs.cafeterialpd.presentation.component.NavItem
import com.aarondevs.cafeterialpd.presentation.component.NavigationBar
import com.aarondevs.cafeterialpd.presentation.component.Select
import com.aarondevs.cafeterialpd.presentation.component.Slide
import com.aarondevs.cafeterialpd.presentation.component.TextArea
import com.aarondevs.cafeterialpd.presentation.screens.admin.inventario.CategoriasInventarioUI
import com.aarondevs.cafeterialpd.shared.playSound
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun AdministradorVentasScreen(
    onInicio: () -> Unit = {},
    onInventario: () -> Unit = {},
    onConfiguracion: () -> Unit = {},
    onPerfil: () -> Unit = {},
    onHistorialVenta: () -> Unit = {}

) {
    AdministradorVentasScreenBody(
        onInicio = onInicio,
        onInventario = onInventario,
        onConfiguracion = onConfiguracion,
        onPerfil = onPerfil,
        onHistorialVenta = onHistorialVenta
    )
}

@Composable
fun AdministradorVentasScreenBody(
    onInicio: () -> Unit = {},
    onInventario: () -> Unit = {},
    onConfiguracion: () -> Unit = {},
    onPerfil: () -> Unit = {},
    onHistorialVenta: () -> Unit = {}
) {

    val busqueda = ""

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
                .padding(top = 220.dp)
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

                    AdministradorVentasContenidoScreen(
                        onHistorialVenta = onHistorialVenta
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
                            NavItem("Inventario", Res.drawable.ico_box, onClick = onInventario),
                            NavItem("Configuracion", Res.drawable.ico_setting, onClick = onConfiguracion),
                            NavItem("Perfil", Res.drawable.ico_profile, onClick = onPerfil)
                        ),
                        centerItem = NavItem("Ventas", Res.drawable.ico_menu),
                        initialSelectedItem = "Ventas"
                    )
                }
            }
        }
    }
}

data class ClienteTicket(
    val id: Int,
    val nombre: String
)

data class Categoria(
    val id: Int,
    val nombre: String,
    val color: String
)

data class Producto(
    val id: Int,
    val nombre: String,
    val precio: Double,
    val categoriaId: Int
)

data class OrdenCliente(
    val clienteId: Int,
    val items: List<OrdenItem> = listOf()
)

data class OrdenItem(
    val producto: Producto,
    val cantidad: Int
)


@Composable
fun ListaClienteHorizontal(
    clientes: MutableList<ClienteTicket>,
    selectedCliente: Int,
    onSelectCliente: (Int) -> Unit,
    onAddCliente: () -> Unit,
    onRemoveCliente: (Int) -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(65.dp)
    ) {

        Row(
            modifier = Modifier
                .weight(1f)
                .horizontalScroll(rememberScrollState())
                .padding(horizontal = 13.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            clientes.forEach { cliente ->

                Row(
                    modifier = Modifier
                        .padding(end = 8.dp)
                        .clip(RoundedCornerShape(50))
                        .border(
                            width = 1.2.dp,
                            brush = if (cliente.id == selectedCliente)
                                Brush.horizontalGradient(
                                    listOf(VerdeModernoStart, VerdeModernoEnd)
                                )
                            else
                                Brush.horizontalGradient(
                                    listOf(
                                        Color.White.copy(alpha = 0.25f),
                                        Color.White.copy(alpha = 0.1f)
                                    )
                                ),
                            shape = RoundedCornerShape(50)
                        )
                        .clickable { onSelectCliente(cliente.id) }
                        .padding(horizontal = 10.dp, vertical = 6.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Text(
                        text = cliente.nombre,
                        fontSize = 11.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.White,
                        maxLines = 1
                    )

                    Spacer(modifier = Modifier.width(6.dp))

                    Image(
                        painter = painterResource(Res.drawable.ico_trash),
                        contentDescription = null,
                        modifier = Modifier
                            .size(16.dp)
                            .clickable {
                                onRemoveCliente(cliente.id)
                            }
                    )
                }
            }

            Box(
                modifier = Modifier
                    .size(32.dp)
                    .clip(CircleShape)
                    .background(
                        Brush.horizontalGradient(
                            listOf(VerdeModernoStart, VerdeModernoEnd)
                        )
                    )
                    .clickable { onAddCliente() },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    "+",
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }

        Text(
            text = "Multi-Caja",
            fontSize = 12.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.White.copy(alpha = 0.85f),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 4.dp),
            textAlign = TextAlign.Center
        )

        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .height(1.5.dp)
        ) {
            val dashWidth = 16f
            val gapWidth = 10f

            var x = 0f
            while (x < size.width) {
                drawLine(
                    color = Color.Gray.copy(alpha = 0.6f),
                    start = Offset(x, size.height / 2),
                    end = Offset(x + dashWidth, size.height / 2),
                    strokeWidth = 1.5.dp.toPx()
                )
                x += dashWidth + gapWidth
            }
        }
    }
}

@Composable
fun AdministradorVentasContenidoScreen(
    onHistorialVenta: () -> Unit = {}
) {

    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {

        val isTablet = maxWidth > 700.dp

        var showOrden by remember { mutableStateOf(false) }

        var clientes by remember {
            mutableStateOf(
                mutableListOf(
                    ClienteTicket(1, "Cliente 1")
                )
            )
        }

        var selectedCliente by remember { mutableStateOf(1) }

        var ordenes by remember {
            mutableStateOf(mutableMapOf<Int, OrdenCliente>())
        }

        Column(modifier = Modifier.fillMaxSize()) {

            ListaClienteHorizontal(
                clientes = clientes,
                selectedCliente = selectedCliente,
                onSelectCliente = { selectedCliente = it },
                onAddCliente = {
                    clientes = clientes.toMutableList().apply {
                        val newId = size + 1
                        add(ClienteTicket(newId, "Cliente $newId"))
                    }
                },
                onRemoveCliente = { id ->

                    clientes = clientes.filter { it.id != id }.toMutableList()

                    val nuevaOrdenes = ordenes.toMutableMap()
                    nuevaOrdenes.remove(id)
                    ordenes = nuevaOrdenes

                    if (selectedCliente == id) {
                        selectedCliente = clientes.firstOrNull()?.id ?: 0
                    }
                }
            )

            Box(modifier = Modifier.weight(1f)) {

                if (isTablet) {

                    Row(modifier = Modifier.fillMaxSize()) {

                        Box(modifier = Modifier.weight(0.7f)) {
                            ContenidoIzquierda(
                                selectedClienteId = selectedCliente,
                                ordenes = ordenes,
                                onUpdateOrden = { ordenes = it },
                                isTablet = isTablet,
                                onHistorialVenta = onHistorialVenta,
                                onShowOrden = { showOrden = true }
                            )
                        }

                        Canvas(
                            modifier = Modifier
                                .fillMaxHeight()
                                .width(2.dp)
                        ) {
                            val dashHeight = 16f
                            val gapHeight = 10f
                            var y = 0f
                            while (y < size.height) {
                                drawLine(
                                    color = Color.Gray.copy(alpha = 0.6f),
                                    start = Offset(size.width / 2, y),
                                    end = Offset(size.width / 2, y + dashHeight),
                                    strokeWidth = 1.5.dp.toPx()
                                )
                                y += dashHeight + gapHeight
                            }
                        }

                        Box(modifier = Modifier.weight(0.3f)) {
                            ContenidoDerecha(
                                selectedClienteId = selectedCliente,
                                ordenes = ordenes,
                                onUpdateOrden = { ordenes = it },
                                onRegresar = { showOrden = false },
                                isTablet = isTablet,
                                onCompletarOrden = { clienteId ->
                                    val nuevaOrdenes = ordenes.toMutableMap()
                                    nuevaOrdenes[clienteId] = OrdenCliente(
                                        clienteId = clienteId,
                                        items = listOf()
                                    )
                                    ordenes = nuevaOrdenes
                                }
                            )
                        }
                    }

                } else {

                    if (!showOrden) {

                        ContenidoIzquierda(
                            selectedClienteId = selectedCliente,
                            ordenes = ordenes,
                            onUpdateOrden = { ordenes = it },
                            isTablet = isTablet,
                            onHistorialVenta = onHistorialVenta,
                            onShowOrden = { showOrden = true }
                        )

                    } else {

                        ContenidoDerecha(
                            selectedClienteId = selectedCliente,
                            ordenes = ordenes,
                            onUpdateOrden = { ordenes = it },
                            onRegresar = { showOrden = false },
                            isTablet = isTablet,
                            onCompletarOrden = { clienteId ->
                                val nuevaOrdenes = ordenes.toMutableMap()
                                nuevaOrdenes[clienteId] = OrdenCliente(
                                    clienteId = clienteId,
                                    items = listOf()
                                )
                                ordenes = nuevaOrdenes
                            }
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun ProductoCard(
    producto: Producto,
    cantidad: Int,
    onCantidadChange: (Int) -> Unit,
    onAdd: () -> Unit
) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(6.dp)
            .clip(RoundedCornerShape(16.dp))
            .border(
                1.2.dp,
                Brush.verticalGradient(
                    listOf(
                        Color.White.copy(0.2f),
                        Color.White.copy(0.05f)
                    )
                ),
                RoundedCornerShape(16.dp)
            )
    ) {

        Column(
            modifier = Modifier.fillMaxWidth()
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp)
                    .clip(
                        RoundedCornerShape(
                            topStart = 16.dp,
                            topEnd = 16.dp
                        )
                    )
                    .background(Color.White.copy(0.05f))
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp, top = 8.dp, end = 8.dp, bottom = 40.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = producto.nombre,
                    fontSize = 11.sp,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    maxLines = 2
                )

                Spacer(modifier = Modifier.height(2.dp))

                Text(
                    text = "$${producto.precio}",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
        }

        Counter(
            cantidad = cantidad,
            onChange = onCantidadChange,
            modifier = Modifier
                .align(Alignment.BottomStart)
                .padding(start = 8.dp, bottom = 6.dp, end = 48.dp)
                .height(25.dp)
        )

        Box(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .size(30.dp)
                .clip(
                    RoundedCornerShape(
                        topStart = 12.dp,
                        bottomEnd = 16.dp
                    )
                )
                .background(
                    Brush.horizontalGradient(
                        listOf(VerdeModernoStart, VerdeModernoEnd)
                    )
                )
                .clickable { onAdd() },
            contentAlignment = Alignment.Center
        ) {
            Text(
                "+",
                color = Color.White,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}


@Composable
fun ContenidoIzquierda(
    selectedClienteId: Int,
    ordenes: MutableMap<Int, OrdenCliente>,
    onUpdateOrden: (MutableMap<Int, OrdenCliente>) -> Unit,
    isTablet: Boolean,
    onHistorialVenta: () -> Unit,
    onShowOrden: () -> Unit
) {

    val categorias = listOf(
        Categoria(0, "Todos", "#795548"),
        Categoria(1, "Sandwich", "#4CAF50"),
        Categoria(2, "Yaroas", "#FF9800"),
        Categoria(3, "Empanadas", "#E91E63"),
        Categoria(4, "Jugos Naturales", "#2196F3"),
        Categoria(5, "Ensaladas", "#9C27B0"),
        Categoria(6, "Postres", "#FFC107")
    )

    val productos = listOf(
        Producto(1, "Café Negro Con el gusto mas bueno", 50.0, 1),
        Producto(2, "Capuccino", 80.0, 1),
        Producto(3, "Jugo", 60.0, 2),
        Producto(4, "Brownie", 90.0, 3),
        Producto(5, "Sandwich", 120.0, 4)
    )

    var selectedCategoria by remember { mutableStateOf(0) }
    val contadores = remember { mutableStateMapOf<Int, Int>() }

    val productosFiltrados = if (selectedCategoria == 0)
        productos
    else
        productos.filter { it.categoriaId == selectedCategoria }

    val cantidadPorCategoria = remember(productos) {
        productos.groupingBy { it.categoriaId }.eachCount()
    }

    Box(modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 10.dp, vertical = 10.dp)
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

                    val cantidad = if (categoria.id == 0) {
                        productos.size
                    } else {
                        cantidadPorCategoria[categoria.id] ?: 0
                    }

                    FiltroChip(
                        titulo = categoria.nombre,
                        cantidad = cantidad,
                        seleccionado = categoria.id == selectedCategoria,
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
                        onClick = { selectedCategoria = categoria.id }
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

            LazyVerticalGrid(
                columns = GridCells.Adaptive(minSize = 140.dp),
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(bottom = 100.dp)
            ) {

                items(productosFiltrados) { producto ->

                    val contadorLocal = contadores[producto.id] ?: 0

                    ProductoCard(
                        producto = producto,
                        cantidad = contadorLocal,
                        onCantidadChange = { contadores[producto.id] = it },
                        onAdd = {

                            val cantidadAgregar = contadores[producto.id] ?: 0

                            if (cantidadAgregar > 0) {

                                val nuevaOrden = ordenes.toMutableMap()
                                val ordenCliente = nuevaOrden[selectedClienteId]
                                    ?: OrdenCliente(selectedClienteId)

                                val nuevaLista = ordenCliente.items.toMutableList()

                                val index = nuevaLista.indexOfFirst {
                                    it.producto.id == producto.id
                                }

                                if (index >= 0) {
                                    val existente = nuevaLista[index]
                                    nuevaLista[index] = existente.copy(
                                        cantidad = existente.cantidad + cantidadAgregar
                                    )
                                } else {
                                    nuevaLista.add(OrdenItem(producto, cantidadAgregar))
                                }

                                nuevaOrden[selectedClienteId] =
                                    ordenCliente.copy(items = nuevaLista)

                                onUpdateOrden(nuevaOrden)
                                contadores[producto.id] = 0
                            }
                        }
                    )
                }
            }
        }

        Column(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(start = 16.dp, bottom = 16.dp, end = 16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {

            FloatingButton(
                icon = Res.drawable.ico_historial,
                label = "Historial",
                size = 48,
                iconSize = 24,
                borderColor = Brush.horizontalGradient(
                    listOf(Color(0xFF81D4FA), Color(0xFF29B6F6))
                ),
                onClick = onHistorialVenta
            )

            if (!isTablet) {
                FloatingButton(
                    icon = Res.drawable.ico_shop_car,
                    label = "Carrito",
                    size = 48,
                    iconSize = 24,
                    borderColor = Brush.horizontalGradient(
                        listOf(Color(0xFFA5D6A7), Color(0xFF66BB6A))
                    ),
                    onClick = onShowOrden
                )
            }
        }
    }
}


@Composable
fun ContenidoDerecha(
    selectedClienteId: Int,
    ordenes: MutableMap<Int, OrdenCliente>,
    onUpdateOrden: (MutableMap<Int, OrdenCliente>) -> Unit,
    onRegresar: () -> Unit,
    isTablet: Boolean,
    onCompletarOrden: (Int) -> Unit
) {

    var telefono by remember { mutableStateOf("") }
    var cliente by remember { mutableStateOf("") }
    var direccion by remember { mutableStateOf("") }
    var comentario by remember { mutableStateOf("") }
    var delivery by remember { mutableStateOf("") }
    var area by remember { mutableStateOf("") }

    val ordenActual = ordenes[selectedClienteId]
    val items = ordenActual?.items ?: emptyList()

    val subtotal = items.sumOf { it.producto.precio * it.cantidad }
    val envio = delivery.toDoubleOrNull() ?: 0.0
    val totalGeneral = subtotal + envio

    val carritoVacio = items.isEmpty()

    if (carritoVacio) {

        Box(
            modifier = Modifier
                .fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {

            Column(horizontalAlignment = Alignment.CenterHorizontally) {

                Text(
                    text = "CARRITO VACÍO",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White.copy(alpha = 0.8f)
                )

                Spacer(modifier = Modifier.height(12.dp))

                if (!isTablet) {
                    Spacer(modifier = Modifier.height(8.dp))

                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
                    ) {
                        Slide(
                                title = "REGRESAR",
                            estado = true,
                            direction = "RIGHT",
                            borderColor = Brush.linearGradient(
                                colors = listOf(
                                    Color(0xFF8E2C2C),
                                    Color(0xFFA33A3A)
                                )
                            ),
                            horizontalPadding = 12,
                            fontSize = 12,
                            height = 36,
                            icon = Res.drawable.ico_flecha_izquierda,
                            onComplete = {
                                onRegresar()
                            },
                            onClick = {

                            },
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
            }
        }

    } else {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .verticalScroll(rememberScrollState())
        ) {

            Text(
                text = "PEDIDO",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(6.dp))

            Canvas(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(1.5.dp)
            ) {
                val dashWidth = 16f
                val gapWidth = 10f

                var x = 0f
                while (x < size.width) {
                    drawLine(
                        color = Color.Gray.copy(alpha = 0.6f),
                        start = Offset(x, size.height / 2),
                        end = Offset(x + dashWidth, size.height / 2),
                        strokeWidth = 1.5.dp.toPx()
                    )
                    x += dashWidth + gapWidth
                }
            }

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 6.dp, bottom = 4.dp)
            ) {

                Text(
                    text = "Formulario",
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

            Spacer(modifier = Modifier.height(12.dp))

            Input(
                value = telefono,
                onValueChange = { telefono = it },
                label = "Teléfono",
                borderRadius = 12,
                borderSize = 2,
                borderColor = Brush.horizontalGradient(
                    listOf(VerdeModernoStart, VerdeModernoEnd)
                ),
                textSize = 13,
                verticalPadding = 10,
                type = "Number",
                isPassword = false,
                isDisabled = false
            )

            Spacer(modifier = Modifier.height(8.dp))

            Input(
                value = cliente,
                onValueChange = { cliente = it },
                label = "Cliente",
                borderRadius = 12,
                borderSize = 2,
                borderColor = Brush.horizontalGradient(
                    listOf(VerdeModernoStart, VerdeModernoEnd)
                ),
                textSize = 13,
                verticalPadding = 10,
                type = "Text",
                isPassword = false,
                isDisabled = false
            )

            Spacer(modifier = Modifier.height(8.dp))

            Input(
                value = delivery,
                onValueChange = { delivery = it },
                label = "Envio",
                borderRadius = 12,
                borderSize = 2,
                borderColor = Brush.horizontalGradient(
                    listOf(VerdeModernoStart, VerdeModernoEnd)
                ),
                textSize = 13,
                verticalPadding = 10,
                type = "Number",
                isPassword = false,
                isDisabled = false
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Select(
                    selectedOption = area,
                    onOptionChange = { area = it },
                    titulo = "Pago",
                    options = listOf(
                        "Efectivo" to "Efectivo",
                        "Transferencia" to "Transferencia",
                    ),
                    borderRadius = 10,
                    borderColor = Brush.horizontalGradient(
                        listOf(VerdeModernoEnd, VerdeModernoStart)
                    ),
                    textSize = 13,
                    iconSize = 20,
                    verticalPadding = 10,
                    modifier = Modifier.weight(1f)
                )

                Select(
                    selectedOption = area,
                    onOptionChange = { area = it },
                    titulo = "Area",
                    options = listOf(
                        "Sandwich" to "Sandwich",
                        "Yaroa" to "Yaroa",
                    ),
                    borderRadius = 10,
                    borderColor = Brush.horizontalGradient(
                        listOf(VerdeModernoEnd, VerdeModernoStart)
                    ),
                    textSize = 13,
                    iconSize = 20,
                    verticalPadding = 10,
                    modifier = Modifier.weight(1f)
                )
            }

            Spacer(modifier = Modifier.height(8.dp))

            TextArea(
                value = direccion,
                onValueChange = { direccion = it },
                label = "Dirección",
                borderRadius = 12,
                borderColor = Brush.horizontalGradient(
                    listOf(VerdeModernoEnd, VerdeModernoStart)
                ),
                borderSize = 2,
                textSize = 14,
                verticalPadding = 14,
                minHeight = 80
            )

            Spacer(modifier = Modifier.height(8.dp))

            TextArea(
                value = comentario,
                onValueChange = { comentario = it },
                label = "Comentario",
                borderRadius = 12,
                borderColor = Brush.horizontalGradient(
                    listOf(VerdeModernoEnd, VerdeModernoStart)
                ),
                borderSize = 2,
                textSize = 14,
                verticalPadding = 14,
                minHeight = 80
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 6.dp, bottom = 4.dp)
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
                    text = "Carrito",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color.White.copy(alpha = 0.85f)
                )

            }

            Spacer(modifier = Modifier.height(8.dp))

            if (items.isEmpty()) {
                Text(
                    text = "Carrito Vacio",
                    color = Color.White.copy(alpha = 0.7f),
                    fontSize = 14.sp
                )
            } else {
                items.forEach { item ->

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 6.dp),
                        shape = RoundedCornerShape(14.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = Color.Transparent
                        ),
                        border = BorderStroke(
                            1.dp,
                            Color.White.copy(alpha = 0.2f)
                        )
                    ) {

                        Row(
                            modifier = Modifier.padding(12.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {

                            Image(
                                painter = painterResource(Res.drawable.ico_shop_car),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(50.dp)
                                    .clip(RoundedCornerShape(12.dp))
                            )

                            Spacer(modifier = Modifier.width(12.dp))

                            Column(modifier = Modifier.weight(1f)) {

                                Text(
                                    text = item.producto.nombre,
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White
                                )

                                Text(
                                    text = "RD$ ${item.producto.precio} x ${item.cantidad}",
                                    fontSize = 12.sp,
                                    color = Color.White.copy(alpha = 0.7f)
                                )
                            }

                            Column(horizontalAlignment = Alignment.End) {

                                Text(
                                    text = "RD$ ${item.producto.precio * item.cantidad}",
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = Color.White
                                )

                                Spacer(modifier = Modifier.height(6.dp))

                                Image(
                                    painter = painterResource(Res.drawable.ico_trash),
                                    contentDescription = "Eliminar",
                                    modifier = Modifier
                                        .size(20.dp)
                                        .clickable {
                                            val nuevaOrden = ordenes.toMutableMap()
                                            val orden = nuevaOrden[selectedClienteId]

                                            if (orden != null) {
                                                val nuevaLista = orden.items.toMutableList()
                                                nuevaLista.remove(item)

                                                nuevaOrden[selectedClienteId] =
                                                    orden.copy(items = nuevaLista)

                                                onUpdateOrden(nuevaOrden)
                                            }
                                        }
                                )
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 6.dp, bottom = 4.dp)
            ) {

                Text(
                    text = "Confirmacion",
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

            Spacer(modifier = Modifier.height(10.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(
                    containerColor = Color.Transparent
                ),
                border = BorderStroke(
                    1.dp,
                    Color.White.copy(alpha = 0.25f)
                )
            ) {

                Column(modifier = Modifier.padding(16.dp)) {

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("Subtotal", color = Color.White.copy(alpha = 0.7f))
                        Text("RD$ $subtotal", color = Color.White)
                    }

                    Spacer(modifier = Modifier.height(6.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("Envío", color = Color.White.copy(alpha = 0.7f))
                        Text("RD$ $envio", color = Color.White)
                    }

                    Divider(
                        modifier = Modifier.padding(vertical = 10.dp),
                        color = Color.White.copy(alpha = 0.2f)
                    )

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            "Total",
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                        Text(
                            "RD$ $totalGeneral",
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth()
            ) {

                Slide(
                    title = "IMPRIMIR",
                    estado = true,
                    direction = "LEFT",
                    borderColor = Brush.linearGradient(
                        colors = listOf(
                            Color(0xFFB39DDB),
                            Color(0xFF9575CD)
                        )
                    ),
                    horizontalPadding = 12,
                    fontSize = 12,
                    height = 36,
                    icon = Res.drawable.ico_print,
                    onComplete = {
                        onCompletarOrden(selectedClienteId)
                        telefono = ""
                        cliente = ""
                        direccion = ""
                        delivery = ""
                        area = ""
                        onRegresar()
                        playSound("aud_confirmacion")
                    },
                    onClick = {

                    },
                    modifier = Modifier.weight(1f)
                )

                Spacer(Modifier.width(8.dp))

                Slide(
                    title = "COMPLETAR",
                    estado = true,
                    direction = "RIGHT",
                    borderColor = Brush.linearGradient(
                        colors = listOf(
                            Color(0xFF2E7D6B),
                            Color(0xFF388E7B)
                        )
                    ),
                    horizontalPadding = 12,
                    fontSize = 12,
                    height = 36,
                    icon = Res.drawable.ico_check_white,
                    onComplete = {
                        onCompletarOrden(selectedClienteId)
                        telefono = ""
                        cliente = ""
                        direccion = ""
                        delivery = ""
                        area = ""
                        onRegresar()
                        playSound("aud_confirmacion")
                    },
                    onClick = {

                    },
                    modifier = Modifier.weight(1f)
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            if (!isTablet) {

                Spacer(modifier = Modifier.height(8.dp))

                Slide(
                    title = "REGRESAR",
                    estado = true,
                    direction = "RIGHT",
                    borderColor = Brush.linearGradient(
                        colors = listOf(
                            Color(0xFF8E2C2C),
                            Color(0xFFA33A3A)
                        )
                    ),
                    horizontalPadding = 12,
                    fontSize = 12,
                    height = 36,
                    icon = Res.drawable.ico_flecha_izquierda,
                    onComplete = {
                        onRegresar()
                    },
                    onClick = {

                    },
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }

    }
}


@Preview
@Composable
fun AdministradorVentasScreenPreview() {
    AdministradorVentasScreen()
}