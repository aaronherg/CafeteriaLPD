package com.aarondevs.cafeterialpd.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.SubcomposeLayout
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlin.random.Random

fun letra(caracter: Char): String {
    return when (caracter.uppercaseChar()) {
        'A' -> """
╔█████═╗
██    ██║
██    ██║
██    ██║
████████║
██╔═══██╗
██║   ██║
╚═╝   ╚═╝
        """.trimIndent()
        'B' -> """
██████╗
██╔══██╗
██║  ██╗
██████╔╝
██╔══██╗
██║  ██║
██████╔╝
╚═════╝
        """.trimIndent()
        'C' -> """
 ██████╗ 
██╔════╝
██║
██║
██║
██║
╚██████╗
 ╚═════╝
        """.trimIndent()
        'D' -> """
███████╗  
██╔════██╗ 
██║    ██║ 
██║    ██║ 
██║    ██║ 
██╔════██╗ 
████████╔╝ 
╚═══════╝  
        """.trimIndent()
        'E' -> """
███████╗ 
██╔════╝
██║     
█████╗   
██╔══╝   
██║      
███████╗ 
╚══════╝     
        """.trimIndent()
        'F' -> """
████████╗
██╔═════╝ 
█████╗   
██╔══╝   
██║      
██║      
██║      
╚═╝      
        """.trimIndent()
        'G' -> """
 ███████╗
██╔════╝ 
██║      
██║  ███╗
██║   ██║
██║   ██║
╚██████╔╝
 ╚═════╝ 
        """.trimIndent()
        'H' -> """
██╗  ██╗
██║  ██║
██║  ██║
███████║
██╔══██║
██║  ██║
██║  ██║
╚═╝  ╚═╝
        """.trimIndent()
        'I' -> """
██████████╗
    ██╔═══╝
    ██║    
    ██║    
    ██║    
    ██╚═══╗
██████████║
╚═════════╝
        """.trimIndent()
        'J' -> """
.    ██╗
     ██║
     ██║
     ██║
██   ██║
██   ██║
 ██████║
  ╚════╝
        """.trimIndent()
        'K' -> """
██╗  ██╗ 
██║ ██╔╝ 
██║██╔╝  
████╔╝   
██║██╗   
██║ ╚██╗ 
██║  ╚██╗
╚═╝   ╚═╝
        """.trimIndent()
        'L' -> """
██╗     
██║     
██║     
██║     
██║     
██║     
███████╗
╚══════╝
        """.trimIndent()
        'M' -> """
███╗   ███╗
████╗ ████║
██╔████╔██║
██║╚██╔╝██║
██║ ╚═╝ ██║
██║     ██║
██║     ██║
╚═╝     ╚═╝
        """.trimIndent()
        'N' -> """
███╗   ██╗
████╗  ██║
██╔██╗ ██║
██╔██╗ ██║
██║╚██╗██║
██║ ╚████║
██║  ╚███║
╚═╝   ╚══╝
        """.trimIndent()
        'O' -> """
 ██████╗ 
██╔═══██╗
██║   ██║
██║   ██║
██║   ██║
██║   ██║
╚██████╔╝
 ╚═════╝ 
        """.trimIndent()
        'P' -> """
███████╗
██╔══██╗
██████╔╝
██╔═══╝ 
██║     
██║     
██║     
╚═╝     
        """.trimIndent()
        'Q' -> """
 ██████╗   
██╔═══██╗  
██║   ██║  
██║   ██║  
██║    █║  
╚████████═╗
 ╚══════▀▀╝
        """.trimIndent()
        'R' -> """
███████╗
██   ██╗
██   ██╗
██████╔╝
██╔═══╝ 
██║  ██╗
██║  ██║
╚═╝  ╚═╝
        """.trimIndent()
        'S' -> """
█████████╗ 
██╔══════╝ 
  ╚╗       
   ╚██████╗
        ██╗
        ██╗
████████╔╝ 
╚═══════╝  
        """.trimIndent()
        'T' -> """
████████╗
╚══██╔══╝
   ██║   
   ██║   
   ██║   
   ██║   
   ██║   
   ╚═╝   
        """.trimIndent()
        'U' -> """
██╗   ██╗
██║   ██║
██║   ██║
██║   ██║
██║   ██║
██║   ██║
╚██████╔╝
 ╚═════╝ 
        """.trimIndent()
        'V' -> """
██╗   ██╗
██║   ██║
██║   ██║
██║   ██║
██║   ██║
╚██╗ ██╔╝
 ╚████╔╝ 
  ╚═══╝   
        """.trimIndent()
        'W' -> """
██╗    ██╗
██║    ██║
██║    ██║
██║    ██║
██║ ██╗██║
██║███╗██║
╚███╔███╔╝
 ╚══╝╚══╝   
        """.trimIndent()
        'X' -> """
██╗  ██╗ 
╚██╗██╔╝ 
 ╚███╔╝  
  ╚██╔╝  
  ║██║   
  ███║   
 ██╔██╗  
██╔╝ ╚██╗
╚═╝   ╚═╝
        """.trimIndent()
        'Y' -> """
██╗   ██╗
╚██╗ ██╔╝
╚██╗ ██╔╝
 ╚████╔╝ 
  ╚██╔╝  
   ██║   
   ██║   
   ╚═╝   
        """.trimIndent()
        'Z' -> """
█████████╗
╚═════██╔╝
    ██╔╝  
   ██╔╝   
  ██╔╝    
 ██╔╝     
██╔════╗   
████████╗   
        """.trimIndent()
        '&' -> """
 ██████╗     
██╔═══██╗    
╚═╝   ██║    
 ██████╔╝    
██╔═══██╗    
██║  ██║██╗  
╚██████╔╝╚═╝ 
 ╚═════╝     
        """.trimIndent()

        '0' -> """
 ██████╗ 
██╔═══██╗
██║   ██║
██║   ██║
██║   ██║
██║   ██║
╚██████╔╝
 ╚═════╝ 
        """.trimIndent()
            '1' -> """
   ██╗   
  ███║   
   ██║   
   ██║   
   ██║   
   ██║   
████████╗
╚═══════╝
        """.trimIndent()

        '2' -> """
███████╗
╚════██║
    ██╔╝
   ██╔╝ 
  ██╔╝  
 ██╔╝   
████████╗
╚═══════╝
        """.trimIndent()

        '3' -> """
███████╗
╚════██║
    ██╔╝
  █████╗
      ██║
      ██║
███████╔╝
╚══════╝
        """.trimIndent()

        '4' -> """
██╗  ██╗
██║  ██║
██║  ██║
████████║
╚════██║
     ██║
     ╚═╝
        
        """.trimIndent()

        '5' -> """
████████╗
██╔════╝
██║     
███████╗
      ██║
      ██║
███████╔╝
╚══════╝
        """.trimIndent()

        '6' -> """
 ██████╗ 
██╔════╝
██║     
███████╗
██╔═══██║
██║   ██║
╚██████╔╝
 ╚═════╝
        """.trimIndent()

        '7' -> """
████████╗
╚════██╔╝
    ██╔╝ 
   ██╔╝  
  ██╔╝   
 ██╔╝    
██╔╝     
╚═╝      
        """.trimIndent()

        '8' -> """
 ██████╗ 
██╔═══██╗
██╔═══██║
╚██████╔╝
██╔═══██║
██║   ██║
╚██████╔╝
 ╚═════╝
        """.trimIndent()

        '9' -> """
 ██████╗ 
██╔═══██╗
██║   ██║
╚███████║
      ██║
██╗   ██║
╚██████╔╝
 ╚═════╝
        """.trimIndent()
        else -> caracter.toString()
    }
}

