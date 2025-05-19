package com.example.todoapp.presentation

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.todoapp.presentation.ui.TodoAddEditScreen
import com.example.todoapp.presentation.ui.TodoListScreen

@Composable
fun TodoApp() {
    val navController = rememberNavController()

    MaterialTheme {
        Surface {
            NavHost(
                navController = navController,
                startDestination = "todo_list"
            ) {
                composable("todo_list") {
                    TodoListScreen(
                        navController = navController,
                        viewModel = hiltViewModel()
                    )
                }
                composable("todo_add_edit/{todoId?}") { backStackEntry ->
                    val todoId = backStackEntry.arguments?.getString("todoId")?.toIntOrNull()
                    TodoAddEditScreen(
                        navController = navController,
                        todoId = todoId,
                        viewModel = hiltViewModel()
                    )
                }

            }
        }
    }
}
