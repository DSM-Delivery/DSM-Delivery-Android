package com.dsm_delivery.navigation

sealed class AppNavigationItem(val route: String) {

    object Splash : AppNavigationItem("splash")

    object Signup : AppNavigationItem("signup")

    object SignIn : AppNavigationItem("signin")

    object Main : AppNavigationItem("main")


}