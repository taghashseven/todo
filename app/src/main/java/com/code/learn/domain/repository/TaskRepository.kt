package com.code.learn.domain.repository

interface TaskRepository {
    suspend fun getAllTask()
    suspend fun  getAllTaskCompleted()

    suspend fun upsertI()

    suspend fun delete()

}