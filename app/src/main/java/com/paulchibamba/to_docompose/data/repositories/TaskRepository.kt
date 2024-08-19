package com.paulchibamba.to_docompose.data.repositories

import com.paulchibamba.to_docompose.data.TaskDao
import com.paulchibamba.to_docompose.data.models.Task
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ViewModelScoped
class TaskRepository @Inject constructor(private val taskDao: TaskDao) {

    val getAllTasks: Flow<List<Task>> = taskDao.getAllTasks()
    val sortByLowPriority: Flow<List<Task>> = taskDao.sortByLowPriority()
    val sortByHighPriority: Flow<List<Task>> = taskDao.sortByHighPriority()

    fun getSelectedTask(taskId: Int): Flow<Task> {
        return taskDao.getSelectedTask(taskId)
    }

    suspend fun addTask(task: Task) {
        taskDao.addTask(task)
    }
    
    suspend fun updateTask(task: Task) {
        taskDao.updateTask(task)
    }
    
    suspend fun deleteTask(task: Task) {
        taskDao.deleteTask(task)
    }
    
    suspend fun deleteAll(){
        taskDao.deleteAll()
    }

    suspend fun search(query: String): Flow<List<Task>> {
        return taskDao.searchDatabase(query)
    }

    
}