package com.stanroy.todolistapp.data.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "todo_notes")
data class TodoNote(
    @ColumnInfo(name = "todo_note_title")
    var noteTitle: String,

    @ColumnInfo(name = "todo_note_body")
    var noteBody: String
) {
    @PrimaryKey(autoGenerate = true)
    var noteId: Int? = null
}