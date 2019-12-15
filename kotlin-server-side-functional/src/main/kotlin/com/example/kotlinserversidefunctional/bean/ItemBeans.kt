package com.example.kotlinserversidefunctional.bean

import com.example.kotlinserversidefunctional.handler.ItemHandler
import com.example.kotlinserversidefunctional.router.ApiRouter
import org.springframework.context.support.beans

fun itemBeans() = beans {
    bean<ApiRouter>() // 1
    bean { ref<ApiRouter>().itemRouter() } // 2
    bean<ItemHandler>() // 1
}