package com.sandhya.notestodo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sandhya.notestodo.ToDoEntity
import com.sandhya.notestodo.databinding.AddNotesListItemBinding

class AddListAdapter(var addList: ArrayList<ToDoEntity>): RecyclerView.Adapter<AddListAdapter.ViewHolder>() {
    class ViewHolder(var binding: AddNotesListItemBinding) : RecyclerView.ViewHolder(binding.root){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(AddNotesListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return addList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.apply {
            binding.apply {
                tvAddList.text = addList[position].notes
                tvTodo.text = addList[position].todoItem
            }
        }
    }
}