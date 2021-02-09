package net.kathir.ui.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch
import net.kathir.mvi_kotlinflow.data.repository.MainRepository
import net.kathir.ui.main.intent.MainIntent
import net.kathir.ui.main.viewstate.MainState

@ExperimentalCoroutinesApi
class MainViewModel(private val repository: MainRepository) : ViewModel() {

    val userIntent = Channel<MainIntent>(Channel.UNLIMITED)

    private val _state = MutableStateFlow<MainState>(MainState.Idle)


    val state : StateFlow<MainState>
    get() = _state;


    init {
        handleIntent()
    }

    private fun handleIntent() {

        viewModelScope.launch {
            userIntent.consumeAsFlow().collect {
                when(it)
                {
                    is MainIntent.FetchUsers -> fetchUser()
                }
            }
        }
    }

    private fun fetchUser() {

        viewModelScope.launch {
            _state.value = MainState.Loading
            _state.value = try {
                MainState.Users(repository.getUsers())
            }catch (e: Exception)
            {
                MainState.Error(e.localizedMessage)
            }
        }
    }
}