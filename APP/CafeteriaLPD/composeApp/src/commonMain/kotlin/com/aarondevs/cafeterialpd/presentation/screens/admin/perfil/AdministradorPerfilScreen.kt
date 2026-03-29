package com.aarondevs.cafeterialpd.presentation.screens.admin.perfil

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PaintingStyle.Companion.Stroke
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafeterialaparada.composeapp.generated.resources.Res
import cafeterialaparada.composeapp.generated.resources.*
import com.aarondevs.binareus.ui.theme.ButtonBackground
import com.aarondevs.binareus.ui.theme.PrimaryText
import com.aarondevs.binareus.ui.theme.SecondaryText
import com.aarondevs.binareus.ui.theme.VerdeModernoEnd
import com.aarondevs.binareus.ui.theme.VerdeModernoStart
import com.aarondevs.cafeterialpd.presentation.component.Button
import com.aarondevs.cafeterialpd.presentation.component.NavItem
import com.aarondevs.cafeterialpd.presentation.component.NavigationBar
import com.aarondevs.cafeterialpd.presentation.component.Notificacion
import com.aarondevs.cafeterialpd.presentation.component.NotificationType
import org.jetbrains.compose.resources.painterResource

@Composable
fun AdministradorPerfilScreen(
    onInicio: () -> Unit = {},
    onInventario: () -> Unit = {},
    onVenta: () -> Unit = {},
    onConfiguracion: () -> Unit = {},
    onEditarUsuario: () -> Unit = {},
    onCerrarSesion: () -> Unit = {}

) {
    AdministradorPerfilScreenBody(
        onInicio = onInicio,
        onInventario = onInventario,
        onVenta = onVenta,
        onConfiguracion = onConfiguracion,
        onEditarUsuario = onEditarUsuario,
        onCerrarSesion = onCerrarSesion
    )
}

@Composable
fun AdministradorPerfilScreenBody(
    onInicio: () -> Unit = {},
    onInventario: () -> Unit = {},
    onVenta: () -> Unit = {},
    onConfiguracion: () -> Unit = {},
    onEditarUsuario: () -> Unit = {},
    onCerrarSesion: () -> Unit = {}
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

                    AdministradorPerfilContenidoScreen(
                        onEditarUsuario = onEditarUsuario,
                        onCerrarSesion = onCerrarSesion
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
                            NavItem("Configuración", Res.drawable.ico_setting, onClick = onConfiguracion),
                            NavItem("Perfil", Res.drawable.ico_profile)
                        ),
                        centerItem = NavItem("Ventas", Res.drawable.ico_menu, onClick = onVenta),
                        initialSelectedItem = "Perfil"
                    )
                }
            }
        }
    }
}
@Composable
fun AdministradorPerfilContenidoScreen(
    onEditarUsuario: () -> Unit = {},
    onCerrarSesion: () -> Unit = {}
) {
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
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Box(
                modifier = Modifier.size(100.dp),
                contentAlignment = Alignment.Center
            ) {
                Canvas(modifier = Modifier.matchParentSize()) {
                    drawCircle(
                        brush = Brush.linearGradient(listOf(VerdeModernoStart, VerdeModernoEnd)),
                        style = Stroke(
                            width = 2f,
                            pathEffect = PathEffect.dashPathEffect(floatArrayOf(12f, 6f))
                        )
                    )
                }

                Image(
                    painter = painterResource(Res.drawable.ico_chico),
                    contentDescription = "Foto de perfil",
                    modifier = Modifier
                        .size(92.dp)
                        .clip(CircleShape)
                )

                Box(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .offset(x = 10.dp, y = 10.dp)
                        .size(26.dp)
                        .clip(CircleShape)
                        .background(Brush.linearGradient(listOf(VerdeModernoStart, VerdeModernoEnd)))
                        .clickable {
                            Notificacion("Acceso Denegado", "Esta funcionalidad no está disponible en este momento.", NotificationType.Informacion)
                            onEditarUsuario()
                                   },
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(Res.drawable.ico_profile_edit),
                        contentDescription = "Editar",
                        modifier = Modifier.size(14.dp)
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            val perfilDatos = listOf(
                Triple("Nombre", "Juan", Res.drawable.ico_profile),
                Triple("Apellido", "Perez", Res.drawable.ico_profile),
                Triple("Sexo", "M", Res.drawable.ico_profile),
                Triple("Rol", "Administrador", Res.drawable.ico_profile),
                Triple("Correo", "juan.perez@mail.com", Res.drawable.ico_profile),
                Triple("Contraseña", "********", Res.drawable.ico_profile)
            )

            Column(
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                perfilDatos.forEach { (label, value, icon) ->
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 4.dp)
                    ) {
                        Canvas(modifier = Modifier.matchParentSize()) {
                            drawRoundRect(
                                brush = Brush.linearGradient(listOf(VerdeModernoStart, VerdeModernoEnd)),
                                style = Stroke(
                                    width = 1.8f,
                                    pathEffect = PathEffect.dashPathEffect(floatArrayOf(12f, 6f))
                                ),
                                cornerRadius = CornerRadius(16f, 16f)
                            )
                        }

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(12.dp),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Image(
                                painter = painterResource(icon),
                                contentDescription = null,
                                modifier = Modifier.size(24.dp)
                            )

                            Spacer(modifier = Modifier.width(12.dp))

                            Column {
                                Text(
                                    text = value,
                                    fontSize = 15.sp,
                                    fontWeight = FontWeight.Medium,
                                    color = Color.White
                                )
                                Text(
                                    text = label.uppercase(),
                                    fontSize = 10.sp,
                                    color = Color.Gray
                                )
                            }
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                text = "Cerrar Sesión",
                onClick = { onCerrarSesion() },
                borderRadius = 20,
                borderSize = 2,
                borderColor = Brush.horizontalGradient(listOf(VerdeModernoStart, VerdeModernoEnd)),
                textSize = 14,
                modifier = Modifier.fillMaxWidth(0.9f)
            )

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Preview
@Composable
fun AdministradorPerfilScreenPreview() {
    AdministradorPerfilScreen()
}
