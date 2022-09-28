package com.example.recipes.data.network.entities

import arrow.core.Either
import arrow.core.left
import arrow.core.right
import retrofit2.HttpException
import java.io.IOException


typealias  Ei<T> = Either<TypeError,T>

sealed class TypeError {
    class Server(val code: Int): TypeError()
    object Connectivity: TypeError()
    class Unknown(val message: String): TypeError()
}

fun Exception.toError(): TypeError{

    return when(this){
        is IOException -> TypeError.Connectivity
        is HttpException -> TypeError.Server(code())
        else -> TypeError.Unknown(message ?:"")
    }
}

inline fun <T> tryCall(action:()-> T):Ei<T>{
    return try {
        action().right()
    }catch (e: Exception){
        return e.toError().left()
    }
}