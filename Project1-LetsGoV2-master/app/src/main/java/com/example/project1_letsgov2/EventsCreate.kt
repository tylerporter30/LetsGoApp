package com.example.project1_letsgov2

import android.content.Intent
import android.os.Bundle
import android.widget.DatePicker
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.*
import android.widget.*
//import androidx.appcompat.app.AppCompatActivity


class EventsCreate : ComponentActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            Column(
                modifier = Modifier.fillMaxSize(),
                //verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,

                ) {
                SimpleText1("Creating an Event")

                SampleTextField("Event Name")
                SampleTextBox()

                SampleTextField("Event Details")
                SampleTextBox()

                SampleTextField("Event Location")
                SampleTextBox()

                SampleTextField("Event Interests")
                SampleTextBox()

                CreateEvent()
            }
        }
    }
}
@Composable
fun CreateEvent() {

    Column (
        modifier = Modifier
            .fillMaxSize(), Arrangement.Bottom,Alignment.CenterHorizontally
    ){

        val context = LocalContext.current
        TextButton(
            onClick = {
                Toast.makeText(context,"Password Successfully Reset!", Toast.LENGTH_LONG).show()
            },

            ) {

            Text("Create Event", color = Color(0xFF2196F3))
        }
    }
}
@ExperimentalFoundationApi
@Composable
fun SampleDateBox() {


    //var date by remember { mutableStateOf(TextFieldValue()) }

    //DatePicker
//    TextField(
//        value = text,
//        modifier = Modifier
//            .padding(16.dp)
//            .fillMaxWidth(),
//        onValueChange = {
//            text = it
//        }
//    )
}