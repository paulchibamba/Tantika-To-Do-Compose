package com.paulchibamba.to_docompose.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.paulchibamba.to_docompose.util.Constants.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val description: String,
    val priority: Priority
)
