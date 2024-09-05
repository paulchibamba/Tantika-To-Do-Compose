package com.paulchibamba.to_docompose.ui.screens.list


import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.paulchibamba.to_docompose.data.models.Priority
import com.paulchibamba.to_docompose.data.models.Task
import com.paulchibamba.to_docompose.ui.theme.LARGE_PADDING
import com.paulchibamba.to_docompose.ui.theme.MEDIUM_LARGE_PADDING
import com.paulchibamba.to_docompose.ui.theme.MEDIUM_PADDING
import com.paulchibamba.to_docompose.ui.theme.PRIORITY_INDICATOR_SIZE
import com.paulchibamba.to_docompose.ui.theme.TASK_ITEM_ELEVATION
import com.paulchibamba.to_docompose.util.RequestState

@Composable
fun ListContent(
    tasks: RequestState<List<Task>>,
    navigateToTaskScreen: (taskId: Int) -> Unit,
    modifier: Modifier = Modifier
) {

    if (tasks is RequestState.Success) {
        if (tasks.data.isEmpty()){
            EmptyContent()
        } else {
            DisplayTasks(
                tasks = tasks.data,
                navigateToTaskScreen = navigateToTaskScreen,
                modifier = modifier
            )
        }
    }
}

@Composable
fun DisplayTasks(
    tasks: List<Task>,
    navigateToTaskScreen: (taskId: Int) -> Unit,
    modifier: Modifier = Modifier
){
    LazyColumn(modifier = modifier
        .padding(top = LARGE_PADDING)
    ) { // apply the modifier here
        items(
            items = tasks,
            key = { task ->
                task.id
            }
        ) { task ->
            TaskItem(
                task = task,
                navigateToTaskScreen = navigateToTaskScreen
            )
        }
    }
}

@Composable
fun TaskItem(
    task: Task,
    navigateToTaskScreen: (taskId: Int) -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth(),
        color = MaterialTheme.colorScheme.surface,
        shape = RectangleShape,
        shadowElevation = TASK_ITEM_ELEVATION,
        onClick = {
            navigateToTaskScreen(task.id)
        }) {
        Column(
            modifier = Modifier
                .padding(MEDIUM_LARGE_PADDING)
                .fillMaxWidth()
        ) {
            Row {
                Text(
                    modifier = Modifier.weight(8f),
                    text = task.title,
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1
                )
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                    contentAlignment = Alignment.TopEnd
                ) {
                    androidx.compose.foundation.Canvas(
                        modifier = Modifier
                            .size(PRIORITY_INDICATOR_SIZE)
                    ) {
                        drawCircle(
                            color = task.priority.color
                        )
                    }
                }
            }
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = task.description,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
        }

    }

}

@Preview
@Composable
fun TaskItemPreview() {
    TaskItem(
        task = Task(
            id = 1,
            title = "Practice Piano",
            description = "Go through the next pianote lesson",
            priority = Priority.MEDIUM
        ),
        navigateToTaskScreen = {}
    )
}