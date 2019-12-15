package com.example.kotlinserversidereactive.controller

import com.example.kotlinserversidereactive.domain.Color
import com.example.kotlinserversidereactive.repository.ColorRepository
import com.example.kotlinserversidereactive.exception.DatabaseOpepationFailureException
import kotlinx.coroutines.flow.Flow
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ColorController(private val colorRepository: ColorRepository) {
    @GetMapping("/colors")
    fun getAll(): Flow<Color> = colorRepository.findAll()

    @GetMapping("/colors/{code}")
    suspend fun getByCode(@PathVariable code: String) = colorRepository.findByCode(code)

    @PostMapping("/colors")
    suspend fun post(@RequestBody color: Color) = colorRepository.save(color)

    @DeleteMapping("/colors/{code}")
    suspend fun delete(@PathVariable code: String) = colorRepository.daleteByCode(code)

    @ExceptionHandler(DatabaseOpepationFailureException::class)
    fun handleDatabaseOpepationFailureException(exception: DatabaseOpepationFailureException) = "リクエストに誤りがあります: ${exception.message}"
}

