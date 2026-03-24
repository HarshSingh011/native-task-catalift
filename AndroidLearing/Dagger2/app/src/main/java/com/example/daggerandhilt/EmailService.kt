package com.example.daggerandhilt

import android.util.Log
import javax.inject.Inject

class EmailService @Inject constructor(){
    fun send(to: String, subject: String, body: String) {
        Log.d("EmailSendTo","To: $to")
    }
}