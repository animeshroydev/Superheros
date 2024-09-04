package com.appmakerszone.superheros

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.appmakerszone.superheros.model.Hero
import com.appmakerszone.superheros.model.HeroesRepository
import com.appmakerszone.superheros.ui.theme.SuperherosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuperherosTheme {

          HeroesApp()

            }
        }
    }
}

@Composable
fun HeroesApp() {

 LazyColumn {
     items(HeroesRepository.heroes) {
         HeroItems(it)
     }
 }

}

@Composable
fun HeroItems(hero: Hero, modifier: Modifier = Modifier) {

    Card(modifier = modifier) {

        Row {

            HeroesInformation(
                title = hero.nameRes,
                description = hero.descriptionRes
            )

            HeroesImage(heroImage = hero.imageRes)

        }

    }

}

@Composable
fun HeroesInformation(
    @StringRes title: Int,
    @StringRes description: Int, modifier: Modifier = Modifier
) {

    Column(modifier = modifier) {

        Text(
            text = stringResource(id = title),
            style = MaterialTheme.typography.labelSmall
        )

        Text(
            text = stringResource(id = description),
            style = MaterialTheme.typography.labelSmall
        )

    }

}

@Composable
fun HeroesImage(@DrawableRes heroImage: Int, modifier: Modifier = Modifier) {

    Image(
        painter = painterResource(id = heroImage),
        contentDescription = null
    )

}

@Composable
fun Greeting(modifier: Modifier = Modifier) {
    Text(
        text = "Hello Animesh!",
        modifier = modifier
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    SuperherosTheme {
        HeroesApp()
    }
}