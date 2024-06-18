package com.sebstydi.sebstydi.android.presentation.resumeErrorPage


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sebstydi.sebstydi.android.R
import com.sebstydi.sebstydi.android.ui.theme.SebstydiTheme
import com.sebstydi.sebstydi.android.ui.theme.poppininsFontFamily
import com.sebstydi.sebstydi.ui.theme.PrimaryBlueMainColor
import com.sebstydi.sebstydi.ui.theme.PrimaryButtonColor
import com.sebstydi.sebstydi.ui.theme.SecondaryBlueMainColor

    @Composable
    fun ResumeErrorPreview() {
        SebstydiTheme {
            Column(modifier = Modifier
                .fillMaxSize()) {
                Text(text = stringResource(id = R.string.error), style = TextStyle(fontSize = 30.sp, color = Color(PrimaryBlueMainColor)), modifier = Modifier.padding(top = 80.dp, start = 20.dp), fontFamily = poppininsFontFamily, fontWeight = FontWeight.SemiBold)

                Text(text = stringResource(id = R.string.fill_resume_again_or_error_internet), style = TextStyle(fontSize = 15.sp, color = Color(
                    SecondaryBlueMainColor)), modifier = Modifier.padding(top = 18.dp, start = 20.dp), fontFamily = poppininsFontFamily, fontWeight = FontWeight.SemiBold)

                Button(onClick = {}, modifier = Modifier
                    .padding(top = 25.dp, start = 20.dp)
                    .width(182.dp)
                    .height(40.dp),
                    shape = RoundedCornerShape(100.dp),
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.White, // цвет текста
                        containerColor = Color(PrimaryButtonColor))
                ) {
                    Text(text = stringResource(id = R.string.back), textAlign = TextAlign.Center, style = TextStyle(fontSize = 16.sp), fontFamily = poppininsFontFamily, fontWeight = FontWeight.Bold)
                }

                Image(painter = painterResource(id = R.drawable.error_chel), contentDescription = null,
                    modifier = Modifier
                        .width(500.dp)
                        .height(550.dp))
            }
        }
    }
