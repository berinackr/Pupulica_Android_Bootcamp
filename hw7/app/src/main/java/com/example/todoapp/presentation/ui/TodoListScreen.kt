package com.example.todoapp.presentation.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.todoapp.domain.model.Todo
import com.example.todoapp.presentation.TodoViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoListScreen(
    navController: NavController,
    viewModel: TodoViewModel
) {
    val todoList = viewModel.todoList.collectAsState()

    Scaffold(
        topBar = {
            SmallTopAppBar(title = { Text("Yapılacaklar Listesi") })
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate("todo_add_edit")
            }) {
                Text("+")
            }
        }
    ) { paddingValues ->
        LazyColumn(
            contentPadding = paddingValues,
            modifier = Modifier.fillMaxSize()
        ) {
            items(todoList.value) { todo ->
                TodoItemRow(todo = todo, onClick = {
                    navController.navigate("todo_add_edit/${todo.id}")
                })
            }
        }
    }
}

@Composable
fun TodoItemRow(todo: Todo, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = todo.title, style = MaterialTheme.typography.bodyLarge)
        Checkbox(
            checked = todo.isDone,
            onCheckedChange = null
        )
    }
}
