package com.aarondevs.cafeterialpd.presentation.screens.general.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafeterialaparada.composeapp.generated.resources.*
import com.aarondevs.binareus.ui.theme.BackgroundMain
import com.aarondevs.binareus.ui.theme.VerdeModernoEnd
import com.aarondevs.binareus.ui.theme.VerdeModernoStart
import com.aarondevs.binareus.ui.theme.PrimaryText
import com.aarondevs.binareus.ui.theme.SecondaryText
import com.aarondevs.cafeterialpd.presentation.component.AsciiText
import com.aarondevs.cafeterialpd.presentation.component.Button
import com.aarondevs.cafeterialpd.presentation.component.Input
import org.jetbrains.compose.resources.painterResource

@Composable
fun LoginScreen(
    onIniciarSesionAdministrador: () -> Unit = {},
    onIniciarSesionCajero: () -> Unit = {},
    onIniciarSesionPantalla: () -> Unit = {}
) {
    LoginScreenBody(
        onIniciarSesionAdministrador = onIniciarSesionAdministrador,
        onIniciarSesionCajero = onIniciarSesionCajero,
        onIniciarSesionPantalla = onIniciarSesionPantalla,
    )
}

@Composable
fun LoginScreenBody(
    onIniciarSesionAdministrador: () -> Unit = {},
    onIniciarSesionCajero: () -> Unit = {},
    onIniciarSesionPantalla: () -> Unit = {}
) {

    val scrollState = rememberScrollState()
    var tipoLogin by remember { mutableStateOf("usuario") }

    var correo by remember { mutableStateOf("") }
    var contrasena by remember { mutableStateOf("") }
    var codigoAcceso by remember { mutableStateOf("") }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(BackgroundMain)
        )

        Image(
            painter = painterResource(resource = Res.drawable.bg_principal),
            contentDescription = null,
            modifier = Modifier.matchParentSize(),
            contentScale = ContentScale.Crop
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(64.dp))

            Image(
                painter = painterResource(resource = Res.drawable.logocafeterialpd),
                contentDescription = "Logo",
                modifier = Modifier
                    .fillMaxWidth(0.60f)
                    .padding(bottom = 24.dp)
            )

            AsciiText(
                texto = "LOGIN",
                spacing = 8.dp,
                background = Color.Transparent,
                alignment = "central",
                modifier = Modifier.fillMaxWidth(),
                fontSizeReduce = 0.5.sp
            )

            Spacer(modifier = Modifier.height(16.dp))

            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {

                if (tipoLogin == "usuario") {

                    Input(
                        value = correo,
                        onValueChange = { correo = it },
                        label = "Correo electrónico",
                        borderRadius = 10,
                        borderSize = 2,
                        borderColor = Brush.horizontalGradient(
                            listOf(VerdeModernoStart, VerdeModernoEnd)
                        ),
                        textSize = 14,
                        verticalPadding = 16,
                        type = "Text",
                        isPassword = false,
                        isDisabled = false
                    )

                    Input(
                        value = contrasena,
                        onValueChange = { contrasena = it },
                        label = "Contraseña",
                        borderRadius = 10,
                        borderColor = Brush.horizontalGradient(
                            listOf(VerdeModernoEnd, VerdeModernoStart)
                        ),
                        borderSize = 2,
                        textSize = 14,
                        verticalPadding = 16,
                        type = "Text",
                        isPassword = true,
                        isDisabled = false
                    )

                    Text(
                        text = "Acceder por pantalla",
                        style = TextStyle(
                            brush = Brush.horizontalGradient(listOf(VerdeModernoStart, VerdeModernoEnd)),
                            fontSize = 13.sp
                        ),
                        modifier = Modifier
                            .align(Alignment.End)
                            .clickable {
                                tipoLogin = "pantalla"
                            }
                    )

                } else {

                    Input(
                        value = codigoAcceso,
                        onValueChange = { codigoAcceso = it },
                        label = "Código de Acceso",
                        borderRadius = 10,
                        borderSize = 2,
                        borderColor = Brush.horizontalGradient(
                            listOf(VerdeModernoStart, VerdeModernoEnd)
                        ),
                        textSize = 14,
                        verticalPadding = 16,
                        type = "Text",
                        isPassword = false,
                        isDisabled = false
                    )

                    Text(
                        text = "Acceder como usuario",
                        style = TextStyle(
                            brush = Brush.horizontalGradient(listOf(VerdeModernoStart, VerdeModernoEnd)),
                            fontSize = 13.sp
                        ),
                        modifier = Modifier
                            .align(Alignment.End)
                            .clickable {
                                tipoLogin = "usuario"
                            }
                    )
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            Button(
                text = "Iniciar Sesión",
                onClick = {
                    if (tipoLogin == "usuario") {
                        onIniciarSesionAdministrador()
                    } else {
                        onIniciarSesionPantalla()
                    }
                },
                borderRadius = 16,
                borderSize = 2,
                borderColor = Brush.horizontalGradient(listOf(PrimaryText, SecondaryText)),
                textSize = 16
            )

            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}


@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}