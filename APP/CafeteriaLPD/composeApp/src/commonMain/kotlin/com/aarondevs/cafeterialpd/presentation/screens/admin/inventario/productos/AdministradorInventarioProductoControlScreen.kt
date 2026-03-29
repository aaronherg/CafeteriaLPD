package com.aarondevs.cafeterialpd.presentation.screens.admin.inventario.productos

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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.ContentScale
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
import cafeterialaparada.composeapp.generated.resources.ico_camera
import cafeterialaparada.composeapp.generated.resources.ico_check_white
import cafeterialaparada.composeapp.generated.resources.ico_chico
import cafeterialaparada.composeapp.generated.resources.ico_editar
import cafeterialaparada.composeapp.generated.resources.ico_flecha_derecha
import cafeterialaparada.composeapp.generated.resources.ico_informacion
import cafeterialaparada.composeapp.generated.resources.ico_new
import cafeterialaparada.composeapp.generated.resources.ico_profile_edit
import cafeterialaparada.composeapp.generated.resources.temp_kit_comida
import com.aarondevs.binareus.ui.theme.VerdeModernoEnd
import com.aarondevs.binareus.ui.theme.VerdeModernoStart
import com.aarondevs.cafeterialpd.presentation.component.Input
import com.aarondevs.cafeterialpd.presentation.component.Notificacion
import com.aarondevs.cafeterialpd.presentation.component.NotificationType
import com.aarondevs.cafeterialpd.presentation.component.Select
import com.aarondevs.cafeterialpd.presentation.component.Slide
import com.aarondevs.cafeterialpd.shared.playSound
import org.jetbrains.compose.resources.painterResource

@Composable
fun AdministradorInventarioProductoControlScreen(
    onRetroceder: () -> Unit = {},
    onInformacion: () -> Unit = {}
) {
    AdministradorInventarioProductoControlScreenBody(
        onRetroceder = onRetroceder,
        onInformacion = onInformacion
    )
}

@Composable
fun AdministradorInventarioProductoControlScreenBody(
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
                            text = "{ACCION} Producto",
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
                    text = "Complete el formulario satisfactoriamente.",
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
                        AdministradorConfiguracionUsuarioControlContenidoScreen(
                            onRetroceder = onRetroceder
                        )
                    }
                }
            }
        }
    }

}




@Composable
fun AdministradorConfiguracionUsuarioControlContenidoScreen(
    onRetroceder: () -> Unit = {}
){
    Box(modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 10.dp, vertical = 30.dp)
        ) {

            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Box(
                    modifier = Modifier.size(100.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(Res.drawable.temp_kit_comida),
                        contentDescription = "Foto de Producto",
                        modifier = Modifier
                            .size(92.dp)
                            .clip(CircleShape)
                            .border(
                                width = 2.dp,
                                brush = Brush.linearGradient(listOf(VerdeModernoStart, VerdeModernoEnd)),
                                shape = CircleShape
                            )
                    )

                    Box(
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .offset(x = 15.dp, y = 5.dp)
                            .size(26.dp)
                            .clip(CircleShape)
                            .background(Brush.linearGradient(listOf(VerdeModernoStart, VerdeModernoEnd)))
                            .clickable {

                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(Res.drawable.ico_editar),
                            contentDescription = "Editar",
                            modifier = Modifier.size(14.dp)
                        )
                    }

                    Box(
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .offset(x = 26.dp, y = -30.dp)
                            .size(26.dp)
                            .clip(CircleShape)
                            .background(Brush.linearGradient(listOf(VerdeModernoStart, VerdeModernoEnd)))
                            .clickable {

                            },
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(Res.drawable.ico_camera),
                            contentDescription = "Camara",
                            modifier = Modifier.size(14.dp)
                        )
                    }
                }

                Input(
                    value = "",
                    onValueChange = { },
                    label = "Descripción",
                    borderRadius = 10,
                    borderSize = 2,
                    borderColor = Brush.horizontalGradient(
                        listOf(VerdeModernoEnd, VerdeModernoStart)
                    ),
                    textSize = 14,
                    verticalPadding = 16,
                    type = "Text",
                    isPassword = false,
                    isDisabled = false
                )

                Input(
                    value = "",
                    onValueChange = { },
                    label = "Precio",
                    borderRadius = 10,
                    borderSize = 2,
                    borderColor = Brush.horizontalGradient(
                        listOf(VerdeModernoEnd, VerdeModernoStart)
                    ),
                    textSize = 14,
                    verticalPadding = 16,
                    type = "Number",
                    isPassword = false,
                    isDisabled = false
                )

                Select(
                    selectedOption = "",
                    onOptionChange = {},
                    titulo = "Categoria",
                    options = listOf(
                        "1" to "Sandwich",
                        "2" to "Yaroa",
                    ),
                    borderRadius = 10,
                    borderColor = Brush.horizontalGradient(
                        listOf(VerdeModernoEnd, VerdeModernoStart)
                    ),
                    textSize = 14,
                    iconSize = 20,
                    verticalPadding = 16,
                    modifier = Modifier
                )

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {

                    Slide(
                        title = "CANCELAR",
                        estado = true,
                        direction = "LEFT",
                        borderColor = Brush.linearGradient(
                            colors = listOf(
                                Color(0xFF8E2C2C),
                                Color(0xFFA33A3A)
                            )
                        ),
                        horizontalPadding = 12,
                        fontSize = 12,
                        height = 36,
                        icon = Res.drawable.ico_flecha_derecha,
                        onComplete = {
                            onRetroceder()
                        },
                        onClick = {

                        },
                        modifier = Modifier.weight(1f)
                    )

                    Spacer(Modifier.width(8.dp))

                    Slide(
                        title = "GUARDAR",
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
                            playSound("aud_confirmacion")
                        },
                        onClick = {

                        },
                        modifier = Modifier.weight(1f)
                    )
                }

            }

        }
    }

}


@Preview
@Composable
fun AdministradorInventarioProductoControlScreenPreview() {
    AdministradorInventarioProductoControlScreen()
}