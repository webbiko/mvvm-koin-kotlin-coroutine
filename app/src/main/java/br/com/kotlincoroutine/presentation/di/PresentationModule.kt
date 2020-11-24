package br.com.kotlincoroutine.presentation.di

import br.com.kotlincoroutine.presentation.todos.TodoViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module

private val viewModelModule: Module = module {
    viewModel { TodoViewModel(get()) }
}

val presentationModule = listOf(viewModelModule)