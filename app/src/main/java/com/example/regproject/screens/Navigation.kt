package com.example.regproject.screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.regproject.screens.logInScreen.SignInScreen
import com.example.regproject.screens.regScreen.RegScreen

@Composable
fun Navigation(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "signin_screen"){
        composable("reg_screen"){
            RegScreen(navController)
        }
        composable("signin_screen"){
            SignInScreen(navController)
        }
    }
}