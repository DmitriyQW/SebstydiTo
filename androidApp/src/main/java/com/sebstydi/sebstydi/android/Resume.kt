package com.sebstydi.sebstydi.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sebstydi.sebstydi.android.ui.theme.SebstydiTheme

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SebstydiTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                   Greeting(name = "Android", modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    val scrollState = rememberScrollState()

    Column( modifier = Modifier
        .verticalScroll(state = scrollState)) {
        Column {
            Text(
                text = "Заполни резюме"
            )
            Text(
                text = "Для связи"
            )
        }

        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            TextField(value = "Добавьте свое фото", onValueChange = {})
            Text(text = "Необязательное поле")
            TextField(value = "Имя", onValueChange = {})
            TextField(value = "Фамилия", onValueChange = {})
            TextField(value = "Отчество", onValueChange = {})
            TextField(value = "+7 (000) (000) 22 22", onValueChange = {})
            TextField(value = "Учебное заведение", onValueChange = {})
            Column {
                Text(text = "Расскажи о себе")
                TextField(value = "Возможно, у тебя есть хобби, напиши о них или о своих личных качествах", onValueChange = {})
            }
            Column {
                Text(text = "Твое направление")
                TextField(value = "Выбери из списка", onValueChange = {})
            }
            Column {
                Text(text = "О проектах")
                TextField(value = "Какие проекты у вас были? \n" +
                        "Чем вы занимались?\n" +
                        "Как вы планируете свою работу?", onValueChange = {})
            }
            Column {
                Text(text = "Hard Skills")
                TextField(value = "Напишите навык", onValueChange = {})
            }
            Column {
                Text(text = "Ссылка на портфолио")
                TextField(value = "Прикрепите ссылку на гитхаб или беханс", onValueChange = {})
            }
        }



        Button(onClick = { /*TODO*/ }) {
            Text(text = "Отправить резюме")
        }
        Text(text = "Заполняя форму, я принимаю условия передачи информации")
    }

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SebstydiTheme {
        Greeting("Android")
    }
}
