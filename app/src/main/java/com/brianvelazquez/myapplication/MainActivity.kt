package com.brianvelazquez.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
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

                var selected by rememberSaveable{mutableStateOf("Brian")}

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MyRadioButtonList(name = selected, onItemselected = {selected = it})

                }
            }
        }
    }
}



@Composable
fun GetOptions(titles : List<String>): List<CheckInfo>{
    return titles.map {
        var status by rememberSaveable { mutableStateOf(false) }
        CheckInfo(
            title = it,
            selected = status,
            onCheckedChange = {status = it}
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApplicationTheme {

    }
}

@Composable
fun MyRadioButtonList(name: String, onItemselected:(String) -> Unit){

    Column(Modifier.fillMaxSize()) {
        Row() {
            RadioButton(selected = name == "Angel", onClick = {onItemselected("Angel")})
            Text(text = "Angel", Modifier.padding(top = 11.dp))
        }

        Row() {
            RadioButton(selected = name == "Brian", onClick = {onItemselected("Brian")})
            Text(text = "Brian", Modifier.padding(top = 11.dp))
        }

        Row() {
            RadioButton(selected = name == "Adonai", onClick = {onItemselected("Adonai")})
            Text(text = "Adonai", Modifier.padding(top = 11.dp))
        }

    }
    
}

@Composable
fun MyCheckboxWithText(checkInfo: CheckInfo){
    Row() {
        Checkbox(
            checked = checkInfo.selected,
            onCheckedChange = {checkInfo.onCheckedChange(!checkInfo.selected)})
        Text(text = checkInfo.title, Modifier.padding(top = 11.dp))
    }
}

@Composable
fun MyProgressBarAdvanced(){
    var progress by rememberSaveable{ mutableStateOf(.10f) }
    Column(Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(progress)
        Row(Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center) {
            Button(onClick = { progress += .10f},
            modifier = Modifier.padding(10.dp)) {
                Text(text = "Incrementar")
            }
            Button(onClick = { progress -= .10f},
                modifier = Modifier.padding(10.dp)) {
                Text(text = "Decrementar")
            }
        }
    }
}

@Composable
fun MyProgressBar(){
    var showProgress by rememberSaveable { mutableStateOf(false) }
    Column(Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if(showProgress){
            CircularProgressIndicator()
            LinearProgressIndicator()
        }
        OutlinedButton(onClick = { showProgress = !showProgress}) {
            Text(text = "Mostrar")
        }
    }
}

@Composable
fun MyIcon() {
    Icon(imageVector = Icons.Default.Search,
        contentDescription = "icon",
        tint = Color.Yellow
    )
}

@Composable
fun MyImageAdvance() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "Example",
        modifier = Modifier
            .clip(CircleShape)
            .border(5.dp, Color.Green, CircleShape)
    )
}

@Composable
fun MyImage() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "Example",
        alpha = 5f
    )
}

@Composable
fun MyButtons() {

    var enabled by rememberSaveable { mutableStateOf(true) }

    Column(Modifier.fillMaxSize()) {
        Button(
            onClick = { enabled = false },
            modifier = Modifier.padding(20.dp),
            enabled = enabled,
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Gray,
                contentColor = Color.Black
            )
        ) {
            Text(text = "Hola")
        }

        OutlinedButton(
            onClick = { enabled = false },
            enabled = enabled,
            modifier = Modifier.padding(start = 20.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color.Gray,
                contentColor = Color.Black
            )
        ) {
            Text(text = "Hello")
        }

        TextButton(onClick = { }, Modifier.padding(start = 20.dp, top = 20.dp)) {
            Text(text = "Ciao")
        }

    }

}

@Composable
fun MyOutlinedTextField(myText: String, onValueChanged: (String) -> Unit) {
    OutlinedTextField(
        value = myText,
        onValueChange = { onValueChanged(it) },
        label = { Text(text = "Escribe algo") },
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = Color.Green,
            unfocusedBorderColor = Color.Blue
        )
    )
}

@Composable
fun MyStateExample() {
    var counter by rememberSaveable {
        mutableStateOf(0)
    }
    Column(
        Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { counter += 1 }) {
            Text(text = "Button")
        }

        Text(text = "Me han pulsado ${counter} veces")

    }
}

