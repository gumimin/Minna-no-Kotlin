package com.example.kotlinserverside.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table("items")
data class Item(
    @Id val id: Int,
    val name: String,
    val price: Int
)