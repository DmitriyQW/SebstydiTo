package com.sebstydi.sebstydi.android.presentation.addphotoPage

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.sebstydi.sebstydi.android.R
import com.sebstydi.sebstydi.android.ui.theme.SebstydiTheme
import com.sebstydi.sebstydi.android.ui.theme.poppininsFontFamily
import com.sebstydi.sebstydi.ui.theme.BackgroundColor
import com.sebstydi.sebstydi.ui.theme.PrimaryButtonColor

@Composable
fun AddPhotoPage(navController: NavController) {
    SebstydiTheme {
        Box(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .padding(16.dp, top = 40.dp)
                    .align(Alignment.TopStart),
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.Start
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,

                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_arrow_back),
                        contentDescription = null,
                        modifier = Modifier
                            .size(36.dp)
                            .clickable { navController.navigate("main_screen") }
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(
                        text = stringResource(id = R.string.photo_student),
                        modifier = Modifier.padding(start = 8.dp),
                        fontSize = 22.sp,
                        fontFamily = poppininsFontFamily,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            }

            // Центрированные элементы
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_add_photo),
                    contentDescription = null,
                    modifier = Modifier
                        .size(width = 380.dp, height = 339.dp)
                        .clickable { /* Добавить действие на клик */ }
                )

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Button(
                        onClick = { /* Действие по клику на кнопку смены фото */ },
                        modifier = Modifier
                            .padding(end = 8.dp)
                            .weight(1f),
                        colors = ButtonDefaults.buttonColors(Color(PrimaryButtonColor))
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_button_change_photo),
                                contentDescription = null,
                                modifier = Modifier.size(width = 18.dp, height = 18.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = stringResource(id = R.string.change),
                                fontFamily = poppininsFontFamily,
                                fontWeight = FontWeight.SemiBold,
                            )
                        }
                    }

                    Button(
                        onClick = { /* Действие по клику на кнопку удаления фото */ },
                        modifier = Modifier
                            .padding(start = 8.dp)
                            .weight(1f),
                        colors = ButtonDefaults.buttonColors(Color(BackgroundColor)),
                        border = BorderStroke(1.dp, Color(PrimaryButtonColor))
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Image(
                                painter = painterResource(id = R.drawable.ic_button_delete_photo),
                                contentDescription = null,
                                modifier = Modifier.size(width = 18.dp, height = 18.dp)
                            )
                            Spacer(modifier = Modifier.width(8.dp))
                            Text(
                                text = stringResource(id = R.string.delete),
                                color = Color(PrimaryButtonColor),
                                fontFamily = poppininsFontFamily,
                                fontWeight = FontWeight.SemiBold,
                            )
                        }
                    }
                }
            }
        }
    }
}
