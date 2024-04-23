package com.sandhya.notestodo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sandhya.notestodo.ToDoEntity
import com.sandhya.notestodo.databinding.NotesListItemBinding

class NotesListAdapter(var notesList: ArrayList<ToDoEntity>) : RecyclerView.Adapter<NotesListAdapter.ViewHolder>() {
    class ViewHolder(var binding: NotesListItemBinding) : RecyclerView.ViewHolder(binding.root){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(NotesListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return notesList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.apply {
            binding.apply {
                tvNotes.text = notesList[position].notes
                tvTodoItem.text = notesList[position].todoItem
                
            }
        }
    }
}