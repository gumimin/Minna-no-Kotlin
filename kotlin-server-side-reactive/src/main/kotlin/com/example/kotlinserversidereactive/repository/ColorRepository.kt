package com.example.kotlinserversidereactive.repository

import com.example.kotlinserversidereactive.domain.Color
import com.example.kotlinserversidereactive.exception.DatabaseOpepationFailureException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.reactive.asFlow
import kotlinx.coroutines.reactive.awaitFirst
import kotlinx.coroutines.reactive.awaitFirstOrNull
import org.springframework.data.mongodb.core.ReactiveMongoTemplate
import org.springframework.data.mongodb.core.findAll
import org.springframework.data.mongodb.core.findAndRemove
import org.springframework.data.mongodb.core.findOne
import org.springframework.data.mongodb.core.query.Query
import org.springframework.data.mongodb.core.query.isEqualTo
import org.springframework.stereotype.Repository

@Repository
class ColorRepository(private val template: ReactiveMongoTemplate) {
    fun findAll(): Flow<Color> {
        return template
            .findAll<Color>()
            .asFlow()
    }

    suspend fun findByCode(code: String): Color {
        return template
            .findOne<Color>(Query(Color::code isEqualTo code))
            .awaitFirstOrNull()
            ?: throw DatabaseOpepationFailureException("[詳細取得失敗]カラーコードがDBに存在しません")
    }

    suspend fun save(color: Color): Color {
        template.findOne<Color>(Query(Color::code isEqualTo color.code))
            .awaitFirstOrNull()
            ?.let { throw DatabaseOpepationFailureException("[作成失敗]同じカラーコードがすでに存在しています") }
        return template
            .save(color)
            .awaitFirst()
    }

    suspend fun daleteByCode(code: String) {
        template
            .findAndRemove<Color>(Query(Color::code isEqualTo code))
            .awaitFirstOrNull()
            ?: throw IllegalArgumentException("[削除失敗]カラーコードがDBに存在しません")
    }
}

