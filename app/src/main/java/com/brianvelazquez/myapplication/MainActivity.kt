package com.brianvelazquez.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.brianvelazquez.myapplication.ui.theme.MyApplicationTheme

/**
 * GitHub token for this MAc
 * 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
 *
 * */

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column() {
                        //Here we are adding our new feature
                        var text by remember { mutableStateOf(":)") }
                        MyOutlinedTextField(myText = text) {text = it}
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {
        //MyOutlinedTextField()
    }
}

@Composable
fun MyOutlinedTextField(myText: String, onValueChanged:(String) -> Unit){
    OutlinedTextField(
        value = myText,
        onValueChange = {onValueChanged(it)},
        label = { Text(text = "Escribe algo")},
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Green,
            unfocusedBorderColor = Color.Blue
        ))
}

@Composable
fun MyStateExample(){
    var counter by rememberSaveable {
        mutableStateOf(0)
    }
    Column(Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
        Button(onClick = { counter += 1}) {
            Text(text = "Button")
        }
        
        Text(text = "Me han pulsado ${counter} veces")
        
    }
}

@Composable
fun MyLayouts(){
    Column(Modifier.fillMaxSize()) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .weight(1f)
            .background(Color.Cyan), contentAlignment = Alignment.Center
        ){
            Text(text = "Ejemplo 1")
        }
        MySpacer(size = 30)
        Row(modifier = Modifier
            .fillMaxWidth()
            .weight(1f)
            .horizontalScroll(rememberScrollState())){
            Box(
                Modifier
                    .fillMaxHeight()
                    .width(200.dp)
                    .background(Color.Red), contentAlignment = Alignment.Center){
                Text(text = "Ejemplo 1")
            }
            Box(
                Modifier
                    .fillMaxHeight()
                    .width(200.dp)
                    .background(Color.Green), contentAlignment = Alignment.Center){
                Text(text = "Ejemplo 1")
            }
            Box(
                Modifier
                    .fillMaxHeight()
                    .width(200.dp)
                    .background(Color.Red), contentAlignment = Alignment.Center){
                Text(text = "Ejemplo 1")
            }
            Box(
                Modifier
                    .fillMaxHeight()
                    .width(200.dp)
                    .background(Color.Green), contentAlignment = Alignment.Center){
                Text(text = "Ejemplo 1")
            }
        }
        MySpacer(size = 30)
        Box(modifier = Modifier
            .fillMaxWidth()
            .weight(1f)
            .background(Color.Magenta), contentAlignment = Alignment.BottomCenter){
            Text(text = "Ejemplo 1")
        }
    }

}

@Composable
fun MySpacer(size: Int){
    Spacer(modifier = Modifier.height(size.dp))
}

@Composable
fun MyRow(){
    Row(
        Modifier
            .fillMaxSize()
            .horizontalScroll(rememberScrollState())) {
        Text(text = "Ejemplo 1", Modifier.width(100.dp))
        Text(text = "Ejemplo 1", Modifier.width(100.dp))
        Text(text = "Ejemplo 1", Modifier.width(100.dp))
        Text(text = "Ejemplo 1", Modifier.width(100.dp))
        Text(text = "Ejemplo 1", Modifier.width(100.dp))
        Text(text = "Ejemplo 1", Modifier.width(100.dp))
        Text(text = "Ejemplo 1", Modifier.width(100.dp))
        Text(text = "Ejemplo 1", Modifier.width(100.dp))
        Text(text = "Ejemplo 1", Modifier.width(100.dp))
        Text(text = "Ejemplo 1", Modifier.width(100.dp))
        Text(text = "Ejemplo 1", Modifier.width(100.dp))
        Text(text = "Ejemplo 1", Modifier.width(100.dp))
        Text(text = "Ejemplo 1", Modifier.width(100.dp))
        Text(text = "Ejemplo 1", Modifier.width(100.dp))
        Text(text = "Ejemplo 1", Modifier.width(100.dp))
        Text(text = "Ejemplo 1", Modifier.width(100.dp))
        Text(text = "Ejemplo 1", Modifier.width(100.dp))
        Text(text = "Ejemplo 1", Modifier.width(100.dp))
        Text(text = "Ejemplo 1", Modifier.width(100.dp))
        Text(text = "Ejemplo 1", Modifier.width(100.dp))
    }
}

@Composable
fun MyColumn(){
    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.SpaceBetween) {
        Text(text = "Ejemplo 1",
            Modifier
                .height(100.dp)
                .background(Color.Blue)
                .fillMaxWidth())
        Text(text = "Ejemplo 2",
            Modifier
                .height(100.dp)
                .background(Color.Yellow)
                .fillMaxWidth())
        Text(text = "Ejemplo 3",
            Modifier
                .height(100.dp)
                .background(Color.Green)
                .fillMaxWidth())
        Text(text = "Ejemplo 4",
            Modifier
                .height(100.dp)
                .background(Color.Gray)
                .fillMaxWidth())
        Text(text = "Ejemplo 5",
            Modifier
                .height(100.dp)
                .background(Color.Magenta)
                .fillMaxWidth())
        Text(text = "Ejemplo 1",
            Modifier
                .height(100.dp)
                .background(Color.Blue)
                .fillMaxWidth())
        Text(text = "Ejemplo 2",
            Modifier
                .height(100.dp)
                .background(Color.Yellow)
                .fillMaxWidth())
        Text(text = "Ejemplo 3",
            Modifier
                .height(100.dp)
                .background(Color.Green)
                .fillMaxWidth())
        Text(text = "Ejemplo 4",
            Modifier
                .height(100.dp)
                .background(Color.Gray)
                .fillMaxWidth())
        Text(text = "Ejemplo 5",
            Modifier
                .height(100.dp)
                .background(Color.Magenta)
                .fillMaxWidth())
        Text(text = "Ejemplo 1",
            Modifier
                .height(100.dp)
                .background(Color.Blue)
                .fillMaxWidth())
        Text(text = "Ejemplo 2",
            Modifier
                .height(100.dp)
                .background(Color.Yellow)
                .fillMaxWidth())
        Text(text = "Ejemplo 3",
            Modifier
                .height(100.dp)
                .background(Color.Green)
                .fillMaxWidth())
        Text(text = "Ejemplo 4",
            Modifier
                .height(100.dp)
                .background(Color.Gray)
                .fillMaxWidth())
        Text(text = "Ejemplo 5",
            Modifier
                .height(100.dp)
                .background(Color.Magenta)
                .fillMaxWidth())
        Text(text = "Ejemplo 1",
            Modifier
                .height(100.dp)
                .background(Color.Blue)
                .fillMaxWidth())
        Text(text = "Ejemplo 2",
            Modifier
                .height(100.dp)
                .background(Color.Yellow)
                .fillMaxWidth())
        Text(text = "Ejemplo 3",
            Modifier
                .height(100.dp)
                .background(Color.Green)
                .fillMaxWidth())
        Text(text = "Ejemplo 4",
            Modifier
                .height(100.dp)
                .background(Color.Gray)
                .fillMaxWidth())
        Text(text = "Ejemplo 5",
            Modifier
                .height(100.dp)
                .background(Color.Magenta)
                .fillMaxWidth())

    }
}

@Composable
fun MyBox(name: String) {
    Box(modifier = Modifier.fillMaxSize(), 
        contentAlignment = Alignment.Center){
        Box(modifier = Modifier
            .width(200.dp)
            .height(200.dp)
            .background(Color.Blue),
        contentAlignment = Alignment.BottomCenter
        ){
            Text(text = "Hola $name", color = Color.White)
        }
    }
}

