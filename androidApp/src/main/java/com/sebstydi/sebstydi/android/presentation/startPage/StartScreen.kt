package com.sebstydi.sebstydi.android.presentation.startPage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.sebstydi.sebstydi.android.R
import com.sebstydi.sebstydi.android.presentation.startPage.viewModel.StartViewModel
import com.sebstydi.sebstydi.presentation.startPage.state.StartEffect
import com.sebstydi.sebstydi.ui.theme.PrimaryBlueMainColor
import org.koin.androidx.compose.koinViewModel

@Composable
fun StartScreen(navController: NavController, viewModel: StartViewModel = koinViewModel()) {
    val state = viewModel.state.collectAsState()

    LaunchedEffect(key1 = true) {
        viewModel.effect.collect { effect ->
            when (effect) {
                StartEffect.NavigateToNextScreen -> {
                    navController.navigate("main_screen")
                }
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(PrimaryBlueMainColor))
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = null,
                modifier = Modifier.size(300.dp, 280.dp)
//                    .padding(bottom = 105.dp)
            )
        }

        Box(
            modifier = Modifier
                .align(Alignment.BottomEnd)
                .padding(start = 135.dp, bottom = 40.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_hand),
                contentDescription = null,
                modifier = Modifier.size(350.dp, 350.dp)
            )
        }
    }
}