package com.sandhya.notestodo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sandhya.notestodo.databinding.TodoItemListBinding
import com.sandhya.notestodo.modules.TodoItem

class AddListAdapter(var addList: ArrayList<TodoItem>): RecyclerView.Adapter<AddListAdapter.ViewHolder>() {
    class ViewHolder(var binding: TodoItemListBinding) : RecyclerView.ViewHolder(binding.root){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(TodoItemListBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun getItemCount(): Int {
        return addList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.apply {
            binding.apply {
                tvTodoItem.setText(addList[position].todoItem)
            }
        }
    }
    fun getList(): ArrayList<TodoItem> {
        addList.clear()
        addList.addAll(addList)
        return addList
    }
}