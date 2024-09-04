package com.appmakerszone.superheros

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.appmakerszone.superheros.ui.theme.SuperherosTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SuperherosTheme {
                    Greeting()
                }
            }
        }
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
        Greeting()
    }
}