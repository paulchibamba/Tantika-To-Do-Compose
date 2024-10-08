package com.paulchibamba.to_docompose.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.paulchibamba.to_docompose.navigation.destinations.listComposable
import com.paulchibamba.to_docompose.navigation.destinations.taskComposable
import com.paulchibamba.to_docompose.ui.viewmodels.SharedViewmodel
import com.paulchibamba.to_docompose.util.Constants.LIST_SCREEN

@Composable
fun SetupNavigation(navController: NavHostController, sharedViewmodel: SharedViewmodel) {

    val screen = remember(navController) {
        Screens(navController)
    }

    NavHost(navController = navController,
        startDestination = LIST_SCREEN
    ){
        listComposable(
            navigateToTaskScreen = screen.task,
            sharedViewmodel = sharedViewmodel
        )
        taskComposable(navigateToListScreen = screen.list)
    }
}