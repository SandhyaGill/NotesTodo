package com.sandhya.notestodo

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(foreignKeys = [ForeignKey(entity = NotesEntity::class,
    parentColumns=["id"],
    childColumns = ["notesId"], onDelete = ForeignKey.CASCADE
)])
data class TodoEntity (
    @PrimaryKey(autoGenerate = true)
    var id : Int = 0,
    var notesId : Int ?= 0,
    var todo: String?= null,
    var isCompleted: Boolean?= false
)