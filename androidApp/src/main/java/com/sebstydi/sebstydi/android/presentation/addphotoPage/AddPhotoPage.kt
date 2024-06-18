package com.sebstydi.sebstydi.android.presentation.addphotoPage

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.sebstydi.sebstydi.android.R
import com.sebstydi.sebstydi.android.ui.theme.SebstydiTheme

    @Composable
    fun AddPhotoPage(OnClik: () -> Unit) {
        SebstydiTheme {
            Row {
                Image(
                    painter = painterResource(id = R.drawable.ic_button_change_photo),
                    contentDescription = null,
                    Modifier
                        .padding(start = 10.dp, top = 529.dp)
                        .height(40.dp)
                        .width(182.dp)
                )

                Image(
                    painter = painterResource(id = R.drawable.ic_button_delete_photo),
                    contentDescription = null,
                    Modifier
                        .padding(start = 10.dp, top = 529.dp)
                        .height(40.dp)
                        .width(182.dp)
                )
            }

            Column(
                modifier = Modifier
                    .height(894.dp)
                    .width(412.dp)
            ) {

                Image(
                    painter = painterResource(id = R.drawable.ic_add_photo),
                    contentDescription = null,
                    Modifier
                        .padding(start = 16.dp, end = 16.dp, top = 183.dp)
                        .height(339.dp)
                        .width(380.dp)
                )
            }
        }
    }
