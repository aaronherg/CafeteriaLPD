package com.aarondevs.cafeterialpd.presentation.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafeterialaparada.composeapp.generated.resources.Res
import cafeterialaparada.composeapp.generated.resources.*
import org.jetbrains.compose.resources.painterResource


@Composable
fun Select(
    selectedOption: String,
    onOptionChange: (String) -> Unit,
    titulo: String,
    options: List<Pair<String, String>>,
    borderRadius: Int,
    borderColor: Brush,
    textSize: Int,
    iconSize: Int,
    verticalPadding: Int,
    modifier: Modifier,
    isDisabled: Boolean = false
) {
    val expanded = remember { mutableStateOf(false) }

    Box(
        modifier = modifier
            .fillMaxWidth()
            .border(
                BorderStroke(2.dp, borderColor),
                shape = RoundedCornerShape(borderRadius.dp)
            )
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable(enabled = !isDisabled) {
                    expanded.value = !expanded.value
                }
                .padding(horizontal = 16.dp, vertical = verticalPadding.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = options.find { it.first == selectedOption }?.second ?: titulo,
                style = TextStyle(
                    color = if (isDisabled) Color.Gray else Color.Gray,
                    fontSize = textSize.sp
                ),
                modifier = Modifier.weight(1f)
            )

            if (isDisabled) {
                Image(
                    painter = painterResource(Res.drawable.ico_lock),
                    contentDescription = "Bloqueado",
                    modifier = Modifier.size(iconSize.dp)
                )
            } else {
                Image(
                    painter = painterResource(Res.drawable.ico_dropdownarrow),
                    contentDescription = "Dropdown Arrow",
                    modifier = Modifier.size(iconSize.dp)
                )
            }
        }

        DropdownMenu(
            expanded = expanded.value && !isDisabled,
            onDismissRequest = { expanded.value = false },
            modifier = Modifier
                .width(265.dp)
                .border(
                    BorderStroke(2.dp, borderColor),
                    shape = RoundedCornerShape(borderRadius.dp)
                )
                .align(Alignment.TopStart)
        ) {
            options.forEach { (value, text) ->
                DropdownMenuItem(
                    onClick = {
                        onOptionChange(value)
                        expanded.value = false
                    },
                    text = { Text(text = text) }
                )
            }
        }
    }
}


