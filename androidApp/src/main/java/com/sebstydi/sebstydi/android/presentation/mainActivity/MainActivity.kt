package com.sebstydi.sebstydi.android.presentation.mainActivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.sebstydi.sebstydi.android.R
import com.sebstydi.sebstydi.android.navigation.NavGraph
import com.sebstydi.sebstydi.android.ui.theme.SebstydiTheme
import com.sebstydi.sebstydi.domain.models.resume.values.*
import com.sebstydi.sebstydi.presentation.resume.state.ResumeEvent
import com.sebstydi.sebstydi.ui.theme.PrimaryBlueMainColor
import com.sebstydi.sebstydi.ui.theme.PrimaryButtonColor
import com.sebstydi.sebstydi.ui.theme.SecondaryBlueMainColor

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SebstydiTheme {
                val navController = rememberNavController()
                NavGraph(navController)
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun MainScreen(navController: NavHostController, viewModel: ResumeViewModel = viewModel()) {
    val state by viewModel.state.collectAsState()
    var expandedUniversity by remember { mutableStateOf(false) }
    var selectedUniversity by remember { mutableStateOf("") }
    var expandedDirection by remember { mutableStateOf(false) }
    var selectedDirection by remember { mutableStateOf("") }
    val universityOptions = listOf("РКСТ", "ДГТУ", "РИНХ", "РАНХиГС")
    val directionOptions = listOf("frontend", "backend", "mobile", "дизайн")
    val hardSkills = remember { mutableStateListOf<String>() }
    var newSkill by remember { mutableStateOf("") }
    var isAddingSkill by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        // Приветственное сообщение
        Text(
            text = "Привет! Заполни резюме",
            modifier = Modifier.padding(bottom = 16.dp)
        )

        // Поле для добавления фото
        OutlinedTextField(
            value = "",
            onValueChange = {},
            label = { Text("Добавьте свое фото") },
            modifier = Modifier
                .fillMaxWidth()
                .clickable { /* Обработка нажатия для выбора фото */ },
            readOnly = true,
            trailingIcon = {
                Image(
                    painter = painterResource(id = R.drawable.ic_load_photo),
                    contentDescription = null,
                    modifier = Modifier
                        .size(40.dp)
                        .clickable { /* Обработка нажатия для выбора фото */ }
                )
            }
        )

        Text(
            text = "Это необязательное поле",
            modifier = Modifier.padding(start = 16.dp, top = 4.dp, bottom = 16.dp)
        )

        // Поля формы
        OutlinedTextField(
            value = state.firstNameError?.value ?: "",
            onValueChange = { viewModel.onEvent(ResumeEvent.OnFirstNameChanged(FirstName(it))) },
            label = { Text("Имя") },
            isError = state.firstNameError != null,
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = state.lastNameError?.value ?: "",
            onValueChange = { viewModel.onEvent(ResumeEvent.OnLastNameChanged(LastName(it))) },
            label = { Text("Фамилия") },
            isError = state.lastNameError != null,
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = state.midleNameError?.value ?: "",
            onValueChange = { viewModel.onEvent(ResumeEvent.OnMidleNameChanged(MidleName(it))) },
            label = { Text("Отчество") },
            isError = state.midleNameError != null,
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = state.phoneNumberError?.value ?: "",
            onValueChange = { viewModel.onEvent(ResumeEvent.OnPhoneNumberChanged(PhoneNumber(it))) },
            label = { Text("Номер телефона") },
            isError = state.phoneNumberError != null,
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            modifier = Modifier.fillMaxWidth()
        )

        // Выпадающий список для выбора учебного заведения
        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)) {
            OutlinedTextField(
                value = selectedUniversity,
                onValueChange = {},
                readOnly = true,
                label = { Text("Учебное заведение") },
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { expandedUniversity = true },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedUniversity)
                }
            )
            DropdownMenu(
                expanded = expandedUniversity,
                onDismissRequest = { expandedUniversity = false },
                modifier = Modifier.fillMaxWidth()
            ) {
                universityOptions.forEach { option ->
                    DropdownMenuItem(
                        text = { Text(option) },
                        onClick = {
                            selectedUniversity = option
                            expandedUniversity = false
                        }
                    )
                }
            }
        }

        // Поле "Расскажи о себе"
        OutlinedTextField(
            value = state.aboutMe?.value ?: "",
            onValueChange = { viewModel.onEvent(ResumeEvent.OnAboutMeChanged(AboutMe(it))) },
            label = { Text("Расскажи о себе") },
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
        )

        // Выпадающий список для выбора направления
        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)) {
            OutlinedTextField(
                value = selectedDirection,
                onValueChange = {},
                readOnly = true,
                label = { Text("Направление") },
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable { expandedDirection = true },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandedDirection)
                }
            )
            DropdownMenu(
                expanded = expandedDirection,
                onDismissRequest = { expandedDirection = false },
                modifier = Modifier.fillMaxWidth()
            ) {
                directionOptions.forEach { option ->
                    DropdownMenuItem(
                        text = { Text(option) },
                        onClick = {
                            selectedDirection = option
                            expandedDirection = false
                        }
                    )
                }
            }
        }

        OutlinedTextField(
            value = state.aboutProjects?.value ?: "",
            onValueChange = { viewModel.onEvent(ResumeEvent.OnAboutProjectChanged(AboutProjects(it))) },
            label = { Text("Расскажи о своих проектах") },
            modifier = Modifier
                .fillMaxWidth()
                .height(100.dp)
        )

        Text("Hard Skills")

        Row(verticalAlignment = Alignment.CenterVertically) {
            if (!isAddingSkill) {
                IconButton(
                    onClick = { isAddingSkill = true },
                    modifier = Modifier
                        .size(40.dp)
                        .background(
                            color = Color(PrimaryButtonColor),
                            shape = CircleShape
                        )
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Добавить навык",
                        tint = Color.White
                    )
                }
            } else {
                // Текстовое поле для ввода навыка
                OutlinedTextField(
                    value = newSkill,
                    onValueChange = { newSkill = it },
                    label = { Text("Напишите навык") },
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 8.dp),
                    keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                    singleLine = true,
                    trailingIcon = {
                        IconButton(onClick = {
                            newSkill = ""
                            isAddingSkill = false
                        }) {
                            Icon(imageVector = Icons.Default.Close, contentDescription = "Закрыть")
                        }
                    }
                )
                IconButton(
                    onClick = {
                        if (newSkill.isNotBlank()) {
                            hardSkills.add(newSkill)
                            newSkill = ""
                            isAddingSkill = false
                        }
                    },
                    modifier = Modifier
                        .size(32.dp)
                        .background(
                            color = Color(PrimaryButtonColor),
                            shape = CircleShape
                        )
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Добавить",
                        tint = Color.White
                    )
                }
            }
        }

        // Отображение добавленных скиллов в строке
        FlowRow(
            modifier = Modifier.padding(top = 8.dp),
        ) {
            hardSkills.forEach { skill ->
                Box(
                    modifier = Modifier
                        .background(Color.White)
                        .border(1.dp, Color(SecondaryBlueMainColor), shape = RoundedCornerShape(8.dp))
                        .padding(horizontal = 8.dp, vertical = 4.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .wrapContentWidth(Alignment.Start),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(skill, color = Color.Black)
                        Spacer(modifier = Modifier.width(8.dp))
                        IconButton(
                            onClick = { hardSkills.remove(skill) },
                            modifier = Modifier.size(24.dp)
                        ) {
                            Icon(
                                imageVector = Icons.Default.Close,
                                contentDescription = "Удалить",
                                tint = Color(PrimaryButtonColor)
                            )
                        }
                    }
                }
            }
        }

        OutlinedTextField(
            value = state.portfolio?.link ?: "",
            onValueChange = { viewModel.onEvent(ResumeEvent.OnPortfolioChanged(Portfolio(it))) },
            label = { Text("Ссылка на GitHub") },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = { viewModel.onEvent(ResumeEvent.OnClickSendResume) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Отправить резюме")
        }

        Text(
            text = "Заполняя формы вы принимаете условия конфиденциальности",
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}
