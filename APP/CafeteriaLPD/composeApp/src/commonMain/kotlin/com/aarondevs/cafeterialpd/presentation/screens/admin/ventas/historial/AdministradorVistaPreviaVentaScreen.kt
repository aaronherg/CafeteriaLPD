package com.aarondevs.cafeterialpd.presentation.screens.admin.ventas.historial

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafeterialaparada.composeapp.generated.resources.Res
import cafeterialaparada.composeapp.generated.resources.*
import com.aarondevs.binareus.ui.theme.VerdeModernoEnd
import com.aarondevs.binareus.ui.theme.VerdeModernoStart
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

@Composable
fun AdministradorVistaPreviaVentaScreen(
    onRetroceder: () -> Unit = {},
    onInformacion: () -> Unit = {}
) {
    AdministradorVistaPreviaVentaScreenBody(
        onRetroceder = onRetroceder,
        onInformacion = onInformacion
    )
}

@Composable
fun AdministradorVistaPreviaVentaScreenBody(
    onRetroceder: () -> Unit = {},
    onInformacion: () -> Unit = {}
) {

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
                            text = "Vista Previa de Venta",
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

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    // 🔹 IZQUIERDA (30%) - ESTADO
                    Column(
                        modifier = Modifier
                            .weight(0.3f),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {

                        Image(
                            painter = painterResource(Res.drawable.ico_transito),
                            contentDescription = null,
                            modifier = Modifier.size(32.dp)
                        )

                        Spacer(Modifier.height(6.dp))

                        Text(
                            "En Transito",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White,
                            textAlign = TextAlign.Center
                        )

                        Spacer(Modifier.height(2.dp))

                        Text(
                            "26 Mar 2026",
                            fontSize = 9.sp,
                            color = Color.White.copy(alpha = 0.6f),
                            textAlign = TextAlign.Center
                        )
                    }

                    // 🔸 DIVISOR VERTICAL PUNTEADO
                    Column(
                        modifier = Modifier
                            .height(100.dp)
                            .padding(horizontal = 6.dp),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        repeat(8) {
                            Box(
                                modifier = Modifier
                                    .width(2.dp)
                                    .height(6.dp)
                                    .background(Color.White.copy(alpha = 0.3f))
                            )
                        }
                    }

                    // 🔹 DERECHA (70%) - INFORMACIÓN
                    Column(
                        modifier = Modifier
                            .weight(0.7f)
                    ) {

                        // Cliente + Código
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    "Juan Pérez",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Medium,
                                    color = Color.White,
                                    maxLines = 1
                                )
                                Text(
                                    "Cliente",
                                    fontSize = 9.sp,
                                    color = Color.White.copy(alpha = 0.6f)
                                )
                            }

                            Column(modifier = Modifier.weight(1f)) {
                                Text(
                                    "#VENTA-00125",
                                    fontSize = 12.sp,
                                    fontWeight = FontWeight.Medium,
                                    color = Color.White,
                                    maxLines = 1
                                )
                                Text(
                                    "Código",
                                    fontSize = 9.sp,
                                    color = Color.White.copy(alpha = 0.6f)
                                )
                            }
                        }

                        Spacer(Modifier.height(8.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {

                            Column {
                                Text("809-555-1234", fontSize = 10.sp, color = Color.White)
                                Text("Teléfono", fontSize = 8.sp, color = Color.White.copy(alpha = 0.6f))
                            }

                            Column {
                                Text("Zona Norte", fontSize = 10.sp, color = Color.White)
                                Text("Área", fontSize = 8.sp, color = Color.White.copy(alpha = 0.6f))
                            }

                            Column {
                                Text("Efectivo", fontSize = 10.sp, color = Color.White)
                                Text("Pago", fontSize = 8.sp, color = Color.White.copy(alpha = 0.6f))
                            }
                        }

                        Spacer(Modifier.height(8.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {

                            Column {
                                Text("RD$ 600.0", fontSize = 10.sp, color = Color.White)
                                Text("Subtotal", fontSize = 8.sp, color = Color.White.copy(alpha = 0.6f))
                            }

                            Column {
                                Text("RD$ 0.0", fontSize = 10.sp, color = Color.White)
                                Text("Envio", fontSize = 8.sp, color = Color.White.copy(alpha = 0.6f))
                            }
                        }

                        Spacer(Modifier.height(8.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.spacedBy(8.dp)
                        ) {

                            Column(
                                modifier = Modifier.weight(1f)
                            ) {
                                Text(
                                    "Calle Duarte #45, Cerca del parque central",
                                    fontSize = 10.sp,
                                    color = Color.White.copy(alpha = 0.85f),
                                    maxLines = 2,
                                    overflow = TextOverflow.Ellipsis
                                )
                                Text(
                                    "Dirección",
                                    fontSize = 8.sp,
                                    color = Color.White.copy(alpha = 0.6f)
                                )
                            }

                            Column(
                                modifier = Modifier.weight(1f),
                                horizontalAlignment = Alignment.End
                            ) {
                                Text(
                                    "Sin comentario",
                                    fontSize = 10.sp,
                                    color = Color.White.copy(alpha = 0.85f),
                                    maxLines = 2,
                                    overflow = TextOverflow.Ellipsis,
                                    textAlign = TextAlign.End
                                )
                                Text(
                                    "Comentario",
                                    fontSize = 8.sp,
                                    color = Color.White.copy(alpha = 0.6f),
                                    textAlign = TextAlign.End
                                )
                            }
                        }
                    }
                }
            }


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

                        AdministradorVistaPreviaVentaContenido()
                    }
                }
            }
        }
    }
}

