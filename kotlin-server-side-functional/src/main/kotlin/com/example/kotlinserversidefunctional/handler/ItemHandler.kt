package com.example.kotlinserversidefunctional.handler

import com.example.kotlinserversidefunctional.repository.ItemRepository
import com.example.kotlinserversidefunctional.entity.Item
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import org.springframework.web.reactive.function.server.body
import org.springframework.web.reactive.function.server.bodyToMono
import reactor.core.publisher.Mono

// @Component
class ItemHandler(private val itemRepository: ItemRepository) {
    fun getList(request: ServerRequest): Mono<ServerResponse> = ServerResponse
        .ok()
        .body(Mono.just(itemRepository.findAll()))

    fun getById(request: ServerRequest): Mono<ServerResponse> = ServerResponse
        .ok()
        .body(Mono.just(itemRepository.findById(request.pathVariable("id").toInt())))

    fun create(request: ServerRequest): Mono<ServerResponse> {
        val savedItem = request.bodyToMono<Item>().map { itemRepository.save(it) }
        return ServerResponse.ok().body(savedItem)
    }

    fun deleteById(request: ServerRequest): Mono<ServerResponse> {
        itemRepository.deleteById(request.pathVariable("id").toInt())
        return ServerResponse.noContent().build()
    }
}