package com.example.taskapp.Tasks.Presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.taskapp.Tasks.Presentation.Tasks.TasksScreen
import com.example.taskapp.Tasks.Presentation.Utility.Screen
import com.example.taskapp.ui.theme.TaskAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TaskAppTheme {
                Surface (
                    color = MaterialTheme.colorScheme.background
                ){
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.TasksScreen.route
                    ){
                        composable(route = Screen.TasksScreen.route){
                            TasksScreen(navController = navController)
                        }
                        composable(
                            route = Screen.AddEditTaskScreen.route + "?taskId={TaskId}",
                            arguments = listOf(
                                navArgument(
                                    name = "taskId"
                                ){
                                    type = NavType.IntType
                                    defaultValue = -1
                                },
                            )
                        ){
                        }
                    }
                }
            }
        }
    }
}
