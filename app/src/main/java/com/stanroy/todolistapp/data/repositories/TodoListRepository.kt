package com.stanroy.todolistapp.data.repositories

import androidx.lifecycle.LiveData
import com.stanroy.todolistapp.data.database.TodoListDatabase
import com.stanroy.todolistapp.data.database.entities.TodoNote

class TodoListRepository(private val _db: TodoListDatabase) {
    private val db = _db.getDao()

    suspend fun upsert(note: TodoNote) = db.upsert(note)
    suspend fun delete(note: TodoNote) = db.delete(note)
    suspend fun update(note: TodoNote) = db.update(note)

    fun getAllNotes(): LiveData<List<TodoNote>> = db.getAllNotes()
    fun deleteAllNotes() = db.deleteAll()
}