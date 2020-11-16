package com.stanroy.todolistapp.ui.todonote

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.stanroy.todolistapp.R
import com.stanroy.todolistapp.data.database.entities.TodoNote
import com.stanroy.todolistapp.databinding.FragmentTodoNoteBinding
import org.koin.android.viewmodel.ext.android.viewModel


class TodoNoteFragment : Fragment() {

    private val args by navArgs<TodoNoteFragmentArgs>()
    private val viewModel: TodoNoteViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentTodoNoteBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_todo_note, container, false)
        binding.todoNoteViewModel = viewModel
        viewModel.navigateBack.observe(viewLifecycleOwner, Observer { navigateBack ->

            if (navigateBack) {
                findNavController().navigate(TodoNoteFragmentDirections.actionTodoNoteFragmentToTodoListFragment())
            }
        })

        viewModel.emptyLiveData.observe(viewLifecycleOwner, Observer {
            Toast.makeText(
                requireActivity().applicationContext,
                "Please enter title and note",
                Toast.LENGTH_SHORT
            ).show()
        })
        editNote(viewModel)
        return binding.root
    }

    fun editNote(viewModel: TodoNoteViewModel) {
        if (args.note?.noteTitle == null || args.note?.noteBody == null) {
            Log.i("EditNote::", "No note to edit")
            //println(viewModel.editing.value)
        } else {
            //Log.i("noteID:: ", args.note?.noteId!!.toString())
            val editNote = TodoNote(args.note?.noteTitle!!, args.note?.noteBody!!)
            viewModel.noteTitle.value = args.note?.noteTitle
            viewModel.noteBody.value = args.note?.noteBody
            viewModel.editNote.value = editNote
            viewModel.editNote.value?.noteId = args.note?.noteId!!
            viewModel.editing.value = true
        }
    }
}