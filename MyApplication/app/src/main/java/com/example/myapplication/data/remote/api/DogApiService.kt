package com.example.myapplication.data.interface

import com.example.myapplication.data.models.DogData
import retrofit2.http.GET

interface DogApiService {
    @GET("breeds")
    suspend fun getDogs(): List<DogData>
}