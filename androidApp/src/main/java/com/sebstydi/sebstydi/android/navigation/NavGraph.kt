package com.sebstydi.sebstydi.android.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sebstydi.sebstydi.android.presentation.mainActivity.MainActivity
import com.sebstydi.sebstydi.android.presentation.mainActivity.MainScreen
import com.sebstydi.sebstydi.android.presentation.startPage.StartScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController, startDestination = "start_screen") {
        composable("start_screen") {
            StartScreen(navController)
        }
        composable("main_screen") {
            MainScreen(navController)
        }
    }
}
