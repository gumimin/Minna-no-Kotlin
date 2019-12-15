package com.example.kotlinserversidefunctional.router

import com.example.kotlinserversidefunctional.handler.ItemHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.MediaType
import org.springframework.web.reactive.function.server.router

// @Configuration
class ApiRouter(private val itemHandler: ItemHandler) {
    // @Bean
    fun itemRouter() = router {
        ("/items" and accept(MediaType.APPLICATION_JSON)).nest {
            GET("/", itemHandler::getList)
            GET("/{id}", itemHandler::getById)
            POST("/", itemHandler::create)
            DELETE("/{id}", itemHandler::deleteById)
        }
    }
}