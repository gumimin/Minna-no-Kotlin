package com.example.kotlinserverside.controller

import com.example.kotlinserverside.entity.Item
import com.example.kotlinserverside.repository.ItemRepository
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
class ItemController(private val itemRepository: ItemRepository) {
    @GetMapping("/items")
    suspend fun getList() = itemRepository.findAll()

    @GetMapping("/items/{id}")
    suspend fun getById(@PathVariable id: Int) = itemRepository.findById(id)

    @PostMapping("/items")
    @ResponseStatus(HttpStatus.CREATED)
    suspend fun create(@RequestBody item: Item): Item = itemRepository.save(item)

    @DeleteMapping("/items/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    suspend fun deleteById(@PathVariable id: Int) = itemRepository.deleteById(id)
}