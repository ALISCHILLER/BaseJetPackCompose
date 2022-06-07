package com.msa.movie_app_section1.screens.detailsScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.size.Size
import coil.transform.CircleCropTransformation
import com.msa.movie_app_section1.model.Movie_Model
import com.msa.movie_app_section1.model.getMovies
import com.msa.movie_app_section1.widgets.MovieRow

@Composable
fun DetailsScreen(navController: NavController,
                  movieId: String?){

    val movieList= getMovies().filter {movie ->
        movie.id == movieId

    }
    Scaffold(topBar = {
        TopAppBar(
            backgroundColor = Color.Transparent,
            elevation = 0.dp
        ) {
            Row(horizontalArrangement = Arrangement.Start) {
                Icon(imageVector =Icons.Default.ArrowBack ,
                    contentDescription ="Arrow Back",
                    modifier = Modifier.clickable {
                     navController.popBackStack()
                    })
                Spacer(modifier = Modifier.width(100.dp))
                Text("Movies App")
            }

        }
    }) {
        Surface(modifier = Modifier
            .fillMaxHeight()
            .fillMaxWidth()) {

            Column(horizontalAlignment =  Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top) {
                MovieRow(movie=movieList.first())
               Spacer(modifier = Modifier.height(8.dp))
                Divider()
                Text(text = "Movie Images")
                HorizontalScrollableImageView(movieList)
            }

        }
    }


}

@Composable
private fun HorizontalScrollableImageView(movieList: List<Movie_Model>) {
    LazyRow {
        items(movieList[0].image) { image ->
            Card(
                modifier = Modifier
                    .padding(12.dp)
                    .size(240.dp),
                elevation = 5.dp
            ) {
                val painter = rememberAsyncImagePainter(
                    model =
                    ImageRequest.Builder(LocalContext.current)
                        .data(image)
                        .size(Size.ORIGINAL)
                        .crossfade(true)
                        .transformations(CircleCropTransformation())
                        .build()
                )
                Image(
                    painter = painter,
                    contentDescription = "Movie Poster"
                )
            }
        }
    }
}