package com.brianvelazquez.myapplication

import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.brianvelazquez.myapplication.model.SuperHero

@ExperimentalFoundationApi
@Composable
fun SuperHeroRecyclerView() {
    val context = LocalContext.current
    val superHeroMap = getSuperHeroes().groupBy { it.publisher }

    LazyColumn(verticalArrangement = Arrangement.spacedBy(8.dp)) {

        superHeroMap.forEach { (publisher, superHero) ->
            stickyHeader {
                Text(
                    text = publisher, modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            Color.Gray
                        ), color = Color.White
                )
            }

            items(superHero) { superhero ->
                ItemSuperHero(superHero = superhero) {
                    Toast.makeText(context, it.superHeroName, Toast.LENGTH_LONG).show()
                }
            }

        }

    }
}

@Composable
fun ItemSuperHero(superHero: SuperHero, onItemSelected: (SuperHero) -> Unit) {
    Card(
        Modifier
            .fillMaxWidth()
            .padding(horizontal = 5.dp, vertical = 5.dp)
            .clickable { onItemSelected(superHero) },
        border = BorderStroke(8.dp, color = Color.Gray),
        shape = RoundedCornerShape(24.dp)
    ) {
        Column(Modifier.fillMaxWidth()) {
            Image(
                painter = painterResource(id = superHero.image),
                contentDescription = "Image",
                modifier = Modifier.fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Text(
                text = superHero.superHeroName,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Text(
                text = superHero.realName,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 12.sp
            )
            Text(
                text = superHero.publisher,
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(end = 24.dp, bottom = 24.dp),
                fontSize = 12.sp,
            )
        }

    }
}

fun getSuperHeroes(): List<SuperHero> {
    return listOf(
        SuperHero("Batman", "Example 1", "DC", R.drawable.batman),
        SuperHero("Daredevil", "Example 1", "Marvel", R.drawable.daredevil),
        SuperHero("Flash", "Example 1", "DC", R.drawable.flash),
        SuperHero("Green Lattern", "Example 1", "DC", R.drawable.green_lantern),
        SuperHero("Logan", "Example 1", "Marvel", R.drawable.logan),
        SuperHero("Spiderman", "Example 1", "Marvel", R.drawable.spiderman),
        SuperHero("Thor", "Example 1", "Marvel", R.drawable.thor),
        SuperHero("Wonder woman", "Example 1", "DC", R.drawable.wonder_woman)
    )
}