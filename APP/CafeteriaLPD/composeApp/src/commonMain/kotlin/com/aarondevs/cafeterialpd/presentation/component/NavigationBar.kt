package com.aarondevs.cafeterialpd.presentation.component

import androidx.compose.animation.*
import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafeterialaparada.composeapp.generated.resources.Res
import cafeterialaparada.composeapp.generated.resources.*
import com.aarondevs.binareus.ui.theme.VerdeModernoEnd
import com.aarondevs.binareus.ui.theme.VerdeModernoStart
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource

data class NavItem(
    val name: String,
    val iconRes: DrawableResource,
    val onClick: () -> Unit = {}
)

@Composable
fun NavigationBar(
    items: List<NavItem>,
    centerItem: NavItem,
    initialSelectedItem: String = items.firstOrNull()?.name ?: "",
    onItemSelected: (String) -> Unit = {}
) {
    var selectedItem by remember { mutableStateOf(initialSelectedItem) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(90.dp),
        contentAlignment = Alignment.BottomCenter
    ) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(65.dp)
                .padding(16.dp, bottom = 3.dp)
                .background(Color.Transparent, shape = RoundedCornerShape(35.dp))
                .border(
                    2.dp,
                    Brush.horizontalGradient(listOf(VerdeModernoStart, VerdeModernoEnd)),
                    RoundedCornerShape(50.dp)
                )
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceAround,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxSize()
            ) {

                items.take(items.size / 2).forEach { item ->
                    NavBarItem(
                        name = item.name,
                        iconRes = item.iconRes,
                        isSelected = selectedItem == item.name,
                        onClick = {
                            selectedItem = item.name
                            onItemSelected(item.name)
                            item.onClick()
                        }
                    )
                }

                Spacer(modifier = Modifier.width(56.dp))

                items.drop(items.size / 2).forEach { item ->
                    NavBarItem(
                        name = item.name,
                        iconRes = item.iconRes,
                        isSelected = selectedItem == item.name,
                        onClick = {
                            selectedItem = item.name
                            onItemSelected(item.name)
                            item.onClick()
                        }
                    )
                }
            }
        }

        CenterGlowItem(
            item = centerItem,
            isSelected = selectedItem == centerItem.name,
            onClick = {
                selectedItem = centerItem.name
                onItemSelected(centerItem.name)
                centerItem.onClick()
            }
        )
    }
}

@Composable
fun NavBarItem(
    name: String,
    iconRes: DrawableResource,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(vertical = 10.dp)
            .clickable { onClick() }
    ) {
        Icon(
            painter = painterResource(resource = iconRes),
            contentDescription = name,
            modifier = Modifier.size(24.dp),
            tint = Color.White
        )

        AnimatedVisibility(
            visible = isSelected,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            Text(
                text = name,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }
    }
}


@Composable
fun CenterGlowItem(
    item: NavItem,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    val infiniteTransition = rememberInfiniteTransition()

    val glowAlpha by infiniteTransition.animateFloat(
        initialValue = 0.35f,
        targetValue = 0.7f,
        animationSpec = infiniteRepeatable(
            animation = tween(1800, easing = EaseInOut),
            repeatMode = RepeatMode.Reverse
        )
    )

    val rotation by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(8000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )

    val waveRotation by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(7000, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )

    val offsetY by animateDpAsState(
        targetValue = if (isSelected) (-12).dp else (-2).dp,
        animationSpec = tween(300)
    )

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.offset(y = offsetY)
    ) {

        Box(
            modifier = Modifier.size(64.dp),
            contentAlignment = Alignment.Center
        ) {

            Box(
                modifier = Modifier
                    .size(64.dp)
                    .graphicsLayer {
                        rotationZ = rotation
                    }
                    .background(
                        brush = Brush.sweepGradient(
                            colors = listOf(
                                Color.Transparent,
                                VerdeModernoStart.copy(alpha = glowAlpha),
                                VerdeModernoEnd.copy(alpha = glowAlpha),
                                Color.Transparent
                            )
                        ),
                        shape = CircleShape
                    )
                    .blur(16.dp)
            )

            Box(
                modifier = Modifier
                    .size(50.dp)
                    .graphicsLayer {
                        rotationZ = waveRotation
                    }
                    .background(
                        brush = Brush.sweepGradient(
                            listOf(
                                VerdeModernoStart,
                                VerdeModernoEnd,
                                VerdeModernoStart
                            )
                        ),
                        shape = CircleShape
                    )
                    .border(
                        1.5.dp,
                        Color.White.copy(alpha = 0.8f),
                        CircleShape
                    )
                    .clickable { onClick() },
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    painter = painterResource(resource = item.iconRes),
                    contentDescription = item.name,
                    tint = Color.White,
                    modifier = Modifier
                        .size(24.dp)
                        .graphicsLayer {
                            rotationZ = -waveRotation
                        }
                )
            }
        }

        AnimatedVisibility(
            visible = isSelected,
            enter = fadeIn(),
            exit = fadeOut()
        ) {
            Text(
                text = item.name,
                fontSize = 11.sp,
                fontWeight = FontWeight.Medium,
                color = Color.White,
                modifier = Modifier.padding(top = 3.dp)
            )
        }
    }
}



@Preview
@Composable
fun NavigationBarPreview() {
    NavigationBar(
        items = listOf(
            NavItem("Inicio", Res.drawable.ico_home),
            NavItem("Perfil", Res.drawable.ico_profile)
        ),
        centerItem = NavItem("Ventas", Res.drawable.ico_shop_car),
        initialSelectedItem = "Inicio"
    )
}