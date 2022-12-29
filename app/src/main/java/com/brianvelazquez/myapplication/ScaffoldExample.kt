package com.brianvelazquez.myapplication

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Gray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.graphics.Color.Companion.Yellow
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@ExperimentalFoundationApi
@Composable
fun ScaffoldExample() {
    val scaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            MyTopAppBar(onClickIcon = {
                coroutineScope.launch {
                    scaffoldState.snackbarHostState.showSnackbar(
                        "Has pulsado $it"
                    )
                }
            }, onClicDrawer = { coroutineScope.launch { scaffoldState.drawerState.open() } })
        },
        scaffoldState = scaffoldState,
        bottomBar = { MyBottomNavigation() },
        floatingActionButton = { MyFAB() },
        floatingActionButtonPosition = FabPosition.Center,
        isFloatingActionButtonDocked = false,
        drawerContent = { MyDrawer() {coroutineScope.launch { scaffoldState.drawerState.close() }} },
        drawerGesturesEnabled = false
    ) {
        SuperHeroRecyclerView()
    }
}

@Composable
fun MyDrawer(onClicOption:() -> Unit) {
    Column(Modifier.padding(8.dp)) {
        Text(
            text = "Primera opción", modifier = Modifier
                .padding(vertical = 8.dp)
                .fillMaxWidth()
                .clickable { onClicOption() }
        )
        Text(
            text = "Segunda opción", modifier = Modifier
                .padding(vertical = 8.dp)
                .fillMaxWidth()
                .clickable { onClicOption() }
        )
        Text(
            text = "Tercera opción", modifier = Modifier
                .padding(vertical = 8.dp)
                .fillMaxWidth()
                .clickable { onClicOption() }
        )
        Text(
            text = "Cuarta opción", modifier = Modifier
                .padding(vertical = 8.dp)
                .fillMaxWidth()
                .clickable { onClicOption() }
        )
    }
}

@Composable
fun MyFAB() {
    FloatingActionButton(onClick = { }, backgroundColor = Yellow, contentColor = Black) {
        Icon(imageVector = Icons.Default.Add, contentDescription = "Add")
    }
}

@Composable
fun MyBottomNavigation() {
    var index by rememberSaveable { mutableStateOf(0) }
    BottomNavigation {
        BottomNavigationItem(selected = index == 0, onClick = { index = 0 }, icon = {
            Icon(imageVector = Icons.Default.Home, contentDescription = "Home")
        }, label = { Text(text = "Home") })
        BottomNavigationItem(selected = index == 1, onClick = { index = 1 }, icon = {
            Icon(imageVector = Icons.Default.Favorite, contentDescription = "Favorite")
        }, label = { Text(text = "Favorite") })
        BottomNavigationItem(selected = index == 2, onClick = { index = 2 }, icon = {
            Icon(imageVector = Icons.Default.Person, contentDescription = "Person")
        }, label = { Text(text = "Person") })
    }
}


@Composable
fun MyTopAppBar(onClickIcon: (String) -> Unit, onClicDrawer: () -> Unit) {
    TopAppBar(
        title = { Text(text = "Super heroes") },
        backgroundColor = Gray,
        contentColor = White,
        navigationIcon = {
            IconButton(onClick = { onClicDrawer() }) {
                Icon(imageVector = Icons.Filled.Menu, contentDescription = "menu")
            }
        },
        actions = {
            IconButton(onClick = { onClickIcon("Search") }) {
                Icon(imageVector = Icons.Filled.Search, contentDescription = "search")
            }
            IconButton(onClick = { onClickIcon("KeyboardArrowDown") }) {
                Icon(
                    imageVector = Icons.Filled.KeyboardArrowDown,
                    contentDescription = "KeyboardArrowDown"
                )
            }
        }
    )
}