fun getRandomColor(): String {
    val colors = listOf(
        "#FF6B6B", "#FFD93D", "#6BCB77", "#4D96FF",
        "#FF9CEE", "#FFB26B", "#A66BFF", "#6FFFE9",
        "#FFC6FF", "#5C7AEA"
    )
    return colors.random()
}

fun hexToColor(hex: String): Color {
    val cleanHex = hex.removePrefix("#")
    val colorLong = cleanHex.toLong(16)
    return when (cleanHex.length) {
        6 -> Color(
            red = ((colorLong shr 16) and 0xFF) / 255f,
            green = ((colorLong shr 8) and 0xFF) / 255f,
            blue = (colorLong and 0xFF) / 255f,
            alpha = 1f
        )
        8 -> Color(
            red = ((colorLong shr 16) and 0xFF) / 255f,
            green = ((colorLong shr 8) and 0xFF) / 255f,
            blue = (colorLong and 0xFF) / 255f,
            alpha = ((colorLong shr 24) and 0xFF) / 255f
        )
        else -> Color.White
    }
}

@Composable
fun AsciiText(
    texto: String,
    spacing: Dp = 4.dp,
    background: Color = Color.Transparent,
    alignment: String = "central",
    modifier: Modifier = Modifier,
    padding: Dp = 10.dp,
    fontSizeReduce: TextUnit = 0.sp,
    minFontSize: TextUnit = 2.sp,
    maxFontSize: TextUnit = 40.sp
) {
    BoxWithConstraints(
        modifier = modifier
            .fillMaxWidth()
            .background(background)
            .padding(padding)
            .clipToBounds()
    ) {
        val density = LocalDensity.current
        val asciiMatrix = remember(texto) {
            texto.map { letra(it).trim().lines() }
        }
        val maxRows = asciiMatrix.maxOfOrNull { it.size } ?: 1
        val totalColumns = asciiMatrix.sumOf { it.maxOfOrNull { it.length } ?: 0 }

        if (totalColumns == 0 || maxRows == 0) return@BoxWithConstraints

        val spacingPx = with(density) { spacing.toPx() * (texto.length - 1) }
        val availableWidthPx = constraints.maxWidth.toFloat() - spacingPx
        val availableHeightPx = constraints.maxHeight.toFloat().takeIf { it > 0 } ?: Float.MAX_VALUE

        // SubcomposeLayout para medir y ajustar fontSize
        SubcomposeLayout { constraints ->
            var fontSizeSp = maxFontSize

            // Función para medir tamaño aproximado del ASCII con un fontSize dado
            fun measureAscii(fontSize: TextUnit): Pair<Float, Float> {
                val pxSize = with(density) { fontSize.toPx() }
                val width = totalColumns * pxSize
                val height = maxRows * pxSize
                return width to height
            }

            // Reducir fontSize hasta que quepa en ancho y alto
            while (true) {
                val (w, h) = measureAscii(fontSizeSp)
                if (w <= availableWidthPx && h <= availableHeightPx) break
                fontSizeSp = (fontSizeSp.value - 1).coerceAtLeast(minFontSize.value).sp
                if (fontSizeSp.value <= minFontSize.value) break
            }

            // Aplicar fontSizeReduce
            fontSizeSp = (fontSizeSp.value - fontSizeReduce.value).coerceAtLeast(minFontSize.value).sp

            val placeables = subcompose("ascii") {
                AsciiTextInternal(
                    texto = texto,
                    fontSize = fontSizeSp,
                    spacing = spacing,
                    alignment = alignment,
                    modifier = Modifier.fillMaxWidth()
                )
            }.map { it.measure(constraints) }

            val layoutWidth = placeables.maxOfOrNull { it.width } ?: constraints.minWidth
            val layoutHeight = placeables.maxOfOrNull { it.height } ?: constraints.minHeight

            layout(layoutWidth, layoutHeight) {
                placeables.forEach { it.place(0, 0) }
            }
        }
    }
}



@Composable
private fun AsciiTextInternal(
    texto: String,
    fontSize: TextUnit,
    spacing: Dp,
    alignment: String,
    modifier: Modifier = Modifier
) {
    val letras = texto.map { letra(it).trim().lines() }
    val maxFilas = letras.maxOf { it.size }

    val letrasNormalizadas = letras.map { lineas ->
        lineas + List(maxFilas - lineas.size) { "" }
    }

    val colores = letrasNormalizadas.map { hexToColor(getRandomColor()) }

    Row(
        modifier = modifier,
        horizontalArrangement = when (alignment.lowercase()) {
            "izquierda" -> Arrangement.Start
            "derecha" -> Arrangement.End
            else -> Arrangement.Center
        }
    ) {
        letrasNormalizadas.forEachIndexed { index, letraLineas ->
            Column(modifier = Modifier.padding(end = spacing)) {
                letraLineas.forEach { linea ->
                    Text(
                        text = linea,
                        fontFamily = FontFamily.Monospace,
                        fontSize = fontSize,
                        color = colores[index],
                        softWrap = false,
                        maxLines = 1
                    )
                }
            }
        }
    }
}
