package com.example.kotlinserversidefunctional.repository

import com.example.kotlinserversidefunctional.entity.Item
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ItemRepository : CrudRepository<Item, Int>