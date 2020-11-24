package br.com.kotlincoroutine.data.di

import br.com.kotlincoroutine.BuildConfig.API_TODOS
import br.com.kotlincoroutine.data.repository.remote.api.todos.TodoApi
import br.com.kotlincoroutine.data.repository.remote.todos.TodoRepository
import br.com.kotlincoroutine.domain.repository.todos.ITodoRepository
import org.koin.core.module.Module
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private val networkModule = module {
    single {
        Retrofit.Builder()
            .baseUrl(API_TODOS)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single { get<Retrofit>().create(TodoApi::class.java) }
}

private val dataModule: Module = module {
    single<ITodoRepository> { TodoRepository(get()) }
}

val repositoryModule = listOf(dataModule, networkModule)