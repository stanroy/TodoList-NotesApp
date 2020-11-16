package com.stanroy.todolistapp.ui.todonote

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.stanroy.todolistapp.data.database.entities.TodoNote
import com.stanroy.todolistapp.data.repositories.TodoListRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TodoNoteViewModel(private val repository: TodoListRepository) : ViewModel() {

    val noteTitle = MutableLiveData<String>()
    val noteBody = MutableLiveData<String>()
    val editNote = MutableLiveData<TodoNote>()
    val editing = MutableLiveData<Boolean>()

    private val _emptyLiveData = MutableLiveData<Boolean>()
    val emptyLiveData: LiveData<Boolean>
        get() = _emptyLiveData
    private val _navigateBack = MutableLiveData<Boolean>()
    val navigateBack: LiveData<Boolean>
        get() = _navigateBack

    init {
        noteTitle.value = ""
        noteBody.value = ""
        editNote.value = null
        editing.value = false
    }

    fun navigateToList() {
        _navigateBack.value = true
    }

    fun upsert() = CoroutineScope(Dispatchers.Main).launch {
        if (noteTitle.value?.isEmpty()!! || noteBody.value?.isEmpty()!!) {
            _emptyLiveData.value = true
        } else {
            if (editing.value == false) {
                val note = TodoNote(noteTitle.value!!, noteBody.value!!)
                repository.upsert(note)
                _navigateBack.value = true
            } else {
                editNote.value!!.noteTitle = noteTitle.value!!
                editNote.value!!.noteBody = noteBody.value!!
                repository.upsert(editNote.value!!)
                _navigateBack.value = true
            }
        }


    }

}