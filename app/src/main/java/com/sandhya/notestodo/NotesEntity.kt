package com.sandhya.notestodo

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class NotesEntity(
    @PrimaryKey(autoGenerate = true)
    var id : Int = 0,
    var notes : String? = null

)
