package com.stanroy.todolistapp.data.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.stanroy.todolistapp.data.database.entities.TodoNote

@Dao
interface TodoListDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(note: TodoNote)

    @Update
    suspend fun update(note: TodoNote)

    @Delete
    suspend fun delete(note: TodoNote)

    @Query("SELECT * FROM todo_notes")
    fun getAllNotes(): LiveData<List<TodoNote>>

    @Query("DELETE FROM todo_notes")
    fun deleteAll()
}