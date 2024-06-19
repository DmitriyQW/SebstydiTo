package com.sebstydi.sebstydi.android.presentation.experiencePage

    import androidx.compose.foundation.Image
    import androidx.compose.foundation.layout.Column
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


    @Composable
    fun ExperiencePage(OnClik: () -> Unit) {
        SebstydiTheme {
            Column(modifier = Modifier
                .height(894.dp)
                .width(412.dp)) {
                Text(text = stringResource(id = R.string.give_experience), style = TextStyle(fontSize = 36.sp), modifier = Modifier.padding(top = 154.dp, start = 16.dp), fontFamily = poppininsFontFamily, fontWeight = FontWeight.SemiBold)
                Text(text = stringResource(id = R.string.сomplete_the_internship), style = TextStyle(fontSize = 16.sp), modifier = Modifier.padding(top = 10.dp, start = 16.dp), fontFamily = poppininsFontFamily, fontWeight = FontWeight.SemiBold)

                Button(onClick = {OnClik()}, modifier = Modifier
                    .padding(start = 16.dp,top = 22.dp)
                    .width(182.dp)
                    .width(40.dp)
                    ,shape = RoundedCornerShape(12.dp),
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.White, // цвет текста
                        containerColor = Color.Black)) { // цвет кнопки
                    Text(text = stringResource(id = R.string.get_on_the_team),textAlign = TextAlign.Center, style = TextStyle(fontSize = 14.sp), fontFamily = poppininsFontFamily, fontWeight = FontWeight.Medium)
                }

                Image(painter = painterResource(id = R.drawable.ic_licho), contentDescription = null,
                    Modifier
                        .height(516.dp)
                        .width(505.dp)
                        .padding(start = 111.dp, top = 162.dp))
            }
        }
    }