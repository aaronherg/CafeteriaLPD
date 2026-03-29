package com.aarondevs.cafeterialpd.presentation.screens.admin.inicio

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafeterialaparada.composeapp.generated.resources.Res
import cafeterialaparada.composeapp.generated.resources.bg_decorative
import cafeterialaparada.composeapp.generated.resources.ico_box
import cafeterialaparada.composeapp.generated.resources.ico_cancelado
import cafeterialaparada.composeapp.generated.resources.ico_check
import cafeterialaparada.composeapp.generated.resources.ico_home
import cafeterialaparada.composeapp.generated.resources.ico_menu
import cafeterialaparada.composeapp.generated.resources.ico_pendiente
import cafeterialaparada.composeapp.generated.resources.ico_profile
import cafeterialaparada.composeapp.generated.resources.ico_setting
import cafeterialaparada.composeapp.generated.resources.ico_transito
import cafeterialaparada.composeapp.generated.resources.logocafeterialpd
import com.aarondevs.binareus.ui.theme.ButtonBackground
import com.aarondevs.binareus.ui.theme.SecondaryText
import com.aarondevs.binareus.ui.theme.VerdeModernoEnd
import com.aarondevs.binareus.ui.theme.VerdeModernoStart
import com.aarondevs.cafeterialpd.presentation.component.NavItem
import com.aarondevs.cafeterialpd.presentation.component.NavigationBar
import com.aarondevs.cafeterialpd.presentation.screens.general.login.LoginScreen
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun AdministradorInicioScreen(
    onPerfil: () -> Unit = {},
    onInventario: () -> Unit = {},
    onVenta: () -> Unit = {},
    onConfiguracion: () -> Unit = {}

) {
    AdministradorInicioScreenBody(
        onPerfil = onPerfil,
        onInventario = onInventario,
        onVenta = onVenta,
        onConfiguracion = onConfiguracion
    )
}

@Composable
fun AdministradorInicioScreenBody(
    onPerfil: () -> Unit = {},
    onInventario: () -> Unit = {},
    onVenta: () -> Unit = {},
    onConfiguracion: () -> Unit = {}
) {

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
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 170.dp)
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

                    AdministradorInicioContenidoScreen()

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
                            NavItem("Inicio", Res.drawable.ico_home),
                            NavItem("Inventario", Res.drawable.ico_box, onClick = onInventario),
                            NavItem("Configuración", Res.drawable.ico_setting, onClick = onConfiguracion),
                            NavItem("Perfil", Res.drawable.ico_profile, onClick = onPerfil)
                        ),
                        centerItem = NavItem("Ventas", Res.drawable.ico_menu, onClick = onVenta),
                        initialSelectedItem = "Inicio"
                    )
                }
            }
        }
    }
}


@Composable
fun BalanceVentaCard(
    balanceTotal: String,
    fecha: String
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(26.dp))
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color.White.copy(alpha = 0.10f),
                        Color.White.copy(alpha = 0.03f)
                    )
                )
            )
            .border(
                1.dp,
                Color.White.copy(alpha = 0.12f),
                RoundedCornerShape(26.dp)
            )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(22.dp)
        ) {
            Text(
                text = "BALANCE DE VENTAS",
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                letterSpacing = 1.sp,
                color = Color.White.copy(alpha = 0.55f)
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = fecha,
                fontSize = 10.sp,
                fontWeight = FontWeight.Normal,
                color = Color.White.copy(alpha = 0.35f)
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = balanceTotal,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
}

@Composable
fun DatosRapidoItemCard(
    icono: DrawableResource,
    titulo: String,
    cantidad: String,
    iconSize: Dp = 24.dp,
    fontSizeTitulo: TextUnit = 11.sp,
    fontSizeCantidad: TextUnit = 22.sp,
    paddingCard: Dp = 12.dp,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .aspectRatio(1f)
            .clip(RoundedCornerShape(16.dp))
            .background(Color.White.copy(alpha = 0.06f))
            .border(1.dp, Color.White.copy(alpha = 0.10f), RoundedCornerShape(16.dp))
            .padding(paddingCard),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(iconSize)
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color.Transparent),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(resource = icono),
                    contentDescription = titulo,
                    modifier = Modifier.fillMaxSize()
                )
            }

            Spacer(modifier = Modifier.height(6.dp))

            Text(
                text = titulo,
                fontSize = fontSizeTitulo,
                color = Color.White.copy(alpha = 0.6f)
            )

            Text(
                text = cantidad,
                fontSize = fontSizeCantidad,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
}


data class Movimiento(
    val foto: DrawableResource?,
    val nombre: String,
    val tipo: String,
    val fecha: String,
    val monto: String
)

