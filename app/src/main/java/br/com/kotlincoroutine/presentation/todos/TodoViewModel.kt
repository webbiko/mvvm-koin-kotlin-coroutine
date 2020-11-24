package br.com.kotlincoroutine.presentation.todos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import br.com.kotlincoroutine.domain.model.todos.Todo
import br.com.kotlincoroutine.domain.repository.todos.ITodoRepository
import br.com.kotlincoroutine.presentation.common.BaseViewModel
import br.com.kotlincoroutine.utils.Event
import kotlinx.coroutines.launch

class TodoViewModel(private val todoRepository: ITodoRepository) : BaseViewModel() {

    private val _todoSuccess = MutableLiveData<Event<List<Todo>>>()
    val todoSuccess: LiveData<Event<List<Todo>>> = _todoSuccess

    private val _todoEmpty = MutableLiveData<Event<Unit>>()
    val todoEmpty: LiveData<Event<Unit>> = _todoEmpty

    private val _todoError = MutableLiveData<Event<String>>()
    val todoError: LiveData<Event<String>> = _todoError

    fun loadTodoList() {
        launch {
            try {
                val todos = todoRepository.loadTodoList()
                if (todos.isEmpty()) {
                    _todoEmpty.value = Event(Unit)
                } else {
                    _todoSuccess.value = Event(todos)
                }
            } catch (exception: Exception) {
                _todoError.value = Event(exception.localizedMessage)
            }
        }
    }
}