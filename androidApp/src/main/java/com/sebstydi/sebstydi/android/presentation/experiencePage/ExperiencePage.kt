package com.sebstydi.sebstydi.android.presentation.experiencePage

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.sebstydi.sebstydi.android.R
import com.sebstydi.sebstydi.android.navigation.NavGraph
import com.sebstydi.sebstydi.android.ui.theme.SebstydiTheme

class ExperiencePage {

    class MainActivity : ComponentActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            enableEdgeToEdge()
            setContent {
                SebstydiTheme {

                }
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        SebstydiTheme {
            Column {
                Text(text = stringResource(id = R.string.give_experience))
                Text(text = stringResource(id = R.string.сomplete_the_internship))
                Image(painter = painterResource(id = R.drawable.ic_button), contentDescription = null)
            }
        }
    }

    }