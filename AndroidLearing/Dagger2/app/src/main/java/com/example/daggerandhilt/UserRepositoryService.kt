package com.example.daggerandhilt

import javax.inject.Inject

class UserRepositoryService @Inject constructor(
    private val emailService : EmailService,
    private val userRepository : UserRepository
) {
    fun registerUser(email: String, password: String) {
        userRepository.saveUser(email, password)
        emailService.send(email, "Testing", "Hi I am Testing")
    }
}