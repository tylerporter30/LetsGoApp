package com.example.project1_letsgov2

import android.content.Intent
import android.os.Bundle
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

class DeleteAccount() : ComponentActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                SimpleText6("Please Select An Account Action")

                DeleteAccount("Delete Your Account")
                DeleteAccountBox()

                ConfirmDeleteAccount("Confirm Account Deletion")
                DeleteAccountBox2()

                /*  SubmitButton4() [not needed, now, after edits]; where changes began, HERE;
                Line 46: Felt more organized, with 2 sentences in 1 code line */
                SimpleText5("Your Account has been deleted. We're Sorry to See You Go!")
                SubmitButton5()
            }
        }
    }
}

//See lines 43-44, of 'UpdateProfile', RE: consistency among screens
@Composable
fun SimpleText6(displayText: String) {

    Text(
        text = displayText,
        fontFamily = FontFamily.Serif,
        fontSize = 28.sp,
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
fun DeleteAccount(text: String) {
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
fun ConfirmDeleteAccount(text: String) {
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
fun DeleteAccountBox() {

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
fun DeleteAccountBox2() {

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

/*
@Composable
fun SubmitButton4() {

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
}  [Line's 128-here: not necessary, after commenting out #44] */

//Again, general consistency, with other screens, due to similar actions (& small size edits)
@Composable
fun SubmitButton5() {

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
