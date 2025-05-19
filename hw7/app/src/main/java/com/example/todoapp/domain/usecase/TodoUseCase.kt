package com.example.todoapp.domain.usecase

import com.example.todoapp.domain.model.Todo
import com.example.todoapp.data.TodoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class TodoUseCase @Inject constructor(
    private val repository: TodoRepository
) {
    fun getAllTodos(): Flow<List<Todo>> = repository.getAllTodos()

    suspend fun insertTodo(todo: Todo) = repository.insertTodo(todo)

    suspend fun updateTodo(todo: Todo) = repository.updateTodo(todo)

    suspend fun deleteTodo(todo: Todo) = repository.deleteTodo(todo)
}
