package com.code.learn.presentation.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.code.learn.MyApp
import com.code.learn.data.TaskDatabase
import com.code.learn.domain.model.Task
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class StateViewModel: ViewModel() {
    private val database = TaskDatabase.getDatabase(MyApp.getContext())
    private val taskDao = database.taskDao()
    private val _taskList = MutableStateFlow<List<Task>>(emptyList())
    val taskList = _taskList.asStateFlow()

        fun add(title : String){
            val task = Task(null ,  title , "notes")
            add(task)
        }

    // delete
    fun delete(task : Task){
        viewModelScope.launch {
            taskDao.delete(task)
            _taskList.value= taskDao.getAll()
        }
    }

    fun add(task: Task){
        viewModelScope.launch {
            taskDao.upsert(task)
            _taskList.value = taskDao.getAll()
        }
    }

}