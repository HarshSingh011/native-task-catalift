package com.example.daggerandhilt

import dagger.Component

@Component
interface UserRepositoryComponent {
    fun getUserRegistrationService(): UserRepositoryService
    fun getEmailService(): EmailService
}