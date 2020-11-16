package com.stanroy.todolistapp

import android.app.Application
import com.stanroy.todolistapp.data.database.TodoListDatabase
import com.stanroy.todolistapp.data.repositories.TodoListRepository
import com.stanroy.todolistapp.ui.todolist.TodoListViewModel
import com.stanroy.todolistapp.ui.todonote.TodoNoteViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.android.ext.koin.androidContext
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.dsl.module


class TodoListApplication() : Application() {

    private val appModule = module {
        viewModel { TodoListViewModel(get()) }
        viewModel { TodoNoteViewModel(get()) }
    }

    private val databaseModule = module {
        single { TodoListDatabase.getDatabaseInstance(androidApplication()) }
        single { TodoListRepository(get()) }
    }

    private val allModules = databaseModule + appModule

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@TodoListApplication)
            modules(allModules)
        }

    }
}