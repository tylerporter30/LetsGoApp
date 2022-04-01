package com.example.project1_letsgov2

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class UpdateProfile() : ComponentActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally

                ) {
                AppMainScreen()
            }
        }
    }
}

/* General consistency, with appearances & organization; some size adjustments (users' eyes);
some similarities, w/'Create Account' & 'ForgotPassword' */
@Composable
fun SimpleText4(displayText: String) {

    Text(
        text = displayText,
        fontFamily = FontFamily.Serif,
        fontSize = 28.sp,
        modifier = Modifier.padding(16.dp)
    )
}
@Composable
fun SimpleText5(displayText: String) {

    Text(
        text = displayText,
        fontFamily = FontFamily.Serif,
        fontSize = 28.sp,
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
fun UpdatedPassword(text: String) {
    Text(
        text = text,
        style = TextStyle(
            fontSize = 16.sp,
            color = Color.Black
        ),
        modifier = Modifier
            .paddingFromBaseline(top = 75.dp)
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
    )
}

@Composable
fun ConfirmUpdatedPassword(text: String) {
    Text(
        text = text,
        style = TextStyle(
            fontSize = 16.sp,
            color = Color.Black
        ),
        modifier = Modifier
            .paddingFromBaseline(top = 50.dp)
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
    )
}

@ExperimentalFoundationApi
@Composable
fun UpdatedPasswordBox() {

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

@ExperimentalFoundationApi
@Composable
fun UpdatedPasswordBox2() {

    var text by remember { mutableStateOf(TextFieldValue()) }

    TextField(value = text,
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        visualTransformation = PasswordVisualTransformation(),
        onValueChange = {
            text = it
        }
    )
}

@Composable
fun SubmitButton2() {

    val context = LocalContext.current
    Card(
        shape = RoundedCornerShape(8.dp),
        backgroundColor = Color(0xFF2196F3),
        modifier = Modifier
            .padding(30.dp)
            .width(150.dp)
            .clickable(onClick = {
                context.startActivity(Intent(context, MainActivity::class.java))
            })
    ) {
        Text(
            text = "Submit",
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontSize = 18.sp, fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.padding(16.dp)
        )
    }
}
@Composable
fun SubmitButton3() {

//More user-friendly, & engaging, confirmation message (line 166)
    val context = LocalContext.current
    Card(
        shape = RoundedCornerShape(8.dp),
        backgroundColor = Color(0xFF2196F3),
        modifier = Modifier
            .padding(30.dp)
            .width(150.dp)
            .clickable(onClick = {
                Toast.makeText(context,"Password Successfully Reset!", Toast.LENGTH_LONG)
                    .show()
            })
    ) {
        Text(
            text = "Submit",
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontSize = 18.sp, fontWeight = FontWeight.Bold
            ),
            modifier = Modifier.padding(16.dp)
        )
    }
}

/* (not needed, now: was part of initial setup idea - needed to revise it all >) @Composable
fun saveProfileChanges()
{

}
*/