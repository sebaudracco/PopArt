package com.example.poparticlestest.core.koin.module

import com.example.poparticlestest.core.base.ApiInterceptor
import com.example.poparticlestest.core.base.generateCustomClient
import com.example.poparticlestest.core.base.providerRetrofit
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module



const val TIMEOUT_TRANSACTIONAL   = 150L
const val RETROFIT_API = "RetrofitApi"
const val HTTP_CLIENT = "OkHttpClient"
const val HEADER_CONTENT_TYPE = "Content-Type"
const val CONTENT_TYPE      = "application/json"

const val AUTH= "Authorization"
val ARTICLE_API_KEY = "Bearer "+"f4zL4tULmghgTFeT1A4HrZ8rzeKbzKjO"
val API_ARTICLE_BASE_URL= "https://api.nytimes.com/svc/mostpopular/v2/"


val testApiArticleModule = module {
    single(named(HTTP_CLIENT)) { providerHttpClient(get(), get()) }
    single(named(RETROFIT_API)) {
        providerRetrofit(
            url = API_ARTICLE_BASE_URL,
            client = get(named(HTTP_CLIENT))
        )
    }
}

fun providerHttpClient(
    httpLoggingInterceptor: HttpLoggingInterceptor,
    apiInterceptor: ApiInterceptor,
): OkHttpClient {
    val httpClientBuilder = generateCustomClient(TIMEOUT_TRANSACTIONAL)
    httpClientBuilder.addInterceptor { chain: Interceptor.Chain ->
        val builder = generateBasicRequest(chain)
        builder.addHeader(HEADER_CONTENT_TYPE, CONTENT_TYPE)
        builder.addHeader(AUTH, ARTICLE_API_KEY)
        chain.proceed(builder.build())
    }
    httpClientBuilder.addInterceptor(httpLoggingInterceptor)
    httpClientBuilder.addInterceptor(apiInterceptor)
    return httpClientBuilder.build()
}
public fun generateBasicRequest(
    chain: Interceptor.Chain
): Request.Builder {
    return chain.request().newBuilder()

}