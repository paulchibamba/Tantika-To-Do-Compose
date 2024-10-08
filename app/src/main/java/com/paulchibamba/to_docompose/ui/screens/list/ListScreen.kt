package com.paulchibamba.to_docompose.ui.screens.list

import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.paulchibamba.to_docompose.R
import com.paulchibamba.to_docompose.ui.viewmodels.SharedViewmodel
import com.paulchibamba.to_docompose.util.SearchAppBarState

const val TAG = "ListScreen"
@Composable
fun ListScreen(
    navigateToTaskScreen: (Int) -> Unit,
    sharedViewmodel: SharedViewmodel
) {

    LaunchedEffect(key1 = true) {
        sharedViewmodel.getAllTasks()
    }

    val allTasks by sharedViewmodel.allTasks.collectAsState()

    val searchAppBarState: SearchAppBarState by sharedViewmodel.searchAppBarState

    val searchTextState: String by sharedViewmodel.searchTextState

    Scaffold(
        topBar = {
            ListAppBar(
                sharedViewmodel = sharedViewmodel,
                searchAppBarState = searchAppBarState,
                searchTextState = searchTextState
            )
        },
        content = { paddingValues ->
            Log.d(TAG, "ListScreen: $paddingValues")// capture padding values
            ListContent(
                tasks = allTasks,
                navigateToTaskScreen = navigateToTaskScreen,
                modifier = Modifier.padding(paddingValues) // apply the padding
            )
        },
        floatingActionButton = {
            ListFab(navigateToTaskScreen)
        }
    )
}

@Composable
fun ListFab(
    onFabClicked: (taskId: Int) -> Unit
) {
    FloatingActionButton(
        onClick = { onFabClicked(-1) },
        containerColor = MaterialTheme.colorScheme.primaryContainer
    ) {
        Icon(
            imageVector = Icons.Filled.Add,
            contentDescription = stringResource(id = R.string.add_task),
            tint = MaterialTheme.colorScheme.onPrimaryContainer
        )
    }
}