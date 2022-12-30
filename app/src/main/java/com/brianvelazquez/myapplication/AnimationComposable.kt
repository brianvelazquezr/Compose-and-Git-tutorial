package com.brianvelazquez.myapplication

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun AnimationColor() {

    var clicked by rememberSaveable { mutableStateOf(false) }

    val finalColor by animateColorAsState(
        targetValue = if (clicked) Color.Green else Color.Yellow,
        animationSpec = tween(durationMillis = 2000)
    )

    Box(
        Modifier
            .size(100.dp)
            .background(finalColor)
            .clickable { clicked = !clicked }
    )
}

@Composable
fun AnimationSize() {
    var clicked by rememberSaveable { mutableStateOf(false) }

    val finalSize by animateDpAsState(
        targetValue = if (clicked) 50.dp else 100.dp,
        animationSpec = tween(durationMillis = 200)
    )

    Box(
        Modifier
            .size(finalSize)
            .background(Color.Green)
            .clickable { clicked = !clicked }
    )
}

@Composable
fun VisibilityAnimation() {
    var showBox by remember { mutableStateOf(true) }

    Column(Modifier.fillMaxSize()) {

        Button(onClick = { showBox = !showBox }) {
            Text(text = "Mostrar/Ocultar")
        }

        Spacer(modifier = Modifier.size(60.dp))

        AnimatedVisibility(
            visible = showBox,
            enter = slideInHorizontally(),
            exit = slideOutHorizontally()
        ) {
            Box(
                Modifier
                    .size(100.dp)
                    .background(Color.Green)

            )
        }

    }

}

@Composable
fun CrossfadeExample(){

}