@Composable
fun ListaMovimientosCard(
    movimientos: List<Movimiento>
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(26.dp))
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color.White.copy(alpha = 0.10f),
                        Color.White.copy(alpha = 0.03f)
                    )
                )
            )
            .border(
                1.dp,
                Color.White.copy(alpha = 0.12f),
                RoundedCornerShape(26.dp)
            )
            .padding(16.dp)
    ) {
        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {

            Text(
                text = "Movimientos Recientes",
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                color = Color.White.copy(alpha = 0.7f)
            )

            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                movimientos.take(5).forEach { movimiento ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(18.dp))
                            .background(Color.White.copy(alpha = 0.05f))
                            .padding(12.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Box(
                            modifier = Modifier
                                .size(36.dp)
                                .clip(CircleShape)
                        ) {
                            movimiento.foto?.let {
                                Image(
                                    painter = painterResource(it),
                                    contentDescription = movimiento.nombre,
                                    modifier = Modifier.fillMaxSize().clip(CircleShape),
                                    contentScale = ContentScale.Crop
                                )
                            }
                        }

                        Spacer(modifier = Modifier.width(12.dp))

                        Column(modifier = Modifier.weight(1f)) {
                            Text(
                                text = movimiento.nombre,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White
                            )
                            Text(
                                text = movimiento.tipo,
                                fontSize = 11.sp,
                                color = Color.White.copy(alpha = 0.6f)
                            )
                            Text(
                                text = movimiento.fecha,
                                fontSize = 11.sp,
                                color = Color.White.copy(alpha = 0.6f)
                            )
                        }

                        val montoColor = when (movimiento.tipo) {
                            "Pendiente", "Transito" -> Color(0xFFFFA500)
                            "Entregado", "Completado" -> Color(0xFF4CAF50)
                            "Cancelado" -> Color(0xFFF44336)
                            else -> Color.White
                        }

                        Text(
                            text = "${if (movimiento.tipo == "Entregado") "+" else ""}${movimiento.monto}",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = montoColor
                        )
                    }
                }
            }
        }
    }
}


@Composable
fun AdministradorInicioContenidoScreen() {
    val fechaResumen = "Hoy 27/03/2026"
    val datosRapidos = listOf(
        Triple(Res.drawable.ico_pendiente, "Pendientes", "24"),
        Triple(Res.drawable.ico_transito, "Transito", "12"),
        Triple(Res.drawable.ico_check, "Entregado", "3"),
        Triple(Res.drawable.ico_cancelado, "Cancelados", "3")
    )

    val movimientos = listOf(
        Movimiento(Res.drawable.ico_pendiente, "Juan Pérez", "Pendiente", "27/03/2026", "RD$ 1,200"),
        Movimiento(Res.drawable.ico_check, "Ana Gómez", "Completado", "27/03/2026", "RD$ 500"),
        Movimiento(Res.drawable.ico_transito, "Carlos Díaz", "Transito", "26/03/2026", "RD$ 800"),
        Movimiento(Res.drawable.ico_pendiente, "María López", "Pendiente", "26/03/2026", "RD$ 300"),
        Movimiento(Res.drawable.ico_cancelado, "Luis Torres", "Cancelado", "25/03/2026", "RD$ 1,000")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        VerdeModernoStart.copy(alpha = 0.01f),
                        VerdeModernoEnd.copy(alpha = 0.01f)
                    )
                )
            )
            .padding(horizontal = 10.dp, vertical = 10.dp)
    ) {

        BalanceVentaCard(
            balanceTotal = "RD$ 12,455.00",
            fecha = fechaResumen
        )

        Spacer(modifier = Modifier.height(20.dp))

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .clip(RoundedCornerShape(22.dp))
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.White.copy(alpha = 0.08f),
                            Color.White.copy(alpha = 0.02f)
                        )
                    )
                )
                .border(
                    1.dp,
                    Color.White.copy(alpha = 0.12f),
                    RoundedCornerShape(22.dp)
                )
                .padding(12.dp)
        ) {
            Column {
                Text(
                    text = "RESUMEN DE VENTA",
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Medium,
                    letterSpacing = 1.sp,
                    color = Color.White.copy(alpha = 0.55f),
                    modifier = Modifier.padding(horizontal = 4.dp)
                )

                Spacer(modifier = Modifier.height(4.dp))

                Text(
                    text = fechaResumen,
                    fontSize = 9.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.White.copy(alpha = 0.35f),
                    modifier = Modifier.padding(horizontal = 4.dp)
                )

                Spacer(modifier = Modifier.height(10.dp))

                LazyVerticalGrid(
                    columns = GridCells.Adaptive(minSize = 70.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(max = 400.dp)
                ) {
                    items(datosRapidos) { item ->
                        DatosRapidoItemCard(
                            icono = item.first,
                            titulo = item.second,
                            cantidad = item.third,
                            iconSize = 18.dp,
                            fontSizeTitulo = 9.sp,
                            fontSizeCantidad = 18.sp,
                            paddingCard = 8.dp
                        )
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        ListaMovimientosCard(movimientos)
    }
}


@Preview
@Composable
fun AdministradorInicioScreenPreview() {
    AdministradorInicioScreen()
}