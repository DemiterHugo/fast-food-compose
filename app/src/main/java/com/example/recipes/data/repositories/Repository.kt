package com.example.recipes.data.repositories

import com.example.recipes.data.entities.Item

abstract class Repository<T: Item> {

    private var cache: List<T> = emptyList()

    internal suspend fun get(getAction: suspend ()-> List<T>): List<T>{
        if(cache.isEmpty()){
            cache = getAction()
        }
        return  cache
    }
}