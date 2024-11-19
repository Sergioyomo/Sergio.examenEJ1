package com.example.sergioexamenej1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VideoGameListScreen()
        }
    }
}

@Composable
fun VideoGameListScreen() {
    val videoGames = getVideoGames()
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(videoGames.size) { index ->
            VideoGameItem(videoGames[index])
        }
    }
}

@Composable
fun VideoGameItem(videoGame: videojuegos) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Imagen del videojuego
        AsyncImage(
            model = videoGame.imageUrl,
            contentDescription = "Imagen de ${videoGame.name}",
            modifier = Modifier
                .size(100.dp)
                .padding(end = 16.dp)
        )

        // Información del videojuego
        Column {
            Text(
                text = videoGame.name,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = videoGame.price,
                fontSize = 16.sp,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Start
            )
        }
    }
}


fun getVideoGames(): List<videojuegos> {
    return List(10) { index ->
        videojuegos(
            name = "Videojuego ${index + 1}",
            price = "$${(10..60).random()}",
            imageUrl = "https://loremflickr.com/400/400/seville?lock=${index + 1}"
        )
    }
}

