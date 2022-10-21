package com.example.recipes.data.network

import com.example.recipes.ApiKey
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class QueryInterceptor @Inject constructor(@ApiKey val key: String): Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val originalUrl = original.url

        val url = originalUrl.newBuilder()
            .addQueryParameter("apiKey",key)
            .build()

        val request = original.newBuilder().url(url).build()

        return chain.proceed(request)
    }


}