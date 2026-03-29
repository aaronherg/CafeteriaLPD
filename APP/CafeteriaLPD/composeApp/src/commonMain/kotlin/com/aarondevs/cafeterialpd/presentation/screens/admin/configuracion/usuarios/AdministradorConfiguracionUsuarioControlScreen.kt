package com.aarondevs.cafeterialpd.presentation.screens.admin.configuracion.usuarios

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import cafeterialaparada.composeapp.generated.resources.bg_principal
import cafeterialaparada.composeapp.generated.resources.bg_solido
import cafeterialaparada.composeapp.generated.resources.ico_back
import cafeterialaparada.composeapp.generated.resources.ico_check_white
import cafeterialaparada.composeapp.generated.resources.ico_flecha_derecha
import cafeterialaparada.composeapp.generated.resources.ico_informacion
import com.aarondevs.binareus.ui.theme.VerdeModernoEnd
import com.aarondevs.binareus.ui.theme.VerdeModernoStart
import com.aarondevs.cafeterialpd.presentation.component.Input
import com.aarondevs.cafeterialpd.presentation.component.Select
import com.aarondevs.cafeterialpd.presentation.component.Slide
import com.aarondevs.cafeterialpd.shared.playSound
import org.jetbrains.compose.resources.painterResource

@Composable
fun AdministradorConfiguracionUsuarioControlScreen(
    onRetroceder: () -> Unit = {},
    onInformacion: () -> Unit = {}
) {
    AdministradorConfiguracionUsuarioControlScreenBody(
        onRetroceder = onRetroceder,
        onInformacion = onInformacion
    )
}

@Composable
fun AdministradorConfiguracionUsuarioControlScreenBody(
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
                            text = "{ACCION} Usuario",
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
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                Input(
                    value = "",
                    onValueChange = { },
                    label = "Nombre",
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
                    label = "Apellido",
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

                Row(
                    modifier = Modifier.fillMaxWidth()
                ) {

                    Select(
                        selectedOption = "",
                        onOptionChange = {},
                        titulo = "Rol",
                        options = listOf(
                            "Administrador" to "Administrador",
                            "Cajero" to "Cajero",
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

                    Spacer(Modifier.width(8.dp))

                    Select(
                        selectedOption = "",
                        onOptionChange = {},
                        titulo = "Sexo",
                        options = listOf(
                            "Masculino" to "Masculino",
                            "Femenino" to "Femenino",
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

                Input(
                    value = "",
                    onValueChange = { },
                    label = "Correo Electrónico",
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
                    label = "Contrasena",
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
fun AdministradorConfiguracionUsuarioControlControlScreenPreview() {
    AdministradorConfiguracionUsuarioControlScreen()
}