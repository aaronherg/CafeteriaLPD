package com.aarondevs.cafeterialpd.presentation.screens.admin.configuracion.usuarios

import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
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
import androidx.compose.ui.draw.alpha
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafeterialaparada.composeapp.generated.resources.*
import com.aarondevs.binareus.ui.theme.VerdeModernoEnd
import com.aarondevs.binareus.ui.theme.VerdeModernoStart
import com.aarondevs.cafeterialpd.librery.AnimProfundidad
import com.aarondevs.cafeterialpd.presentation.component.FloatingButton
import com.aarondevs.cafeterialpd.presentation.component.Select
import org.jetbrains.compose.resources.painterResource

@Composable
fun AdministradorConfiguracionUsuarioScreen(
    onRetroceder: () -> Unit = {},
    onInformacion: () -> Unit = {},
    onNuevoUsuario: () -> Unit = {},
    onEditarUsuario: () -> Unit = {},
) {
    AdministradorConfiguracionUsuarioScreenBody(
        onRetroceder = onRetroceder,
        onInformacion = onInformacion,
        onNuevoUsuario = onNuevoUsuario,
        onEditarUsuario = onEditarUsuario
    )
}

@Composable
fun AdministradorConfiguracionUsuarioScreenBody(
    onRetroceder: () -> Unit = {},
    onInformacion: () -> Unit = {},
    onNuevoUsuario: () -> Unit = {},
    onEditarUsuario: () -> Unit = {},
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
                            text = "Configuración de Usuarios",
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
                    text = "Configure los usuarios de la empresa.",
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
                        AdministradorConfiguracionUsuarioContenidoScreen(
                            onNuevoUsuario = onNuevoUsuario,
                            onEditarUsuario = onEditarUsuario
                        )
                    }
                }
            }
        }
    }

}



data class UsuarioUI(
    val nombre: String,
    val apellido: String,
    val rol: String,
    val correo: String,
    val sexo: String
)

@Composable
fun UsuarioCard(
    usuario: UsuarioUI,
    onNuevoUsuario: () -> Unit = {},
    onEditarUsuario: () -> Unit = {},
    onEliminarUsuario: () -> Unit = {},
    modifier: Modifier = Modifier
) {

    val borderColor = Color.Black.copy(alpha = 0.06f)
    val density = LocalDensity.current
    val textMeasurer = rememberTextMeasurer()

    val textLayout = textMeasurer.measure(
        text = AnnotatedString(usuario.rol),
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
        if (height < 90.dp) 110.dp else if (height > 150.dp) 150.dp else height
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
                        color = Color(0xFF2A2A2A),
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
                    text = usuario.rol,
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
                                painter = painterResource(if(usuario.sexo == "Masculino") Res.drawable.ico_chico else Res.drawable.ico_chica),
                                contentDescription = "Perfil",
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
                            horizontalAlignment = Alignment.Start,
                            verticalArrangement = Arrangement.Center
                        ) {

                            @Composable
                            fun label(title: String, value: String) {
                                Column {
                                    Text(title.uppercase(), fontSize = 7.sp, color = Color.Gray)
                                    Text(value, fontSize = 9.sp, fontWeight = FontWeight.Medium)
                                }
                            }

                            Text(
                                text = "DATOS DEL USUARIO",
                                fontSize = 8.sp,
                                fontWeight = FontWeight.Bold
                            )

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                label("Nombre", usuario.nombre)
                                label("Apellido", usuario.apellido)
                            }

                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                label("Rol", usuario.rol)
                                label("Sexo", usuario.sexo)
                            }

                            label("Correo", usuario.correo)
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
                        .clickable { onEditarUsuario() }
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
                    Text("Editar", color = Color.White, fontSize = 10.sp)
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
                        .clickable {
                            onEliminarUsuario()
                        }
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
                    Text("Eliminar", color = Color.White, fontSize = 10.sp)
                }
            }
        }
    }
}

@Composable
fun AdministradorConfiguracionUsuarioContenidoScreen(
    onNuevoUsuario: () -> Unit = {},
    onEditarUsuario: () -> Unit = {},
) {

    val busqueda = ""
    var rol by remember { mutableStateOf("") }

    var usuarios by remember {
        mutableStateOf(
            listOf(
                UsuarioUI("Juan", "Perez", "Administrador", "juan.perez@mail.com", "Masculino"),
                UsuarioUI("Maria", "Lopez", "Cajero", "maria.lopez@mail.com", "Femenino"),
                UsuarioUI("Carlos", "Santos", "Cajero", "carlos.santos@mail.com", "Masculino"),
                UsuarioUI("Ana", "Martinez", "Administrador", "ana.martinez@mail.com", "Femenino")
            )
        )
    }


    Box(modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 20.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(horizontal = 20.dp)
            ) {

                Column(modifier = Modifier.fillMaxWidth(0.6f)) {
                    Select(
                        selectedOption = rol,
                        onOptionChange = { rol = it },
                        titulo = "Rol",
                        options = listOf(
                            "Administrador" to "Administrador",
                            "Cajero" to "Cajero",
                        ),
                        borderRadius = 25,
                        borderColor = Brush.horizontalGradient(
                            listOf(VerdeModernoEnd, VerdeModernoStart)
                        ),
                        textSize = 13,
                        iconSize = 20,
                        verticalPadding = 10,
                        modifier = Modifier
                    )
                }

                Spacer(Modifier.height(6.dp))

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
                        value = "",
                        onValueChange = {},
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
            }

            Spacer(Modifier.height(12.dp))

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 8.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                usuarios.forEach { usuario ->
                    item {
                        key(usuario.correo) {

                            var animar by remember { mutableStateOf(false) }

                            AnimProfundidad(
                                animar = animar,
                                duracionMs = 300,
                                onFin = {
                                    usuarios = usuarios - usuario
                                }
                            ) { modifier ->

                                UsuarioCard(
                                    usuario = usuario,
                                    modifier = modifier,
                                    onEditarUsuario = { onEditarUsuario() },
                                    onNuevoUsuario = { onNuevoUsuario() },
                                    onEliminarUsuario = {
                                        animar = true
                                    }
                                )
                            }
                        }
                    }
                }
            }
        }

        FloatingButton(
            icon = Res.drawable.ico_plus,
            label = "Nuevo",
            size = 48,
            iconSize = 24,
            borderColor = Brush.horizontalGradient(
                listOf(Color(0xFFA5D6A7), Color(0xFF66BB6A))
            ),
            onClick = {

            },
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(16.dp)
                .padding(bottom = 20.dp)
        )
    }
}


@Preview
@Composable
fun AdministradorConfiguracionUsuarioScreenPreview() {
    AdministradorConfiguracionUsuarioScreen()
}