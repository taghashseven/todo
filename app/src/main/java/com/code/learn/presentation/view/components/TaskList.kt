package com.code.learn.presentation.view.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.code.learn.domain.model.Task

@Composable
fun TaskList(taskList: List<Task>, onTaskClick: (Task) -> Unit) {
    LazyColumn {
        items(taskList) { task ->
            TaskItem(task = task, onTaskClick = onTaskClick)
        }
    }
}

@Preview
@Composable
fun Prev() {
    val task  = arrayListOf<Task>()
    TaskList(taskList = task, onTaskClick = {})
}