package com.sebstydi.sebstydi.android.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sebstydi.sebstydi.android.presentation.mainActivity.MainActivity
import com.sebstydi.sebstydi.android.presentation.startPage.StartScreen
import com.sebstydi.sebstydi.android.presentation.startPage.viewModel.StartViewModel

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController, startDestination = "start_screen") {
        composable("start_screen") {
            StartScreen(navController)
        }
        composable("main_activity") {
            MainActivity()
        }
    }
}
