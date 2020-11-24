package br.com.kotlincoroutine.data.repository.remote.api.todos

import br.com.kotlincoroutine.data.repository.model.todos.TodoResponse
import retrofit2.Response
import retrofit2.http.GET

interface TodoApi {

    @GET("/todos")
    suspend fun loadTodoList(): Response<List<TodoResponse>>
}