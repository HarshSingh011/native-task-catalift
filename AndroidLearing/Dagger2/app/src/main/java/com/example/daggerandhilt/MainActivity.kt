package com.example.daggerandhilt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.daggerandhilt.ui.theme.DaggerAndHiltTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val component = DaggerUserRepositoryComponent.create()
        val emailService = EmailService()
        val userRepository = UserRepository()
//        val userRepositoryService = UserRepositoryService(emailService, userRepository)
//        userRepositoryService.registerUser("abc@gmail.com", "SecurePassword123!")
    }
}

