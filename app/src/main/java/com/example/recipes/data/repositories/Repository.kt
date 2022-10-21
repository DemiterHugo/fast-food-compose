package com.example.recipes.data.repositories

import com.example.recipes.data.database.Item
import com.example.recipes.data.network.entities.Ei
import com.example.recipes.data.network.entities.tryCall

abstract class Repository<T: Item> {

    private var cache: List<T> = emptyList()

    internal suspend fun get(getAction: suspend () -> List<T>): Ei<List<T>> {
        return tryCall(action = {
            if (cache.isEmpty()) {
                //withTimeout(500){}
                    cache = getAction()
            }
            cache
        })
    }

    internal suspend fun findById(id:Int, actionRemote: suspend ()-> T): Ei<T>{
        return tryCall {
            val item = cache.find{
                it.id == id
            }
            item ?: actionRemote()
        }
    }
}