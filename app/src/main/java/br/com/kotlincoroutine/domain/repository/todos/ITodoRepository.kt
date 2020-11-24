package br.com.kotlincoroutine.domain.repository.todos

import br.com.kotlincoroutine.domain.model.todos.Todo

interface ITodoRepository {

    suspend fun loadTodoList(): List<Todo>
}