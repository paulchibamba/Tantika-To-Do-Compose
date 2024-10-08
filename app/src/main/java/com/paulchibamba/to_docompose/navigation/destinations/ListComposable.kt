 package com.paulchibamba.to_docompose.navigation.destinations

 import androidx.navigation.NavGraphBuilder
 import androidx.navigation.NavType
 import androidx.navigation.compose.composable
 import androidx.navigation.navArgument
 import com.paulchibamba.to_docompose.ui.screens.list.ListScreen
 import com.paulchibamba.to_docompose.ui.viewmodels.SharedViewmodel
 import com.paulchibamba.to_docompose.util.Constants.LIST_ARGUMENT_KEY
 import com.paulchibamba.to_docompose.util.Constants.LIST_SCREEN

 fun NavGraphBuilder.listComposable(
     navigateToTaskScreen: (taskId: Int) -> Unit,
     sharedViewmodel: SharedViewmodel
 ){
      composable(
          route = LIST_SCREEN,
          arguments = listOf(navArgument( LIST_ARGUMENT_KEY ){
               type = NavType.StringType
          })
      ){
          ListScreen(
              navigateToTaskScreen = navigateToTaskScreen,
              sharedViewmodel = sharedViewmodel
          )

      }
 }