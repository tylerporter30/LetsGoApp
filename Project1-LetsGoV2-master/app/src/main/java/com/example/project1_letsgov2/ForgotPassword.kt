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
import androidx.compose.runtime.saveable.rememberSaveable
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

class ForgotPassword : ComponentActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier.fillMaxSize(),
                //verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {

                SimpleText2("Create New Password")

                SubmitButton()
            }
        }
    }
}

@Composable
fun SimpleText2(displayText: String) {

    Text(
        text = displayText,
        fontFamily = FontFamily.Serif,
        fontSize = 35.sp,
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
fun NewPassword(text: String) {
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
fun ConfirmPassword(text: String) {
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

fun NewPasswordInput(new_password: String, confirm_password: String): String {

    var status: String = ""

    if (new_password.equals("password") && confirm_password.equals("password")) {

        status = "Confirmed"

    } else {

        status = "Deny"
    }

    return status
}

@Composable
fun SubmitButton() {

    val context = LocalContext.current
    Column(

        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    )
    {


        var newPasswordInput by rememberSaveable { mutableStateOf("") }
        var confirmPasswordInput by rememberSaveable { mutableStateOf("") }

        NewPassword(text = "New Password")

        TextField(modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
            value = newPasswordInput,
            onValueChange = { newPasswordInput = it })

        ConfirmPassword(text = "Confirm Password")

        TextField(modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
            value = confirmPasswordInput,
            onValueChange = { confirmPasswordInput = it })

        var status by rememberSaveable {
            mutableStateOf("")

        }

        val backgroundColor = Color(0xFF2196F3)
        Button(shape = RoundedCornerShape(10.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = backgroundColor),
            modifier = Modifier
                .padding(30.dp)
                .width(150.dp),
            onClick = {
                status =
                    NewPasswordInput(newPasswordInput, confirmPasswordInput); context.startActivity(
                Intent(context, MainActivity::class.java)
            )
            }) {

            Text(
                text = "Login",
                textAlign = TextAlign.Center,
                style = TextStyle(
                    fontSize = 20.sp, fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.padding(16.dp)
            )
        }
        Text(text = "$status")

    }
}