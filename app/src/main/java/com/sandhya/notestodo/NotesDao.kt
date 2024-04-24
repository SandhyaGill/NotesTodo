package com.sandhya.notestodo

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface NotesDao {

    @Insert
    suspend fun insertToDo(ToDoEntity: NotesEntity)


    @Insert
    suspend fun insertNotes(notesEntity: NotesEntity)

    @Query("Select * From NotesEntity")
    fun getTodoEntities(): LiveData<List<NotesEntity>>

    @Update
    suspend fun updateToDoEntity(ToDoEntity : NotesEntity)

    @Delete
    suspend fun deleteToDoEntity(ToDoEntity : NotesEntity)


}