package com.msa.movie_app_section1.model

data class Movie_Model(
    val id:String,
    val titel:String,
    val year:String,
    val genre:String,
    val director:String,
    val actors:String,
    val plot:String,
    val poster:String,
    val image:List<String>,
    val rating:String
)