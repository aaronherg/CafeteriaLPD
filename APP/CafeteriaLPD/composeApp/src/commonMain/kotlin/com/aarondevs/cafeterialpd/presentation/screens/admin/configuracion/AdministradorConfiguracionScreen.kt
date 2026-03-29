package com.aarondevs.cafeterialpd.presentation.screens.admin.configuracion

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
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
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafeterialaparada.composeapp.generated.resources.Res
import cafeterialaparada.composeapp.generated.resources.*
import com.aarondevs.binareus.ui.theme.ButtonBackground
import com.aarondevs.binareus.ui.theme.SecondaryText
import com.aarondevs.binareus.ui.theme.VerdeModernoEnd
import com.aarondevs.binareus.ui.theme.VerdeModernoStart
import com.aarondevs.cafeterialpd.presentation.component.Input
import com.aarondevs.cafeterialpd.presentation.component.NavItem
import com.aarondevs.cafeterialpd.presentation.component.NavigationBar
import com.aarondevs.cafeterialpd.presentation.component.PrinterBluetooh
import com.aarondevs.cafeterialpd.presentation.component.PrinterDevice
import com.aarondevs.cafeterialpd.presentation.component.TextArea
import com.aarondevs.cafeterialpd.presentation.screens.admin.ventas.AdministradorVentasScreen
import org.jetbrains.compose.resources.painterResource

@Composable
fun AdministradorConfiguracionScreen(
    onInicio: () -> Unit = {},
    onInventario: () -> Unit = {},
    onVenta: () -> Unit = {},
    onAreas: () -> Unit = {},
    onPerfil: () -> Unit = {},
    onGeneral: () -> Unit = {},
    onImpresoras: () -> Unit = {},
    onUsuarios: () -> Unit = {}

) {
    AdministradorConfiguracionScreenBody(
        onInicio = onInicio,
        onInventario = onInventario,
        onVenta = onVenta,
        onPerfil = onPerfil,
        onAreas = onAreas,
        onGeneral = onGeneral,
        onImpresoras = onImpresoras,
        onUsuarios = onUsuarios,
    )
}

@Composable
fun AdministradorConfiguracionScreenBody(
    onInicio: () -> Unit = {},
    onInventario: () -> Unit = {},
    onVenta: () -> Unit = {},
    onPerfil: () -> Unit = {},
    onAreas: () -> Unit = {},
    onGeneral: () -> Unit = {},
    onImpresoras: () -> Unit = {},
    onUsuarios: () -> Unit = {}
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

                    AdministradorConfiguracionContenidoScreen(
                        onAreas = onAreas,
                        onGeneral = onGeneral,
                        onImpresoras = onImpresoras,
                        onUsuarios = onUsuarios
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
                            NavItem("Configuración", Res.drawable.ico_setting),
                            NavItem("Perfil", Res.drawable.ico_profile, onClick = onPerfil)
                        ),
                        centerItem = NavItem("Ventas", Res.drawable.ico_menu, onClick = onVenta),
                        initialSelectedItem = "Configuración"
                    )
                }
            }
        }
    }
}

@Composable
fun AdministradorConfiguracionContenidoScreen(
    onAreas: () -> Unit = {},
    onGeneral: () -> Unit = {},
    onImpresoras: () -> Unit = {},
    onUsuarios: () -> Unit = {}
) {

    val items = listOf(
        Triple("Negocio", Res.drawable.ico_home, { onGeneral() }),
        Triple("Impresora", Res.drawable.ico_print, { onImpresoras() }),
        Triple("Usuarios", Res.drawable.ico_users, { onUsuarios() }),
        Triple("Areas", Res.drawable.ico_areas, { onAreas() })
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        VerdeModernoStart.copy(alpha = 0.01f),
                        VerdeModernoEnd.copy(alpha = 0.01f)
                    )
                )
            )
    ){

        LazyVerticalGrid(
            columns = GridCells.Adaptive(minSize = 100.dp),
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 12.dp, vertical = 24.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(items.size) { index ->

                val (title, icon, action) = items[index]

                Box(
                    modifier = Modifier
                        .aspectRatio(1f)
                        .fillMaxWidth()
                        .clickable { action() }
                        .padding(4.dp)
                ) {

                    Canvas(modifier = Modifier.matchParentSize()) {
                        drawRoundRect(
                            brush = Brush.linearGradient(
                                listOf(VerdeModernoStart, VerdeModernoEnd)
                            ),
                            style = Stroke(
                                width = 2.5f,
                                pathEffect = PathEffect.dashPathEffect(floatArrayOf(10f, 6f))
                            ),
                            cornerRadius = CornerRadius(32f, 32f)
                        )
                    }

                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(8.dp),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        Box(
                            modifier = Modifier.size(44.dp),
                            contentAlignment = Alignment.Center
                        ) {

                            Canvas(modifier = Modifier.matchParentSize()) {
                                drawCircle(
                                    brush = Brush.linearGradient(
                                        listOf(VerdeModernoStart, VerdeModernoEnd)
                                    ),
                                    style = Stroke(
                                        width = 2.5f,
                                        pathEffect = PathEffect.dashPathEffect(floatArrayOf(8f, 5f))
                                    )
                                )
                            }

                            Image(
                                painter = painterResource(icon),
                                contentDescription = null,
                                modifier = Modifier.size(20.dp)
                            )
                        }

                        Spacer(modifier = Modifier.height(6.dp))

                        Text(
                            text = title,
                            color = Color.White,
                            fontSize = 11.sp,
                            fontWeight = FontWeight.Medium
                        )
                    }
                }
            }
        }
    }
}


@Preview
@Composable
fun AdministradorConfiguracionScreenPreview() {
    AdministradorConfiguracionScreen()
}