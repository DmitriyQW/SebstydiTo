package com.sebstydi.sebstydi.android.presentation.mainActivity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.sebstydi.sebstydi.android.navigation.NavGraph
import com.sebstydi.sebstydi.android.ui.theme.SebstydiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SebstydiTheme {
                val navController = rememberNavController()
                NavGraph(navController)

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SebstydiTheme {

    }
}

