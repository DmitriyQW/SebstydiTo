package com.sebstydi.sebstydi.android.di

import com.sebstydi.sebstydi.android.presentation.startPage.viewModel.StartViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { StartViewModel() }
}