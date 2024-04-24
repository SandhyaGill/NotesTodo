package com.sandhya.notestodo


interface OnItemClickInterface {
    fun edit(notes: NotesEntity)
    fun delete(notes: NotesEntity)
}