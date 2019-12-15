package com.example.kotlinserversidereactive.domain

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("colors")
data class Color(
    @Id @JsonIgnore
    val id: String = "",
    val name: String,
    val code: String
)