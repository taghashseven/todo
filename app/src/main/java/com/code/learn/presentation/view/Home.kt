package com.code.learn.presentation.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.code.learn.presentation.view.components.TaskList
import com.code.learn.presentation.viewmodel.StateViewModel

@Composable
fun Home() {
    var name by remember { mutableStateOf("") }
    val stateviewModel: StateViewModel = viewModel()
    val list = stateviewModel._taskList
    Column {
        TaskList(
            taskList = list,
            onTaskClick = { task ->
                stateviewModel.toggleTaskCompletion(task.id)
            }
        )
        TextField(
            value = name,
            onValueChange = {name=it} ,
            modifier =Modifier.fillMaxWidth()
        )
        Button(onClick = {
            stateviewModel.add(name)
            name = ""
        }) {
            Text("add")
        }
    }
}