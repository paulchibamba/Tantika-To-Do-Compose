package com.paulchibamba.to_docompose.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.paulchibamba.to_docompose.data.models.Task

@Database(entities = [Task::class], version = 1, exportSchema = false)
abstract class TaskDatabase: RoomDatabase() {

    abstract fun toDoDao(): TaskDao

}