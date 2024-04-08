package com.code.learn.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "task"
)
data class Task(
    @PrimaryKey()
    val id: Int,
    val title: String,
    val description: String,
    val isCompleted: Boolean = false
)