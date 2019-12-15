package com.example.kotlinserverside.service

import com.example.kotlinserverside.repository.ItemRepository
import com.example.kotlinserverside.entity.Item
import com.ninjasquad.springmockk.MockkBean
import io.mockk.every
import io.mockk.verify
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ItemServiceTests(@Autowired private val itemService: ItemService) {

    @MockkBean private lateinit var mockItemRepository: ItemRepository

    val testItem1 = Item(id = 1, name = "test1", price = 100)
    val testItem2 = Item(id = 2, name = "test2", price = 200)
    val testItems = listOf(testItem1, testItem2)

    @Test
    fun testGetItemsWithUpperCase() {
        every { mockItemRepository.findAll() } returns testItems
        val expectItem1 = Item(id = 1, name = "TEST1", price = 100)
        val expectItem2 = Item(id = 2, name = "TEST2", price = 200)
        val expectItems = listOf(expectItem1, expectItem2)

        Assertions.assertEquals(expectItems, itemService.getItemsWithUpperCase())
        verify { mockItemRepository.findAll() }
    }
}