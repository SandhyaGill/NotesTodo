package com.sandhya.notestodo

import android.app.Dialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.sandhya.notestodo.adapter.AddListAdapter
import com.sandhya.notestodo.databinding.FragmentAddUpdateBinding
import com.sandhya.notestodo.modules.TodoItem

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AddUpdateFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AddUpdateFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding: FragmentAddUpdateBinding
    lateinit var todoDatabase: ToDoDatabase
    lateinit var adapter: AddListAdapter
    var list = ArrayList<TodoItem>()
    var todoEntityList = arrayListOf<NotesEntity>()
    lateinit var notesViewModel: NotesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        notesViewModel = ViewModelProvider(this)[NotesViewModel::class.java]
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAddUpdateBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = AddListAdapter(list)
        binding.rvTodoItems.layoutManager = LinearLayoutManager(requireContext())
        binding.rvTodoItems.adapter = adapter

        todoDatabase = ToDoDatabase.getDatabaseIntance(requireContext())
        binding.btnAddTodoItems.setOnClickListener {
            var dialog = Dialog(requireContext())
            dialog.setContentView(R.layout.todo_item_dialog)
            var etTodoItem = dialog.findViewById<EditText>(R.id.etTodoItem)
            var btnAddTodoItem = dialog.findViewById<Button>(R.id.btnAddTodoItem)
            btnAddTodoItem.setOnClickListener {
                if (etTodoItem.text.toString().isNullOrEmpty()){
                    etTodoItem.error = resources.getString(R.string.enter_todo_item)
                }else{
                    var todoItem = etTodoItem.text.toString()
                    list.add(TodoItem(todoItem = todoItem))
                    adapter.notifyDataSetChanged()
                    dialog.dismiss()
                }
            }
            dialog.window?.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
            )
            dialog.show()
        }
        binding.btnAdd.setOnClickListener {
            if (binding.etNotes.text.toString().trim().isNullOrEmpty()){
                binding.etNotes.error = resources.getString(R.string.enter_notes)
            }else{
                var etNotes = binding.etNotes.text.toString()
                notesViewModel.insertNotes(NotesEntity(notes = etNotes))
                findNavController().popBackStack()
            }
        }
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment AddUpdateFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            AddUpdateFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}