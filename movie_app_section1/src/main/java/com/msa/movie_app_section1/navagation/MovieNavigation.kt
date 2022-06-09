package com.msa.movie_app_section1.navagation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.msa.movie_app_section1.screens.detailsScreen.DetailsScreen
import com.msa.movie_app_section1.screens.homescreen.HomeScreen

@Composable
fun MovieNavigtion(){
    val navController= rememberNavController()
    NavHost(navController = navController,
        startDestination = MovieScreens.HomScreen.name ){

        composable(MovieScreens.HomScreen.name){
            //here we pass where this should lead us to
            HomeScreen(navController=navController)
        }

        //www.google.com/detail-screen/id=34
        composable(MovieScreens.DetailsScreen.name+"/{movie}",
        arguments = listOf(navArgument(name="movie"){type= NavType.StringType})){
            backStackEntry ->
            DetailsScreen(navController=navController,
                backStackEntry.arguments?.getString("movie"))
        }
    }
}