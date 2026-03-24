package com.example.myapplication.data.repository

import com.example.myapplication.data.interface.DogApiService
import com.example.myapplication.data.models.DogData
import com.example.myapplication.data.mapper.mapAttributesToDogDTO

class DogRepository(
    private val apiService: DogApiService
) {
    suspend fun getDogs(): Result<List<DogDTO>> {
        return try {
            val response = apiService.getDogs()
            val dogDTOList = response.flatMap { dogData ->
                dogData.data.map { data ->
                    mapAttributesToDogDTO(data.attributes)
                }
            }
            Result.success(dogDTOList)
        } catch (exception: Exception) {
            Result.failure(exception)
        }
    }
}