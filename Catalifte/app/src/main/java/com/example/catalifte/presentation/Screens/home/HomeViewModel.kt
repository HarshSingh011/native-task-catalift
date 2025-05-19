package com.example.catalift.presentation.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.catalift.domain.model.Post
import com.example.catalift.domain.usecase.GetPostsUseCase
import com.example.catalift.domain.usecase.StarPostUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getPostsUseCase: GetPostsUseCase,
    private val starPostUseCase: StarPostUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Loading)
    val uiState: StateFlow<HomeUiState> = _uiState

    init {
        loadPosts()
    }

    private fun loadPosts() {
        getPostsUseCase()
            .onEach { posts ->
                _uiState.value = HomeUiState.Success(posts)
            }
            .catch { e ->
                _uiState.value = HomeUiState.Error(e.message ?: "Unknown error occurred")
            }
            .launchIn(viewModelScope)
    }

    fun toggleStar(postId: String, currentlyStarred: Boolean) {
        viewModelScope.launch {
            starPostUseCase(postId, !currentlyStarred)
        }
    }
}

sealed class HomeUiState {
    object Loading : HomeUiState()
    data class Success(val posts: List<Post>) : HomeUiState()
    data class Error(val message: String) : HomeUiState()
}