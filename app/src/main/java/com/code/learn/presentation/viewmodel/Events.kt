package com.code.learn.presentation.viewmodel

import com.code.learn.domain.model.Task

sealed class Events {
    data class delete (val task : Task) : Events()
    data class upsert(val task: Task) : Events()

}