package com.sebstydi.sebstydi.android.navigation

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.sebstydi.sebstydi.android.presentation.addphotoPage.AddPhotoPage
import com.sebstydi.sebstydi.android.presentation.experiencePage.ExperiencePage
import com.sebstydi.sebstydi.android.presentation.mainActivity.MainActivity
import com.sebstydi.sebstydi.android.presentation.mainActivity.MainScreen
import com.sebstydi.sebstydi.android.presentation.resumeErrorPage.ResumeErrorPreview
import com.sebstydi.sebstydi.android.presentation.resumeSubmit.ResumSubmitPage
import com.sebstydi.sebstydi.android.presentation.startPage.StartScreen

@SuppressLint("ComposableDestinationInComposeScope")
@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController, startDestination = "start_screen") {
        composable("start_screen") {
            StartScreen(navController)
        }
        composable("main_screen") {
            MainScreen(navController)
        }
        composable("experiencePage") {
            ExperiencePage {
                navController.navigate("main_screen")
            }
        }
        composable("submit_resume") {
            ResumeErrorPreview(navController)
        }
        composable("add_photo") {
            AddPhotoPage(navController)
        }
    }
}