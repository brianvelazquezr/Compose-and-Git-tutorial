package com.brianvelazquez.myapplication

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.brianvelazquez.myapplication.model.Routes

@Composable
fun Screen1(navController: NavHostController) {
    Box(
        Modifier
            .fillMaxSize()
            .background(Color.Gray)
    ) {
        Text(
            text = "Pantalla 1 ",
            modifier = Modifier
                .align(Alignment.Center)
                .clickable { navController.navigate(Routes.Screen2.route) })
    }
}

@Composable
fun Screen2(navController: NavHostController) {
    Box(
        Modifier
            .fillMaxSize()
            .background(Color.DarkGray)
    ) {
        Text(
            text = "Pantalla 2 ",
            modifier = Modifier
                .align(Alignment.Center)
                .clickable { navController.navigate(Routes.Screen3.route) })
    }
}

@Composable
fun Screen3(navController: NavHostController) {
    Box(
        Modifier
            .fillMaxSize()
            .background(Color.LightGray)
    ) {
        Text(
            text = "Pantalla 3 ",
            modifier = Modifier
            .align(Alignment.Center)
            .clickable {navController.navigate(Routes.Screen4.createRoute(25))})
    }
}

@Composable
fun Screen4(navController: NavHostController, num: Int) {
    Box(
        Modifier
            .fillMaxSize()
            .background(Color.Yellow)
    ) {
        Text(
            text = " Pasamos $num como argumento",
            modifier = Modifier
                .align(Alignment.Center)
                .clickable { navController.navigate("screen5") })
    }
}

@Composable
fun Screen5(navController: NavHostController, string: String?) {
    Box(
        Modifier
            .fillMaxSize()
            .background(Color.Yellow)
    ) {
        Text(
            text = " Pasamos $string como argumento y puede ser null",
            modifier = Modifier
                .align(Alignment.Center))
    }
}