@Composable
fun MyLayouts() {
    Column(Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Cyan), contentAlignment = Alignment.Center
        ) {
            Text(text = "Ejemplo 1")
        }
        MySpacer(size = 30)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .horizontalScroll(rememberScrollState())
        ) {
            Box(
                Modifier
                    .fillMaxHeight()
                    .width(200.dp)
                    .background(Color.Red), contentAlignment = Alignment.Center
            ) {
                Text(text = "Ejemplo 1")
            }
            Box(
                Modifier
                    .fillMaxHeight()
                    .width(200.dp)
                    .background(Color.Green), contentAlignment = Alignment.Center
            ) {
                Text(text = "Ejemplo 1")
            }
            Box(
                Modifier
                    .fillMaxHeight()
                    .width(200.dp)
                    .background(Color.Red), contentAlignment = Alignment.Center
            ) {
                Text(text = "Ejemplo 1")
            }
            Box(
                Modifier
                    .fillMaxHeight()
                    .width(200.dp)
                    .background(Color.Green), contentAlignment = Alignment.Center
            ) {
                Text(text = "Ejemplo 1")
            }
        }
        MySpacer(size = 30)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Magenta), contentAlignment = Alignment.BottomCenter
        ) {
            Text(text = "Ejemplo 1")
        }
    }

}

@Composable
fun MySpacer(size: Int) {
    Spacer(modifier = Modifier.height(size.dp))
}

@Composable
fun MyRow() {
    Row(
        Modifier
            .fillMaxSize()
            .horizontalScroll(rememberScrollState())
    ) {
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
fun MyColumn() {
    Column(
        Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()), verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Ejemplo 1",
            Modifier
                .height(100.dp)
                .background(Color.Blue)
                .fillMaxWidth()
        )
        Text(
            text = "Ejemplo 2",
            Modifier
                .height(100.dp)
                .background(Color.Yellow)
                .fillMaxWidth()
        )
        Text(
            text = "Ejemplo 3",
            Modifier
                .height(100.dp)
                .background(Color.Green)
                .fillMaxWidth()
        )
        Text(
            text = "Ejemplo 4",
            Modifier
                .height(100.dp)
                .background(Color.Gray)
                .fillMaxWidth()
        )
        Text(
            text = "Ejemplo 5",
            Modifier
                .height(100.dp)
                .background(Color.Magenta)
                .fillMaxWidth()
        )
        Text(
            text = "Ejemplo 1",
            Modifier
                .height(100.dp)
                .background(Color.Blue)
                .fillMaxWidth()
        )
        Text(
            text = "Ejemplo 2",
            Modifier
                .height(100.dp)
                .background(Color.Yellow)
                .fillMaxWidth()
        )
        Text(
            text = "Ejemplo 3",
            Modifier
                .height(100.dp)
                .background(Color.Green)
                .fillMaxWidth()
        )
        Text(
            text = "Ejemplo 4",
            Modifier
                .height(100.dp)
                .background(Color.Gray)
                .fillMaxWidth()
        )
        Text(
            text = "Ejemplo 5",
            Modifier
                .height(100.dp)
                .background(Color.Magenta)
                .fillMaxWidth()
        )
        Text(
            text = "Ejemplo 1",
            Modifier
                .height(100.dp)
                .background(Color.Blue)
                .fillMaxWidth()
        )
        Text(
            text = "Ejemplo 2",
            Modifier
                .height(100.dp)
                .background(Color.Yellow)
                .fillMaxWidth()
        )
        Text(
            text = "Ejemplo 3",
            Modifier
                .height(100.dp)
                .background(Color.Green)
                .fillMaxWidth()
        )
        Text(
            text = "Ejemplo 4",
            Modifier
                .height(100.dp)
                .background(Color.Gray)
                .fillMaxWidth()
        )
        Text(
            text = "Ejemplo 5",
            Modifier
                .height(100.dp)
                .background(Color.Magenta)
                .fillMaxWidth()
        )
        Text(
            text = "Ejemplo 1",
            Modifier
                .height(100.dp)
                .background(Color.Blue)
                .fillMaxWidth()
        )
        Text(
            text = "Ejemplo 2",
            Modifier
                .height(100.dp)
                .background(Color.Yellow)
                .fillMaxWidth()
        )
        Text(
            text = "Ejemplo 3",
            Modifier
                .height(100.dp)
                .background(Color.Green)
                .fillMaxWidth()
        )
        Text(
            text = "Ejemplo 4",
            Modifier
                .height(100.dp)
                .background(Color.Gray)
                .fillMaxWidth()
        )
        Text(
            text = "Ejemplo 5",
            Modifier
                .height(100.dp)
                .background(Color.Magenta)
                .fillMaxWidth()
        )

    }
}

@Composable
fun MyBox(name: String) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .width(200.dp)
                .height(200.dp)
                .background(Color.Blue),
            contentAlignment = Alignment.BottomCenter
        ) {
            Text(text = "Hola $name", color = Color.White)
        }
    }
}

