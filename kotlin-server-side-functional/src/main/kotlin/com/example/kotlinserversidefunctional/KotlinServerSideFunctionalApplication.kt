package com.example.kotlinserversidefunctional

import com.example.kotlinserversidefunctional.bean.itemBeans
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinServerSideFunctionalApplication

fun main(args: Array<String>) {
    runApplication<KotlinServerSideFunctionalApplication>(*args) {
		addInitializers(itemBeans())
	}
}
