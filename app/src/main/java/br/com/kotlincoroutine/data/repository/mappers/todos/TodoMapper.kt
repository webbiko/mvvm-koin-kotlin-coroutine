package br.com.kotlincoroutine.data.repository.mappers.todos

import br.com.kotlincoroutine.data.repository.model.todos.TodoResponse
import br.com.kotlincoroutine.domain.model.todos.Todo

fun TodoResponse.toTodo(): Todo = Todo(this.id, this.task)


fun String.printMyName() = println("Wagner")