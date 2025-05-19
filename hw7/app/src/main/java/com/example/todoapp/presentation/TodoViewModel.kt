package com.example.todoapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todoapp.domain.model.Todo
import com.example.todoapp.domain.usecase.TodoUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TodoViewModel @Inject constructor(
    private val todoUseCase: TodoUseCase
) : ViewModel() {

    private val _todoList = MutableStateFlow<List<Todo>>(emptyList())
    val todoList: StateFlow<List<Todo>> = _todoList

    init {
        loadTodos()
    }

    private fun loadTodos() {
        todoUseCase.getAllTodos()
            .onEach { todos ->
                _todoList.value = todos
            }
            .launchIn(viewModelScope)
    }

    fun addTodo(todo: Todo) {
        viewModelScope.launch {
            todoUseCase.insertTodo(todo)
        }
    }

    fun updateTodo(todo: Todo) {
        viewModelScope.launch {
            todoUseCase.updateTodo(todo)
        }
    }

    fun deleteTodo(todo: Todo) {
        viewModelScope.launch {
            todoUseCase.deleteTodo(todo)
        }
    }

    // Eksik olan fonksiyonlar:
    fun getTodoById(id: Int): Todo? {
        return _todoList.value.find { it.id == id }
    }

    fun generateNewId(): Int {
        return (_todoList.value.maxOfOrNull { it.id } ?: 0) + 1
    }
}

