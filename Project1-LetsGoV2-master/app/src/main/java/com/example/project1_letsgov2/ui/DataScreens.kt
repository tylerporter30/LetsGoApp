package com.example.project1_letsgov2

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.example.project1_letsgov2.R
import androidx.navigation.NavController

var list:Boolean = false

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun UpdateProfile(openDrawer:()->Unit)
{
    Column(

        modifier=Modifier.fillMaxSize()
    ) {


        TopBar(title = "Profile",   buttonIcon =Icons.Filled.Menu,onButtonClicked = {openDrawer()})


        Column(
            modifier=Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {

            SimpleText4("Reset Password Here!")

            UpdatedPassword("Old Password:")
            UpdatedPasswordBox()

            ConfirmUpdatedPassword("Updated Password:")
            UpdatedPasswordBox2()

            ConfirmUpdatedPassword("Confirm Updated Password")
            UpdatedPasswordBox2()

            //SimpleText5("Please Save Your Profile Changes")
            SubmitButton3()

        }

    }


}


@Composable
fun Communities(openDrawer:()->Unit)
{
    Column(

        modifier=Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        TopBar(title = "Communities",   buttonIcon =Icons.Filled.Menu,onButtonClicked = {openDrawer()})
        StartCommunity()

        Column(
            modifier=Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {

//            if(list)
//            {
                AllCommunities(communityList = communities)
            //AllEvents(eventList = events)
//            }
//                else
//                {
                //Default("My Communities")
                //Default("You are not part of any communities.... Find one you like or create your own!")
                //StartCommunity()
           // }
        }

    }

}


@Composable
fun Events(openDrawer:()->Unit)
{
    Column(

        modifier=Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        TopBar(title = "Events",   buttonIcon =Icons.Filled.Menu,onButtonClicked = {openDrawer()})

        StartEvent()
        //AllEvents(eventList = events)
        Column(
            modifier=Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            AllEvents(eventList = events)
            //AllCommunities(communityList = communities)
        }

    }


}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Friends(openDrawer:()->Unit)
{
    Column(

        modifier=Modifier.fillMaxSize()
    ) {


        TopBar(title = "Friends",   buttonIcon =Icons.Filled.Menu,onButtonClicked = {openDrawer()})


        Column(
            modifier=Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {

//            Default("Your Friends")
//            Default("You have no friends!")
//            //StartCommunity()
            SimpleText7("Add a Friend!")

            // 'Set' onClickListener(?), for locating & adding friend? {crossed my mind}

            AddFriend(" Send Request to:")
            AddedFriendBox()

//            ConfirmFriendsUpdated("Confirm You've Finished Adding Friends")
//            UpdatedFriendsBox()
            //SubmitButton6()

            SimpleText8("Please Submit to Request")
            SubmitButton7()
        }

    }

}