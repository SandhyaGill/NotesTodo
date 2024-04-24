package com.sandhya.notestodo

import androidx.lifecycle.LiveData

class NotesRepository(val notesDao : NotesDao) {

    val notesList : LiveData<List<NotesEntity>> = notesDao.getTodoEntities()

    suspend fun addNotes(notesEntity: NotesEntity){
            notesDao.insertNotes(notesEntity)
    }

}