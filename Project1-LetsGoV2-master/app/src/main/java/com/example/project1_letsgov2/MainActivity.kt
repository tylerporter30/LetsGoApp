package com.example.project1_letsgov2

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import com.example.project1_letsgov2.ui.Drawer
import com.example.project1_letsgov2.ui.DrawerScreen

class MainActivity : ComponentActivity() {
    @ExperimentalFoundationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column(
                modifier = Modifier.fillMaxSize(),
                //verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                //SimpleText("Let's Go")
                Image(painterResource(R.drawable.logobanner),"content description")

                SimpleText1(displayText = "Create or Find a New Community!")

                Login()
            }
        }
    }
}

@Composable
fun SimpleText(displayText: String) {

    Text(
        text = displayText,
        fontFamily = FontFamily.Serif,
        fontSize = 45.sp,
        modifier = Modifier.padding(16.dp)
    )
}

@Composable
fun SimpleText1(displayText: String) {

    Text(text = displayText, fontSize = 20.sp)
}

@Composable
fun Username(text: String) {
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
fun Password(text: String) {
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

fun LoginInput(user_name: String, password: String): String {

    var status: String = ""

    if (user_name.equals("JohnDoe") && password.equals("password")) {

        status = ""

    } else {

        status = ""
    }

    return status
}

@Composable
fun ForgotPasswordCreateAccount() {
    Row() {

        Column() {
            val context = LocalContext.current
            TextButton(
                onClick = {
                    context.startActivity(Intent(context, ForgotPassword::class.java))
                },
                modifier = Modifier.padding(20.dp)
            ) {
                Text("Forgot Password", color = Color(0xFF2196F3))
            }
        }

        Row() {
            Column() {
                val context = LocalContext.current
                TextButton(
                    onClick = {
                        context.startActivity(Intent(context, CreateAccount::class.java))
                    },

                    modifier = Modifier.padding(20.dp)

                ) {

                    Text("Create Account", color = Color(0xFF2196F3))
                }
            }
        }
    }
}

@Composable
fun Login() {
    LocalContext.current

    Column(

        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    )
    {

        var usernameInput by rememberSaveable { mutableStateOf("") }
        var passwordInput by rememberSaveable { mutableStateOf("") }

        Username(text = "Username")

        TextField(modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(), value = usernameInput, onValueChange = { usernameInput = it })

        Password(text = "Password")

        TextField(modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(), value = passwordInput, onValueChange = { passwordInput = it })

        var status by rememberSaveable {
            mutableStateOf("")

        }

        ForgotPasswordCreateAccount()

        val context = LocalContext.current
        val backgroundColor = Color(0xFF2196F3)
        if (usernameInput == ("JohnDoe") && passwordInput == ("password")) {
            Button(shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = backgroundColor),
                modifier = Modifier
                    .padding(30.dp)
                    .width(150.dp),

                onClick = {
                    status = LoginInput(usernameInput, passwordInput); context.startActivity(
                    Intent(context, UpdateProfile::class.java)
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
        } else {
            Button(shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(backgroundColor = backgroundColor),
                modifier = Modifier
                    .padding(30.dp)
                    .width(150.dp),

                onClick = {
                    status = LoginInput(usernameInput, passwordInput)
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
        }
        Text(text = "$status")
    }
}

@Composable
fun AppMainScreen(){

    val navController= rememberNavController()

    Surface(
        color=MaterialTheme.colors.background

    ) {

        var drawerState= rememberDrawerState(DrawerValue.Closed )
        var scope= rememberCoroutineScope() //corouitines
        var openDrawer = {

            scope.launch {

                drawerState.open()
            }
        }

        //ModalDrawer

        ModalDrawer(

            drawerState=drawerState,
            gesturesEnabled = drawerState.isOpen,
            drawerContent = {
                Image(painterResource(R.drawable.logoonly),"content description")
                Drawer(onDestinationClicked = { route ->

                    scope.launch {

                        drawerState.close()

                    }

                    navController.navigate(route)

                    {

                        popUpTo=navController.graph.startDestinationId //replaced
                        //popUpToId=navController.graph.startDestinationId
                        launchSingleTop=true
                    }
                })
            }


        ) {

            NavHost(navController = navController, startDestination = DrawerScreen.Profile.route)
            {

                composable(DrawerScreen.Profile.route)
                {

                    UpdateProfile (openDrawer ={

                        openDrawer()
                    }

                    )
                }

                //2nd

                composable(DrawerScreen.Communities.route)
                {

                    Communities (openDrawer ={

                        openDrawer()
                    }

                    )
                }

                //3rd

                composable(DrawerScreen.Events.route)
                {

                    Events ( openDrawer = {

                        openDrawer()
                    }
                    )
                }
                //4th
                composable(DrawerScreen.Friends.route)
                {

                    Friends ( openDrawer = {

                        openDrawer()
                    }
                    )
                }


            }




        }


    }




}

