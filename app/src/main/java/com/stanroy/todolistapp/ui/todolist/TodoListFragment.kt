package com.stanroy.todolistapp.ui.todolist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.stanroy.todolistapp.R
import com.stanroy.todolistapp.data.database.entities.TodoNoteParcelable
import com.stanroy.todolistapp.databinding.FragmentTodoListBinding
import com.stanroy.todolistapp.ui.other.TodoNoteAdapter
import org.koin.android.viewmodel.ext.android.viewModel


class TodoListFragment : Fragment() {

    private val viewModel: TodoListViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentTodoListBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_todo_list, container, false)

        val adapter = TodoNoteAdapter(listOf(), viewModel)
        val rvNotes = binding.rvTodoNotes
        rvNotes.layoutManager = LinearLayoutManager(this.context)
        rvNotes.adapter = adapter
        binding.todoListViewModel = viewModel

        viewModel.navigateForward.observe(viewLifecycleOwner, Observer { navigateForward ->

            if (navigateForward) {
                this.findNavController()
                    .navigate(
                        TodoListFragmentDirections.actionTodoListFragmentToTodoNoteFragment(
                            null
                        )
                    )
            }
        })

        viewModel.getAll().observe(viewLifecycleOwner, Observer {
            adapter.items = it
            adapter.notifyDataSetChanged()
        })

        viewModel.editClicked.observe(viewLifecycleOwner, Observer { editClicked ->
            val id = viewModel.noteToEdit.value?.noteId
            val title = viewModel.noteToEdit.value?.noteTitle
            val body = viewModel.noteToEdit.value?.noteBody

            val note = TodoNoteParcelable(id, title, body)

            if (editClicked) {
                this.findNavController().navigate(
                    TodoListFragmentDirections.actionTodoListFragmentToTodoNoteFragmentWithArgs(note)
                )
            }
        })
        return binding.root
    }
}