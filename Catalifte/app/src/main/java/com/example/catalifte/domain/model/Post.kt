package com.example.catalifte.domain.model

data class Post(
    val id: String,
    val author: User,
    val title: String,
    val content: String,
    val imageUrl: String?,
    val stars: Int,
    val comments: Int,
    val isStarred: Boolean = false,
    val timestamp: Long
)

data class User(
    val id: String,
    val name: String,
    val title: String,
    val profileImageUrl: String?,
    val isEdited: Boolean = false
)