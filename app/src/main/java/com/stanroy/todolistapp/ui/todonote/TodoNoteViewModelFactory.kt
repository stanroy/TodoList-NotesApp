package com.stanroy.todolistapp.ui.todonote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.stanroy.todolistapp.data.repositories.TodoListRepository
import java.lang.IllegalArgumentException

@Suppress("UNCHECKED_CAST")
class TodoNoteViewModelFactory(private val repository: TodoListRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TodoNoteViewModel::class.java)) {
            return TodoNoteViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}