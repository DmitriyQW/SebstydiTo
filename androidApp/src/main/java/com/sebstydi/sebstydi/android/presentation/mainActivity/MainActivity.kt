package com.sebstydi.sebstydi.android.presentation.mainActivity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.sebstydi.sebstydi.android.R
import com.sebstydi.sebstydi.android.navigation.NavGraph
import com.sebstydi.sebstydi.android.ui.theme.SebstydiTheme
import com.sebstydi.sebstydi.android.ui.theme.poppininsFontFamily
import com.sebstydi.sebstydi.domain.models.resume.values.*
import com.sebstydi.sebstydi.presentation.resume.state.ResumeEvent
import com.sebstydi.sebstydi.ui.theme.BackgroundColor
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
            .padding(top = 50.dp, bottom = 40.dp, start = 10.dp, end = 10.dp)
            .verticalScroll(rememberScrollState())
    ) {
        Row(
            modifier = Modifier.padding(bottom = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_vector),
                contentDescription = "Your Photo",
                modifier = Modifier.size(20.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = stringResource(id = R.string.fill_resume),
                modifier = Modifier.weight(1f),
                fontSize = 24.sp,
                color = Color(PrimaryBlueMainColor),
                fontFamily = poppininsFontFamily,
                fontWeight = FontWeight.SemiBold
            )
        }

        Text(stringResource(id = R.string.for_contact),
            modifier = Modifier.padding( top = 10.dp, bottom = 10.dp),
            fontSize = 20.sp,
            fontFamily = poppininsFontFamily,
            fontWeight = FontWeight.SemiBold
        )

        CustomPhotoPickerField(navController = navController)

        Text(
            text = stringResource(id = R.string.optional_field),
            modifier = Modifier.padding(start = 8.dp, top = 4.dp),
            fontSize = 14.sp,
            color = Color(SecondaryBlueMainColor),
            fontFamily = poppininsFontFamily,
            fontWeight = FontWeight.SemiBold
        )

        // Поля формы
        OutlinedTextField(
            value = state.firstNameError?.value ?: "",
            onValueChange = { viewModel.onEvent(ResumeEvent.OnFirstNameChanged(FirstName(it))) },
            label = { Text(stringResource(id = R.string.firstname), fontFamily = poppininsFontFamily,
                fontWeight = FontWeight.SemiBold) },
            isError = state.firstNameError != null,
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp, bottom = 8.dp)
        )

        OutlinedTextField(
            value = state.lastNameError?.value ?: "",
            onValueChange = { viewModel.onEvent(ResumeEvent.OnLastNameChanged(LastName(it))) },
            label = { Text(stringResource(id = R.string.lastname), fontFamily = poppininsFontFamily,
                fontWeight = FontWeight.SemiBold) },
            isError = state.lastNameError != null,
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )

        OutlinedTextField(
            value = state.midleNameError?.value ?: "",
            onValueChange = { viewModel.onEvent(ResumeEvent.OnMidleNameChanged(MidleName(it))) },
            label = { Text(stringResource(id = R.string.midlename), fontFamily = poppininsFontFamily,
                fontWeight = FontWeight.SemiBold) },
            isError = state.midleNameError != null,
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
        )

        OutlinedTextField(
            value = state.phoneNumberError?.value ?: "",
            onValueChange = { viewModel.onEvent(ResumeEvent.OnPhoneNumberChanged(PhoneNumber(it))) },
            label = { Text(stringResource(id = R.string.phonenumber), fontFamily = poppininsFontFamily,
                fontWeight = FontWeight.SemiBold) },
            isError = state.phoneNumberError != null,
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 6.dp)
        )

        // Выпадающий список для выбора учебного заведения
        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)) {
            OutlinedTextField(
                value = selectedUniversity,
                onValueChange = {},
                readOnly = true,
                label = { Text(stringResource(id = R.string.education), fontFamily = poppininsFontFamily,
                    fontWeight = FontWeight.SemiBold) },
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
                modifier = Modifier
                    .fillMaxWidth()
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

        Text(stringResource(id = R.string.about_you),
            modifier = Modifier.padding( top = 10.dp, bottom = 10.dp),
            fontSize = 20.sp,
            fontFamily = poppininsFontFamily,
            fontWeight = FontWeight.SemiBold
        )

        // Поле "Расскажи о себе"
        OutlinedTextField(
            value = state.aboutMe?.value ?: "",
            onValueChange = { viewModel.onEvent(ResumeEvent.OnAboutMeChanged(AboutMe(it))) },
            label = { Text(stringResource(id = R.string.about_you_hint), fontFamily = poppininsFontFamily,
                fontWeight = FontWeight.SemiBold) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
                .height(100.dp)
        )

        Text(stringResource(id = R.string.direction),
            modifier = Modifier.padding( top = 10.dp, bottom = 10.dp),
            fontSize = 20.sp,
            fontFamily = poppininsFontFamily,
            fontWeight = FontWeight.SemiBold
        )

        // Выпадающий список для выбора направления
        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp)
            .padding(vertical = 8.dp)) {
            OutlinedTextField(
                value = selectedDirection,
                onValueChange = {},
                readOnly = true,
                label = { Text(stringResource(id = R.string.direction_hint)) },
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
                modifier = Modifier
                    .fillMaxWidth()
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

        Text(stringResource(id = R.string.about_project),
            modifier = Modifier.padding( top = 10.dp, bottom = 10.dp),
            fontSize = 20.sp,
            fontFamily = poppininsFontFamily,
            fontWeight = FontWeight.SemiBold
        )

        OutlinedTextField(
            value = state.aboutProjects?.value ?: "",
            onValueChange = { viewModel.onEvent(ResumeEvent.OnAboutProjectChanged(AboutProjects(it))) },
            label = { Text(stringResource(id = R.string.about_project_hint), fontFamily = poppininsFontFamily,
                fontWeight = FontWeight.SemiBold) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp)
                .height(100.dp)
        )

        Text(stringResource(id = R.string.hard_skills),
            modifier = Modifier.padding( top = 10.dp, bottom = 10.dp),
            fontSize = 20.sp,
            fontFamily = poppininsFontFamily,
            fontWeight = FontWeight.SemiBold
            )

        Row(verticalAlignment = Alignment.CenterVertically) {
            if (!isAddingSkill) {
                IconButton(
                    onClick = { isAddingSkill = true },
                    modifier = Modifier
                        .size(40.dp)
                        .background(
                            color = Color(PrimaryButtonColor),
                            RoundedCornerShape(15.dp)
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
                    label = { Text(stringResource(id = R.string.hard_skills_hint), fontFamily = poppininsFontFamily,
                        fontWeight = FontWeight.SemiBold) },
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 10.dp),
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
                            RoundedCornerShape(15.dp)
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
                        .border(
                            1.dp,
                            Color(SecondaryBlueMainColor),
                            shape = RoundedCornerShape(8.dp)
                        )
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

        Text(stringResource(id = R.string.link_to_portfolio),
            modifier = Modifier.padding( top = 10.dp, bottom = 8.dp),
            fontSize = 20.sp,
            fontFamily = poppininsFontFamily,
            fontWeight = FontWeight.SemiBold
        )

        OutlinedTextField(
            value = state.portfolio?.link ?: "",
            onValueChange = { viewModel.onEvent(ResumeEvent.OnPortfolioChanged(Portfolio(it))) },
            label = { Text(stringResource(id = R.string.link_to_portfolio_hint), fontFamily = poppininsFontFamily,
                fontWeight = FontWeight.SemiBold) },
            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
            modifier = Modifier
                .fillMaxWidth()
        )

        Text(
            text = stringResource(id = R.string.optional_field),
            fontSize = 14.sp,
            color = Color(SecondaryBlueMainColor),
            fontFamily = poppininsFontFamily,
            fontWeight = FontWeight.SemiBold
        )

        Button(
            onClick = { navController.navigate("submit_resume") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 10.dp, bottom = 8.dp),
            colors = ButtonDefaults.buttonColors(Color(PrimaryButtonColor)),
        ) {
            Text(
                stringResource(id = R.string.send_resume),
                fontFamily = poppininsFontFamily,
                fontWeight = FontWeight.SemiBold,
                color = Color(BackgroundColor)
            )
        }

        Text(
            text = stringResource(id = R.string.information_transfer),
            fontSize = 14.sp,
            fontFamily = poppininsFontFamily,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
fun CustomPhotoPickerField(navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(Color.Transparent)
            .border(1.dp, Color.Gray, shape = RoundedCornerShape(4.dp))
            .clickable { navController.navigate("add_photo") }
            .padding(16.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Text(
            text = stringResource(id = R.string.add_your_photo),
            fontFamily = poppininsFontFamily,
            fontWeight = FontWeight.SemiBold,
            color = Color.Gray
        )
        Box(
            modifier = Modifier.align(Alignment.CenterEnd)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_load_photo),
                contentDescription = null,
                modifier = Modifier.size(40.dp)
            )
        }
    }
}
