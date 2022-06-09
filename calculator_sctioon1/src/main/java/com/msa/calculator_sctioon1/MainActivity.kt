package com.msa.calculator_sctioon1

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.msa.calculator_sctioon1.components.InputField
import com.msa.calculator_sctioon1.ui.theme.BaseJetPackComposeTheme
@ExperimentalComposeUiApi
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
               //TopHeader()
                MainContent()
            }
        }
    }
}

//@Preview
@Composable
fun TopHeader(perPerson:Double=555.0){
    Surface(modifier = Modifier
        .fillMaxWidth()
        .height(150.dp)
        .clip(shape = CircleShape.copy(all = CornerSize(12.dp))),
        color = Color(0xFFE9D7f7)
        //.clip(shape = RoundedCornerShape(corner = CornerSize(12.dp)))
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            val total="%.2f".format(perPerson)
            Text(text = "Total Per Person",
                style = MaterialTheme.typography.h4
            )
            Text(text = "$$total",
                style = MaterialTheme.typography.h5,
                fontWeight = FontWeight.ExtraBold)
        }
    }
}

@ExperimentalComposeUiApi
@Preview
@Composable
fun MainContent(){
    BillForm(){ billAtm ->
        Log.e("ATM", "MainContent: $billAtm", )
    }
}

@ExperimentalComposeUiApi
@Composable
fun BillForm(modifier: Modifier=Modifier,
             onValChange:(String)->Unit={}
             ){
    val totalBillState= remember {
        mutableStateOf("")
    }
    val validState= remember(totalBillState.value) {
        totalBillState.value.trim().isNotEmpty()

    }
    val keyboardController=LocalSoftwareKeyboardController.current
    Surface(
        modifier = Modifier
            .padding(1.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(corner = CornerSize(8.dp)),
        border = BorderStroke(width = 1.dp,color=Color.LightGray)
    ) {
        Column() {
            InputField(
                valueState =totalBillState ,
                labelId = "Enter Bill",
                enabled = true,
                isSingleLine =true,
                onAction = KeyboardActions{
                    if (!validState)return@KeyboardActions
                    onValChange(totalBillState.value.trim())
                    keyboardController?.hide()
                })

            if(validState){
               Row(modifier=Modifier.padding(3.dp),
                   horizontalArrangement = Arrangement.Start) {
                  
               }
            }else{
                Box() {
                    
                }
            }

        }
    }
}
@Composable
fun MyApp(content:@Composable () -> Unit){
    BaseJetPackComposeTheme {
        // A surface container using the 'background' color from the theme
        Surface( color = MaterialTheme.colors.background) {
            content()
        }
    }


}



@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    BaseJetPackComposeTheme {
        MyApp {
            Text(text = "Hi Kotlin")
        }
    }
}
