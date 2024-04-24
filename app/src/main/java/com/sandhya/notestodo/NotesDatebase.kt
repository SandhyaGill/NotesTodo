package com.sandhya.notestodo

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities =  [NotesEntity::class, TodoEntity::class], version=1)
abstract class ToDoDatabase : RoomDatabase() {

    abstract fun todoDao() : NotesDao

    companion object{
        var toDoDatabase : ToDoDatabase? = null

        @Synchronized
        fun getDatabaseIntance(context: Context): ToDoDatabase{
            if (toDoDatabase == null){
                toDoDatabase = Room.databaseBuilder(context,
                    ToDoDatabase::class.java,
                    context.resources.getString(R.string.app_name))
                    .build()
            }
            return toDoDatabase!!
        }

    }
}
