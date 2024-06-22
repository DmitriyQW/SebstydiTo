package com.sebstydi.sebstydi.android.presentation.resumeSubmit

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sebstydi.sebstydi.android.R
import com.sebstydi.sebstydi.android.ui.theme.SebstydiTheme
import com.sebstydi.sebstydi.android.ui.theme.poppininsFontFamily
import com.sebstydi.sebstydi.ui.theme.PrimaryBlueMainColor
import com.sebstydi.sebstydi.ui.theme.PrimaryButtonColor
import com.sebstydi.sebstydi.ui.theme.SecondaryBlueMainColor

@Composable
fun ResumSubmitPage() {
    SebstydiTheme {
        Column(modifier = Modifier.fillMaxSize()) {
            Text(
                text = stringResource(id = R.string.resume_send_successfully),
                style = TextStyle(fontSize = 36.sp),
                modifier = Modifier.padding(top = 154.dp, start = 16.dp),
                fontFamily = poppininsFontFamily,
                fontWeight = FontWeight.SemiBold,
                color = Color(PrimaryBlueMainColor)
            )
            Text(
                text = stringResource(id = R.string.days_10),
                style = TextStyle(fontSize = 16.sp),
                modifier = Modifier.padding(top = 10.dp, start = 16.dp),
                fontFamily = poppininsFontFamily,
                fontWeight = FontWeight.SemiBold,
                color = Color(SecondaryBlueMainColor)
            )

            Button(
                onClick = { /* Действие по клику на кнопку */ },
                modifier = Modifier.padding(start = 16.dp, top = 20.dp).size(182.dp, 40.dp),
                colors = ButtonDefaults.buttonColors(Color(PrimaryButtonColor))
            ) {
                Text(text = "Спасибо", fontFamily = poppininsFontFamily, fontWeight = FontWeight.SemiBold, fontSize = 16.sp)
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                horizontalArrangement = Arrangement.End
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_chel_submit),
                    contentDescription = null,
                    modifier = Modifier.size(392.dp, 475.dp)
                )
            }
        }
    }
}
