package com.example.todoapp.presentation.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.todoapp.domain.model.Todo
import com.example.todoapp.presentation.TodoViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoAddEditScreen(
    navController: NavController,
    viewModel: TodoViewModel,
    todoId: Int? = null
) {
    var title by remember { mutableStateOf("") }
    var isDone by remember { mutableStateOf(false) }

    // Eğer todoId varsa mevcut veriyi yükle
    LaunchedEffect(todoId) {
        todoId?.let {
            val todo = viewModel.getTodoById(it)
            todo?.let {
                title = it.title
                isDone = it.isDone
            }
        }
    }

    Scaffold(
        topBar = {
            SmallTopAppBar(
                title = { Text(if (todoId == null) "Yeni Yapılacak" else "Yapılacak Düzenle") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Geri")
                    }
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                if (title.isNotBlank()) {
                    if (todoId == null) {
                        // Yeni bir ID oluştur
                        val newId = viewModel.generateNewId()
                        val newTodo = Todo(
                            id = newId,
                            title = title,
                            isDone = isDone
                        )
                        viewModel.addTodo(newTodo)
                    } else {
                        val updatedTodo = Todo(
                            id = todoId,
                            title = title,
                            isDone = isDone
                        )
                        viewModel.updateTodo(updatedTodo)
                    }
                    navController.popBackStack()
                }
            }) {
                Text("Kaydet")
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            OutlinedTextField(
                value = title,
                onValueChange = { title = it },
                label = { Text("Başlık") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = isDone,
                    onCheckedChange = { isDone = it }
                )
                Text(text = "Tamamlandı")
            }
        }
    }
}
