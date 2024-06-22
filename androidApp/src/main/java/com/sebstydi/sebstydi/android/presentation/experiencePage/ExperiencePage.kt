package com.sebstydi.sebstydi.android.presentation.experiencePage

    import androidx.compose.foundation.Image
    import androidx.compose.foundation.layout.Box
    import androidx.compose.foundation.layout.Column
    import androidx.compose.foundation.layout.fillMaxSize
    import androidx.compose.foundation.layout.fillMaxWidth
    import androidx.compose.foundation.layout.height
    import androidx.compose.foundation.layout.offset
    import androidx.compose.foundation.layout.padding
    import androidx.compose.foundation.layout.size
    import androidx.compose.foundation.layout.width
    import androidx.compose.foundation.shape.RoundedCornerShape
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
fun ExperiencePage(OnClick: () -> Unit) {
    SebstydiTheme {
        Box(modifier = Modifier.fillMaxSize().padding(bottom = 20.dp)) {
            // Изображение на заднем плане
            Image(
                painter = painterResource(id = R.drawable.ic_licho),
                contentDescription = null,
                modifier = Modifier
                    .size(400.dp, 400.dp)
                    .padding(bottom = 10.dp)
                    .align(Alignment.BottomEnd)
                    .offset(x = 45.dp, y = 0.dp)
            )

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 16.dp, top = 154.dp)
            ) {
                Text(
                    text = "Получить важный experience?",
                    style = TextStyle(fontSize = 64.sp),
                    fontFamily = poppininsFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(PrimaryBlueMainColor)
                )
                Text(
                    text = stringResource(id = R.string.сomplete_the_internship),
                    style = TextStyle(fontSize = 16.sp),
                    modifier = Modifier
                        .padding(top = 10.dp)
                        .fillMaxWidth(0.5f), // Ограничиваем ширину текста половиной экрана
                    fontFamily = poppininsFontFamily,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(PrimaryButtonColor)
                )

                Button(
                    onClick = { OnClick() },
                    modifier = Modifier
                        .padding(top = 22.dp)
                        .width(182.dp)
                        .height(40.dp),
                    shape = RoundedCornerShape(25.dp),
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.White, // цвет текста
                        containerColor = Color(PrimaryButtonColor) // цвет кнопки
                    )
                ) {
                    Text(
                        text = "Перейти к резюме",
                        textAlign = TextAlign.Center,
                        style = TextStyle(fontSize = 14.sp),
                        fontFamily = poppininsFontFamily,
                        fontWeight = FontWeight.Medium
                    )
                }
            }
        }
    }
}
