package com.stanroy.todolistapp.data.database


import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.stanroy.todolistapp.data.database.entities.TodoNote

@Database(entities = [TodoNote::class], version = 1, exportSchema = false)
abstract class TodoListDatabase : RoomDatabase() {

    abstract fun getDao(): TodoListDao

    companion object {
        private val INSTANCE: TodoListDatabase? = null

        fun getDatabaseInstance(context: Context): TodoListDatabase {
            var instance = INSTANCE

            if (instance == null) {
                instance = Room.databaseBuilder(
                    context.applicationContext,
                    TodoListDatabase::class.java,
                    "todolist_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instance
        }
    }

}