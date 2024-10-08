package com.paulchibamba.to_docompose.ui.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.paulchibamba.to_docompose.data.models.Task
import com.paulchibamba.to_docompose.data.repositories.TaskRepository
import com.paulchibamba.to_docompose.util.RequestState
import com.paulchibamba.to_docompose.util.RequestState.Errorr
import com.paulchibamba.to_docompose.util.SearchAppBarState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SharedViewmodel @Inject constructor(
    private val repository: TaskRepository
): ViewModel() {

    val searchAppBarState: MutableState<SearchAppBarState> = mutableStateOf(SearchAppBarState.CLOSED)

    val searchTextState: MutableState<String> = mutableStateOf("")

    private val _allTasks = MutableStateFlow<RequestState<List<Task>>>(RequestState.Idle)
    val allTasks: StateFlow<RequestState<List<Task>>> = _allTasks

    fun getAllTasks(){
        _allTasks.value = RequestState.Loading
        try {
            viewModelScope.launch {
                repository.getAllTasks.collect {
                    _allTasks.value = RequestState.Success(it)
                }
            }
        } catch (e: Exception) {
            _allTasks.value = RequestState.Error(e)
        }
    }

}