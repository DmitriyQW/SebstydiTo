package com.sebstydi.sebstydi.android.presentation.resumeSubmit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sebstydi.sebstydi.android.R
import com.sebstydi.sebstydi.android.ui.theme.SebstydiTheme
import com.sebstydi.sebstydi.android.ui.theme.poppininsFontFamily

class ResumSubmitPage {

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
            Column(modifier = Modifier
                .height(894.dp)
                .width(412.dp)) {
                Text(
                    text = stringResource(id = R.string.resume_send_successfully),
                    style = TextStyle(fontSize = 36.sp),
                    modifier = Modifier.padding(top = 154.dp, start = 16.dp),
                    fontFamily = poppininsFontFamily,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = stringResource(id = R.string.days_10),
                    style = TextStyle(fontSize = 16.sp),
                    modifier = Modifier.padding(top = 10.dp, start = 16.dp, bottom = 115.dp),
                    fontFamily = poppininsFontFamily,
                    fontWeight = FontWeight.SemiBold
                )
                Image(painter = painterResource(id = R.drawable.ic_licho), contentDescription = null,
                    Modifier
                        .height(516.dp)
                        .width(432.dp))
            }
        }
    }

}