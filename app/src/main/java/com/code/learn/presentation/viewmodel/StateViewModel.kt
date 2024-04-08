package com.code.learn.presentation.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.code.learn.MyApp
import com.code.learn.data.TaskDatabase
import com.code.learn.domain.model.Task
import kotlinx.coroutines.launch

class StateViewModel: ViewModel() {
    val database = TaskDatabase.getDatabase(MyApp.getContext())
    val taskDao = database.taskDao()
    val _taskList = mutableStateListOf<Task>()


    fun toggleTaskCompletion(taskId: Int) {
        val taskIndex = _taskList.indexOfFirst { it.id == taskId }
        _taskList[taskIndex] = _taskList[taskIndex].copy(isCompleted = !_taskList[taskIndex].isCompleted)
    }

    fun add(title: String){
        var id = 1
        if(_taskList.isNotEmpty()){
            id = _taskList.last().id +1
        }
        val task = Task(id, title, "description", false)
        _taskList.add(task)
        viewModelScope.launch {
            taskDao.upsert(task)
        }
    }
}