package com.tekydevelop.data.common

import android.content.Context
import com.tekydevelop.data.R
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(val context: Context) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()

        val apiKey = context.resources.getString(R.string.lastfm_key)

        val originalHttpUrl = chain.request().url
        val url = originalHttpUrl.newBuilder().addQueryParameter("api_key", apiKey).build()
        request.url(url)

        return chain.proceed(request.build())
    }
}