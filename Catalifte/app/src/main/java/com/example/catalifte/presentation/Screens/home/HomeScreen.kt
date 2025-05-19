package com.example.catalift.presentation.screens.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.catalift.presentation.components.BottomNavigation
import com.example.catalift.presentation.components.PostItem
import com.example.catalift.presentation.components.SearchBar
import com.example.catalifte.presentation.components.AppBar

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
    onNavigate: (String) -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()
    val snackbarHostState = remember { SnackbarHostState() }

    Scaffold(
        topBar = { AppBar() },
        bottomBar = { BottomNavigation(currentRoute = "home", onNavigate = onNavigate) },
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            SearchBar(
                onSearch = { /* TODO: Implement search */ },
                onAddClick = { /* TODO: Implement add new post */ }
            )

            when (uiState) {
                is HomeUiState.Loading -> {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                }

                is HomeUiState.Success -> {
                    val posts = (uiState as HomeUiState.Success).posts
                    LazyColumn {
                        items(posts) { post ->
                            PostItem(
                                post = post,
                                onStarClick = viewModel::toggleStar,
                                onCommentClick = { /* TODO */ },
                                onShareClick = { /* TODO */ }
                            )
                        }
                    }
                }

                is HomeUiState.Error -> {
                    val errorMessage = (uiState as HomeUiState.Error).message
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "Error: $errorMessage")
                    }

                    LaunchedEffect(errorMessage) {
                        snackbarHostState.showSnackbar(message = errorMessage)
                    }
                }
            }
        }
    }
}