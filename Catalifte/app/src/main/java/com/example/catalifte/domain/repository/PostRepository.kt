package com.example.catalift.domain.repository

import com.example.catalifte.domain.model.Post
import kotlinx.coroutines.flow.Flow

interface PostRepository {
    fun getPosts(): Flow<List<Post>>
    suspend fun starPost(postId: String, starred: Boolean): Result<Unit>
    suspend fun getPostById(postId: String): Result<Post>
}