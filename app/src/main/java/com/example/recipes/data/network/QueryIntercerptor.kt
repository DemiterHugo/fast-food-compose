package com.example.recipes.data.network

import okhttp3.Interceptor
import okhttp3.Response

class QueryIntercerptor(val key: String): Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val originalUrl = original.url

        val url = originalUrl.newBuilder()
            .addQueryParameter("apikey",key)
            .build()

        val request = original.newBuilder().url(url).build()
        return chain.proceed(request)
    }


}