package com.paulchibamba.to_docompose.navigation.destinations

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.paulchibamba.to_docompose.util.Action
import com.paulchibamba.to_docompose.util.Constants
import com.paulchibamba.to_docompose.util.Constants.TASK_SCREEN

fun NavGraphBuilder.taskComposable(
    navigateToListScreen: (Action) -> Unit
){
    composable(
        route = TASK_SCREEN,
        arguments = listOf(navArgument( Constants.TASK_ARGUMENT_KEY ){
            type = NavType.IntType
        })
    ){

    }
}