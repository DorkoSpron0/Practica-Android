package com.example.project_1.viewmodel.ActivityThree

import android.annotation.SuppressLint
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class TaskListViewModel:ViewModel() {

    val listaTares by mutableStateOf(
        mutableListOf(
            Task(1, "task uno", true),
            Task(2, "task dos", false),
            Task(3, "task tres", true)
        )
    )
}