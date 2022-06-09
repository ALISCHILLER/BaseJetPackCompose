package com.msa.movie_app_section1

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.msa.movie_app_section1.model.Movie_Model
import com.msa.movie_app_section1.navagation.MovieNavigtion
import com.msa.movie_app_section1.ui.theme.BaseJetPackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                MovieNavigtion()
            }

        }
    }
}


@Composable
fun MyApp(content:@Composable ()-> Unit ){
    BaseJetPackComposeTheme {
        content()
    }
}





@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp {
        MovieNavigtion()
    }
}