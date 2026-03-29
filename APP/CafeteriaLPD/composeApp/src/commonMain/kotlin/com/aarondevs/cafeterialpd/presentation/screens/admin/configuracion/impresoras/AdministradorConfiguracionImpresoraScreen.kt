package com.aarondevs.cafeterialpd.presentation.screens.admin.configuracion.impresoras

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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
import cafeterialaparada.composeapp.generated.resources.ico_informacion
import com.aarondevs.binareus.ui.theme.VerdeModernoEnd
import com.aarondevs.binareus.ui.theme.VerdeModernoStart
import com.aarondevs.cafeterialpd.presentation.component.Input
import com.aarondevs.cafeterialpd.presentation.component.PrinterBluetooh
import com.aarondevs.cafeterialpd.presentation.component.PrinterDevice
import com.aarondevs.cafeterialpd.presentation.component.TextArea
import org.jetbrains.compose.resources.painterResource

@Composable
fun AdministradorConfiguracionImpresoraScreen(
    onRetroceder: () -> Unit = {},
    onInformacion: () -> Unit = {}
) {
    AdministradorConfiguracionImpresoraScreenBody(
        onRetroceder = onRetroceder,
        onInformacion = onInformacion
    )
}

@Composable
fun AdministradorConfiguracionImpresoraScreenBody(
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
                            text = "Configuración de Impresora",
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
                    text = "Configure la impresora de trabajo.",
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
                        AdministradorConfiguracionImpresoraContenidoScreen()
                    }
                }
            }
        }
    }

}

@Composable
fun AdministradorConfiguracionImpresoraContenidoScreen(){

    Box(modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 20.dp, vertical = 10.dp)
        ) {

            var selectedPrinterId by remember { mutableStateOf<String?>(null) }

            val printers = listOf(
                PrinterDevice("1", "Printer POS-58", "Disponible"),
                PrinterDevice("2", "Printer Epson T20", "Disponible"),
                PrinterDevice("3", "Printer OfficeJet", "Desconectada"),
                PrinterDevice("4", "Printer Thermal X", "Desconectada")
            )

            Spacer(modifier = Modifier.height(16.dp))

            PrinterBluetooh(
                printers = printers,
                selectedId = selectedPrinterId,
                onSelected = { printer ->
                    selectedPrinterId = printer.id
                }
            )
        }
    }

}


@Preview
@Composable
fun AdministradorConfiguracionImpresoraScreenPreview() {
    AdministradorConfiguracionImpresoraScreen()
}