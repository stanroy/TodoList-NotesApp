package com.stanroy.todolistapp.ui.todolist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import com.stanroy.todolistapp.data.database.entities.TodoNote
import com.stanroy.todolistapp.data.repositories.TodoListRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TodoListViewModel(private val repository: TodoListRepository) : ViewModel() {
    private val _navigateForward = MutableLiveData<Boolean>()
    val navigateForward: LiveData<Boolean>
        get() = _navigateForward

    private val _editClicked = MutableLiveData<Boolean>()
    val editClicked: LiveData<Boolean>
        get() = _editClicked

    private val _noteToEdit = MutableLiveData<TodoNote>()
    val noteToEdit: LiveData<TodoNote>
        get() = _noteToEdit

    fun navigateToNoteFragment() {
        _navigateForward.value = true
    }

    fun delete(note: TodoNote) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(note)
    }

    fun getAll() = repository.getAllNotes()

    fun clearAll() = CoroutineScope(Dispatchers.IO).launch {
        repository.deleteAllNotes()
    }

    fun editNote(note: TodoNote) {
        _noteToEdit.value = note
        _editClicked.value = true
    }
}