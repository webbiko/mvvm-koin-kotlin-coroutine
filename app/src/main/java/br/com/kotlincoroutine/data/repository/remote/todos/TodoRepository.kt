package br.com.kotlincoroutine.data.repository.remote.todos

import br.com.kotlincoroutine.data.repository.BaseRepository
import br.com.kotlincoroutine.data.repository.mappers.todos.toTodo
import br.com.kotlincoroutine.data.repository.remote.api.todos.TodoApi
import br.com.kotlincoroutine.domain.model.todos.Todo
import br.com.kotlincoroutine.domain.repository.todos.ITodoRepository
import kotlinx.coroutines.withContext

class TodoRepository(private val todoApi: TodoApi) : ITodoRepository, BaseRepository() {

    override suspend fun loadTodoList(): List<Todo> = withContext(coroutineContext) {
        val response = todoApi.loadTodoList()

        response.body()?.let { todoResponse ->
            todoResponse.map { it.toTodo() }
        } ?: run {
            throw Exception(response.message())
        }
    }
}