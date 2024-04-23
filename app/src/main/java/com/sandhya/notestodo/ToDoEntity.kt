package com.sandhya.notestodo

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class ToDoEntity(
    @PrimaryKey(autoGenerate = true)
    var id : Int = 0,
    var todoItem: String? = null,
    var notes : String? = null

)
