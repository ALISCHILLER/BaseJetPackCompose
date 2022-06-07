package com.msa.movie_app_section1.screens.homescreen

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.msa.movie_app_section1.model.Movie_Model
import com.msa.movie_app_section1.model.getMovies
import com.msa.movie_app_section1.navagation.MovieScreens
import com.msa.movie_app_section1.widgets.MovieRow


@Composable
fun HomeScreen(navController: NavController){
    Scaffold(topBar = {
        TopAppBar(
            backgroundColor = Color.Transparent,
            elevation = 0.dp
        ) {
            Text("Movies App")
        }
    },) {
        MainContent(navController=navController)
    }
}


@Composable
fun MainContent(
    navController: NavController,
    movieList:List<Movie_Model> = getMovies()){
    Column(modifier = Modifier.padding(12.dp)){
        LazyColumn{
            items(items= movieList){
                MovieRow(movie = it){movie ->
                   /// Log.d("MainActivity", "MainContent: $movie")
                    navController.navigate(route = MovieScreens.DetailsScreen.name+"/$movie")

                }
            }
        }
    }
}