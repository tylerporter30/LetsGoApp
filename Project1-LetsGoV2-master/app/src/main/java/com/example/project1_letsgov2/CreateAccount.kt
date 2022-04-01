package com.example.project1_letsgov2

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.TextField
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

class CreateAccount : ComponentActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                SimpleText3("Create Account")

                CreateAccountButton1()

            }
        }
    }
}

@Composable
fun SimpleText3(displayText: String) {

    Text(
        text = displayText,
        fontFamily = FontFamily.Serif,
        fontSize = 45.sp,
        modifier = Modifier.padding(1.dp)
    )
}

@Composable
fun Name(text: String) {
    Text(
        text = text,
        style = TextStyle(
            fontSize = 16.sp,
            color = Color.Black
        ),
        modifier = Modifier
            .paddingFromBaseline(top = 60.dp)
            .padding(horizontal = 16.dp)
            .fillMaxWidth()
    )
}

@Composable
fun Email(text: String) {
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

@Composable
fun Password1(text: String) {
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

@Composable
fun ConfirmPassword1(text: String) {
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
fun NameBox() {

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
fun EmailBox() {

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

fun CreateAccountInput(
    full_name: String,
    email: String,
    new_password: String,
    confirm_password: String
): String {

    var status: String = ""

    if (full_name.equals("JohnDoe") &&
        email.equals("abc@gmail.com") &&
        new_password.equals("password") &&
        confirm_password.equals("password")
    ) {

        status = "Confirmed"

    } else {

        status = "Deny"
    }

    return status
}

@Composable
fun CreateAccountButton1() {

    val context = LocalContext.current
    Column(

        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(1.dp)
    )
    {


        var fullUsernameInput by rememberSaveable { mutableStateOf("") }
        var emailInput by rememberSaveable { mutableStateOf("") }
        var newPasswordInput by rememberSaveable { mutableStateOf("") }
        var confirmPasswordInput by rememberSaveable { mutableStateOf("") }

        Name(text = "Username")

        TextField(modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
            value = fullUsernameInput,
            onValueChange = { fullUsernameInput = it })

        Email(text = "Email")

        TextField(modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
            value = emailInput,
            onValueChange = { emailInput = it })

        Password1(text = "Password")

        TextField(modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
            value = newPasswordInput,
            onValueChange = { newPasswordInput = it })

        ConfirmPassword1(text = "Confirm Password")

        TextField(modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
            value = confirmPasswordInput,
            onValueChange = { confirmPasswordInput = it })

        var status by rememberSaveable {
            mutableStateOf("")

        }

        //val backgroundColor = Color(0xFF2196F3)
        Card(
            shape = RoundedCornerShape(10.dp),
            backgroundColor = Color(0xFF2196F3),
            modifier = Modifier
                .padding(30.dp)
                .width(150.dp)
                .clickable(onClick = {
                    status = CreateAccountInput(
                        fullUsernameInput,
                        emailInput,
                        newPasswordInput,
                        confirmPasswordInput
                    );
                    context.startActivity(Intent(context, MainActivity::class.java))
                })
        ) {
            Text(
                text = "Create Account",
                textAlign = TextAlign.Center,
                style = TextStyle(
                    fontSize = 18.sp, fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.padding(10.dp)
            )

        }
        Text(text = "$status")

        CancelButton()
    }
}

@Composable
fun CancelButton() {

    Column(
        modifier = Modifier
            .fillMaxSize(), Arrangement.Bottom, Alignment.CenterHorizontally
    ) {

        val context = LocalContext.current
        TextButton(
            onClick = {
                context.startActivity(Intent(context, MainActivity::class.java))
            },

            ) {
            Text("Cancel", color = Color(0xFF2196F3))
        }
    }
}