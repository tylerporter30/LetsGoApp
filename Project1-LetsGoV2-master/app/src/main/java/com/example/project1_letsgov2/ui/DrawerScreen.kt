package com.example.project1_letsgov2.ui

sealed class DrawerScreen(val title:String, val route:String)
{
    object Profile:DrawerScreen("Profile","updateProfile")
    object Communities:DrawerScreen("Communities","communities")
    object Events:DrawerScreen("Events","events")
    object Friends:DrawerScreen("Friends","friends")


}

val Screens= listOf(
    DrawerScreen.Profile,
    DrawerScreen.Communities,
    DrawerScreen.Events,
    DrawerScreen.Friends



)