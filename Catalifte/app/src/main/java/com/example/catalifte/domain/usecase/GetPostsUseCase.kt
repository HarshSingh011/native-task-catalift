package com.example.catalift.domain.usecase

import com.example.catalift.domain.repository.PostRepository
import com.example.catalifte.domain.model.Post
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPostsUseCase @Inject constructor(
    private val postRepository: PostRepository
) {
    operator fun invoke(): Flow<List<Post>> {
        return postRepository.getPosts()
    }
}