data class ProductoCarritoUI(
    val imagen: DrawableResource,
    val nombre: String,
    val precio: Double,
    val cantidad: Int
)

@Composable
fun AdministradorVistaPreviaVentaContenido() {

    val productos = listOf(
        ProductoCarritoUI(Res.drawable.ico_shop_car, "Hamburguesa Clásica", 250.0, 2),
        ProductoCarritoUI(Res.drawable.ico_shop_car, "Pizza Personal", 450.0, 1),
        ProductoCarritoUI(Res.drawable.ico_shop_car, "Papas Fritas", 150.0, 3),
        ProductoCarritoUI(Res.drawable.ico_shop_car, "Refresco 1L", 120.0, 2),
        ProductoCarritoUI(Res.drawable.ico_shop_car, "Hot Dog Especial", 180.0, 1)
    )

    val filtrados = productos.filter { it.cantidad >= 1 }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 16.dp, vertical = 16.dp)
        ) {

            Text(
                text = "ARTÍCULOS EN CARRITO",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )

            Spacer(Modifier.height(12.dp))

            filtrados.forEach { item ->

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                        .background(
                            Color.White.copy(alpha = 0.04f),
                            RoundedCornerShape(14.dp)
                        )
                        .padding(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Box(
                        modifier = Modifier
                            .size(52.dp)
                            .background(
                                Color.White.copy(alpha = 0.08f),
                                RoundedCornerShape(12.dp)
                            ),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(item.imagen),
                            contentDescription = null,
                            modifier = Modifier.size(28.dp)
                        )
                    }

                    Spacer(Modifier.width(12.dp))

                    Column(
                        modifier = Modifier.weight(1f)
                    ) {

                        Text(
                            text = item.nombre,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.SemiBold,
                            color = Color.White,
                            maxLines = 1
                        )

                        Spacer(Modifier.height(4.dp))

                        Text(
                            text = "RD$ ${item.precio} x ${item.cantidad}",
                            fontSize = 11.sp,
                            color = Color.White.copy(alpha = 0.6f)
                        )
                    }

                    Column(
                        horizontalAlignment = Alignment.End
                    ) {

                        Text(
                            text = "RD$ ${item.precio * item.cantidad}",
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )

                        Spacer(Modifier.height(4.dp))

                        Text(
                            text = "${item.cantidad} und",
                            fontSize = 10.sp,
                            color = Color.White.copy(alpha = 0.5f)
                        )
                    }
                }
            }

            Spacer(Modifier.height(16.dp))
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 14.dp)
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .background(
                        Color.Transparent,
                        shape = RoundedCornerShape(35.dp)
                    )
                    .border(
                        2.dp,
                        Brush.horizontalGradient(
                            listOf(VerdeModernoStart, VerdeModernoEnd)
                        ),
                        RoundedCornerShape(50.dp)
                    )
                    .padding(horizontal = 18.dp, vertical = 14.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Column {
                    Text(
                        "Total",
                        fontSize = 10.sp,
                        color = Color.White.copy(alpha = 0.6f)
                    )

                    Text(
                        "RD$ 2,350.00",
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }

                Spacer(modifier = Modifier.weight(1f))

                Row(
                    horizontalArrangement = Arrangement.spacedBy(18.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                    Image(
                        painter = painterResource(Res.drawable.ico_print_color),
                        contentDescription = null,
                        modifier = Modifier
                            .size(26.dp)
                            .clickable { }
                    )

                    Image(
                        painter = painterResource(Res.drawable.ico_whatsapp),
                        contentDescription = null,
                        modifier = Modifier
                            .size(26.dp)
                            .clickable { }
                    )

                    Image(
                        painter = painterResource(Res.drawable.ico_download),
                        contentDescription = null,
                        modifier = Modifier
                            .size(26.dp)
                            .clickable { }
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun AdministradorVistaPreviaVentaScreenPreview() {
    AdministradorVistaPreviaVentaScreen()
}