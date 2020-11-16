package com.stanroy.todolistapp.ui.todolist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.stanroy.todolistapp.data.repositories.TodoListRepository
import java.lang.IllegalArgumentException

@Suppress("UNCHECKED_CAST")
class TodoListViewModelFactory(private val repository: TodoListRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(TodoListViewModel::class.java)) {
            return TodoListViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}