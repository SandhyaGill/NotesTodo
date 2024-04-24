package com.sandhya.notestodo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.sandhya.notestodo.adapter.NotesListAdapter
import com.sandhya.notestodo.databinding.FragmentNotesBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [NotesFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class NotesFragment : Fragment(), OnItemClickInterface {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    lateinit var binding: FragmentNotesBinding
    lateinit var adapter : NotesListAdapter
//    var list = ArrayList<Notes>()
    lateinit var todoDatabase: ToDoDatabase
    var todoEntityList = arrayListOf<NotesEntity>()
    lateinit var notesViewModel: NotesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
        binding = FragmentNotesBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        notesViewModel = ViewModelProvider(this)[NotesViewModel::class.java]
        adapter = NotesListAdapter(todoEntityList,this)
        binding.rvNotesList.layoutManager = LinearLayoutManager(requireContext())
        binding.rvNotesList.adapter = adapter
        binding.fabNotes.setOnClickListener {
            findNavController().navigate(R.id.addUpdateFragment)
        }

        notesViewModel.notesEntity.observe(this){
            todoEntityList.clear()
            todoEntityList.addAll(it as ArrayList<NotesEntity>)
        }
    }

    private fun getDatabaseValue() {
        todoEntityList.clear()
        adapter.notifyDataSetChanged()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment NotesFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            NotesFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun edit(notes: NotesEntity) {

    }

    override fun delete(notes: NotesEntity) {
        AlertDialog.Builder(requireContext())
            .setTitle(resources.getString(R.string.delete_message))
            .setPositiveButton("yes") { _, _ ->
                Toast.makeText(requireContext(), resources.getString(R.string.removed), Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("No") { _, _ ->
                Toast.makeText(requireContext(), "Can't remove ", Toast.LENGTH_SHORT).show()
            }
            .show()
    }
}