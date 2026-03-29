package com.aarondevs.cafeterialpd.presentation.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aarondevs.binareus.ui.theme.SecondaryText

@Composable
fun TextArea(
    value: String,
    onValueChange: (String) -> Unit,
    label: String,
    borderRadius: Int,
    borderColor: Brush,
    borderSize: Int,
    textSize: Int = 16,
    horizontalPadding: Int = 16,
    verticalPadding: Int = 30,
    minHeight: Int = 110,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 5.dp)
            .border(
                BorderStroke(borderSize.dp, borderColor),
                shape = RoundedCornerShape(borderRadius.dp)
            )
    ) {
        BasicTextField(
            value = value,
            onValueChange = onValueChange,
            textStyle = TextStyle(
                color = SecondaryText,
                fontSize = textSize.sp
            ),
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = minHeight.dp)
                .padding(
                    horizontal = horizontalPadding.dp,
                    vertical = verticalPadding.dp
                )
        )

        AnimatedVisibility(
            visible = value.isEmpty(),
            enter = fadeIn(),
            exit = fadeOut(),
            modifier = Modifier.offset(x = horizontalPadding.dp, y = (verticalPadding / 2).dp)
        ) {
            Text(
                text = label,
                color = Color.Gray,
                fontSize = textSize.sp
            )
        }
    }
}
