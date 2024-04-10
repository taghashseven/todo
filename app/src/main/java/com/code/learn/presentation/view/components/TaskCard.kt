package com.code.learn.presentation.view.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.code.learn.R
import com.code.learn.domain.model.Task

@Composable
fun TaskItem(task: Task, delete: (Task) -> Unit , update : (Task)->Unit ){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Checkbox(
            checked = task.isCompleted,
            onCheckedChange = {
                task.isCompleted = !task.isCompleted
                update(task)
            }
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(text = task.title, style = MaterialTheme.typography.bodyLarge)
            if (task.description.isNotBlank()) {
                Text(text = task.description, style = MaterialTheme.typography.bodyMedium)
            }
        }
        Spacer(Modifier.weight((1f)))
        Button(
            onClick = {delete(task)}) {
            Image(painter = painterResource(id = R.drawable.cancel) , contentDescription = "delete icon")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreTaskCard() {
    val task = Task(1 , "notes", "my notes ", )
    TaskItem(task = task, delete = {} , update = {})
}