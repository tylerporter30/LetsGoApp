package com.example.project1_letsgov2

import android.content.Intent
import android.os.Bundle
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

class CommunitiesCreate : ComponentActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier.fillMaxSize(),
                //verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,

                ) {
                SimpleText1("Starting a Community")

                SampleTextField("Community Name")
                SampleTextBox()

                SampleTextField("What is your community about?")
                SampleTextBox()

                SampleTextField("Location")
                SampleTextBox()

                SampleTextField("Community Interests")
                SampleTextBox()

                CreateCommunity()
            }
        }
    }
}
@Composable
fun SampleTextField(text: String) {
    Text(
        text = text,
        style = TextStyle(
            fontSize = 16.sp,
            color = Color.Black
        ),
        modifier = Modifier
            .paddingFromBaseline(top = 10.dp)
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
    )
}

@ExperimentalFoundationApi
@Composable
fun SampleTextBox() {

    var text by remember { mutableStateOf(TextFieldValue()) }

    TextField(
        value = text,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        onValueChange = {
            text = it
        }
    )
}

@Composable
fun CreateCommunity() {

    Column (
        modifier = Modifier
            .fillMaxSize(), Arrangement.Bottom,Alignment.CenterHorizontally
    ){

        val context = LocalContext.current
        TextButton(
            onClick = {
                Toast.makeText(context,"Successfully Created Event!", Toast.LENGTH_LONG).show()
            },

            ) {

            Text("Create Community", color = Color(0xFF2196F3))
        }
    }
}