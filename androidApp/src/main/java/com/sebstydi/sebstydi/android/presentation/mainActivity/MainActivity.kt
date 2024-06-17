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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
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

@OptIn(ExperimentalMaterial3Api::class)
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
    var showSkillInput by remember { mutableStateOf(false) }
    var selectedImageUri by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState())
    ) {
        // Приветственное сообщение и фото
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = R.drawable.ic_vector),
                contentDescription = "Фото пользователя",
                modifier = Modifier
                    .size(80.dp)
                    .border(2.dp, MaterialTheme.colorScheme.primary)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = "Привет! Заполни резюме",
                modifier = Modifier.padding(bottom = 16.dp)
            )
        }

        // Поле для добавления фото
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(80.dp)
                .background(Color.LightGray)
                .clickable { /* Обработка нажатия для выбора фото */ },
            contentAlignment = Alignment.Center
        ) {
            if (selectedImageUri == null) {
                Text("Добавьте свое фото", color = Color.White)
            } else {
                Image(
                    painter = painterResource(id = R.drawable.ic_load_photo), // Замените на выбранное фото
                    contentDescription = "Фото пользователя",
                    modifier = Modifier.size(80.dp)
                )
            }
        }

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
        // Секция для Hard Skills
        Column(modifier = Modifier.fillMaxWidth()) {
            if (showSkillInput) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    OutlinedTextField(
                        value = newSkill,
                        onValueChange = { newSkill = it },
                        label = { Text("Добавить навык") },
                        modifier = Modifier
                            .weight(1f)
                            .padding(vertical = 8.dp),
                        keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                        singleLine = true
                    )
                    IconButton(onClick = {
                        if (newSkill.isNotBlank()) {
                            hardSkills.add(newSkill)
                            newSkill = ""
                            showSkillInput = false
                        }
                    }) {
                        Icon(imageVector = Icons.Default.Add, contentDescription = "Добавить")
                    }
                    IconButton(onClick = { showSkillInput = false }) {
                        Icon(imageVector = Icons.Default.Clear, contentDescription = "Отменить")
                    }
                }
            } else {
                IconButton(
                    onClick = { showSkillInput = true },
                    modifier = Modifier
                        .size(48.dp)
                        .background(
                            MaterialTheme.colorScheme.primary,
                            shape = MaterialTheme.shapes.small
                        )
                ) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = "Добавить", tint = Color.White)
                }
            }

            Row(
                modifier = Modifier
                    .padding(vertical = 8.dp)
                    .horizontalScroll(rememberScrollState())
            ) {
                hardSkills.forEachIndexed { index, skill ->
                    Box(
                        modifier = Modifier
                            .background(MaterialTheme.colorScheme.primary.copy(alpha = 0.1f))
                            .padding(8.dp)
                            .border(1.dp, MaterialTheme.colorScheme.primary)
                            .padding(end = 8.dp)
                            .padding(horizontal = 8.dp, vertical = 4.dp)
                    ) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(skill, color = MaterialTheme.colorScheme.primary)
                            Spacer(modifier = Modifier.width(8.dp))
                            IconButton(
                                onClick = { hardSkills.removeAt(index) },
                                modifier = Modifier.size(16.dp)
                            ) {
                                Icon(imageVector = Icons.Default.Clear, contentDescription = "Удалить навык")
                            }
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
            onClick = {
                viewModel.onEvent(ResumeEvent.OnClickSendResume)
                val skills = Skills(hardSkills.map { Skill(it) })
                // Сохранение навыков в объект
            },
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
