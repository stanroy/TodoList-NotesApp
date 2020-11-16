package com.stanroy.todolistapp.ui.other

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.stanroy.todolistapp.R
import com.stanroy.todolistapp.data.database.entities.TodoNote
import com.stanroy.todolistapp.ui.todolist.TodoListViewModel
import kotlinx.android.synthetic.main.todo_note.view.*

class TodoNoteAdapter(var items: List<TodoNote>, private val viewModel: TodoListViewModel) :
    RecyclerView.Adapter<TodoNoteAdapter.TodoViewHolder>() {

    class TodoViewHolder(noteView: View) : RecyclerView.ViewHolder(noteView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.todo_note, parent, false)
        return TodoViewHolder(view)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        val currentNote = items[position]

        holder.itemView.tvListTitle.text = currentNote.noteTitle
        holder.itemView.tvListBody.text = currentNote.noteBody

        holder.itemView.btnDelete.setOnClickListener {
            viewModel.delete(currentNote)
        }

        holder.itemView.btnEdit.setOnClickListener {
            viewModel.editNote(currentNote)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

}