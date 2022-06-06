package com.msa.movie_app_section1.navagation


//www.google.com/sign_in
enum class MovieScreens {
    HomScreen,
    DetailsScreen;
    companion object{
        fun fromRoute(route:String?):MovieScreens
        = when(route?.substringBefore("/")){
            HomScreen.name->HomScreen
            DetailsScreen.name ->DetailsScreen
            null ->HomScreen
            else-> throw IllegalAccessException("Route $route is not recogninze")
        }
    }
}