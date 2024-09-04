package com.appmakerszone.superheros

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.appmakerszone.superheros.model.Hero
import com.appmakerszone.superheros.model.HeroesRepository
import com.appmakerszone.superheros.ui.theme.Shapes
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

    Scaffold(
        topBar = { SuperHeroTopAppBar() }
    ) { it ->
        LazyColumn(contentPadding = it) {
            items(HeroesRepository.heroes) {
                HeroItems(it)
            }
        }
    }

}

@Composable
fun HeroItems(hero: Hero, modifier: Modifier = Modifier) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

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


    Column(modifier = modifier.padding(20.dp)) {

        Text(
            text = stringResource(id = title),
            style = MaterialTheme.typography.displaySmall
        )

        Text(
            modifier = Modifier.width(200.dp),
            text = stringResource(id = description),
            maxLines = 4,
            overflow = TextOverflow.Ellipsis,
            style = MaterialTheme.typography.bodyLarge,
        )

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuperHeroTopAppBar(modifier: Modifier = Modifier) {

    CenterAlignedTopAppBar(
        modifier = modifier,
        title = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = stringResource(R.string.app_name),
                    style = MaterialTheme.typography.displayLarge
                )
            }
        }
    )

}

@Composable
fun HeroesImage(@DrawableRes heroImage: Int, modifier: Modifier = Modifier) {

    Box(
        modifier = Modifier
            .size(100.dp)
            .padding(10.dp)
            .padding(end = 6.dp)
    ) {
        Image(
            painter = painterResource(id = heroImage),
            contentDescription = null,
            modifier = Modifier.clip(Shapes.small),
            contentScale = ContentScale.Crop,

            )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    SuperherosTheme {
        HeroesApp()
    }
}