package com.sandhya.notestodo

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class NotesViewModel(application: Application) : AndroidViewModel(application) {
    var notesEntity: LiveData<List<NotesEntity>>
    var notesRepository : NotesRepository

    init {
        var dao = ToDoDatabase.getDatabaseIntance(application).todoDao()
        notesRepository = NotesRepository(dao)
        notesEntity = notesRepository.notesList
    }

    fun insertNotes(notesEntity: NotesEntity){
        GlobalScope.launch {
            notesRepository.addNotes(notesEntity)
        }
    }
}