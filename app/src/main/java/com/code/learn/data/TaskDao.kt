package com.code.learn.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.code.learn.domain.model.Task

@Dao
interface TaskDao {

    // inset , update , delete , getAll, get completed , get uncompleted
    @Upsert
    suspend fun  upsert(task : Task)

    @Query("SELECT * FROM task")
    suspend fun getAll(): List<Task>

    @Delete
    suspend fun delete(task : Task)

    // get all completed
    @Query("SELECT * FROM task where isCompleted == 1")
    suspend fun getAllCompleted() : List<Task>

    // all uncompleted
    @Query("SELECT * FROM task where isCompleted != 1")
    suspend fun getAllUnCompleted(): List<Task>



}