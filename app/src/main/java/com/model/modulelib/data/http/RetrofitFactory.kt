package com.model.modulelib.data.http

import android.os.Build
import com.model.modulelib.utils.ConfigInfo
import com.model.modulelib.BuildConfig
import com.model.modulelib.data.UriConstant
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 *  Created tangxin
 *  Time 2018/9/28 下午7:10
 */
open class RetrofitFactory {

    companion object {
        var TAG = "RetrofitFactory"

        fun <T> createService(service: Class<T>, url: String): T {
            return Retrofit.Builder()
                    .baseUrl(url)
                    .client(buildOkHttpClient())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build().create(service)
        }

        fun <T> createService(service: Class<T>): T {
            return createService(service, BuildConfig.APOLLO_HOST)
        }

        //拦截器  添加链接信息  日志信息等
        private var mLoggingInterceptor = Interceptor { chain ->
            chain.proceed(chain.run {
                request().also {
                    it.newBuilder()
                            .header("User-Agent", String.format("Module/com.model.modulelib" +
                                    " (%s; OS Version %s; Channel %s)", BuildConfig.VERSION_CODE,
                                    Build.VERSION.RELEASE, ConfigInfo.sChannel))
                            .header("X-AUTH-DEVICETYPE", "")
                            .header("X-AUTH-OPENID", "18221498897")
                            .header("X-AUTH-TOKEN", UriConstant.GToken)
                            .method(it.method(), it.body())
                }
            })
        }

        //创建client
        private fun buildOkHttpClient(): OkHttpClient {
            return OkHttpClient.Builder()
                    .connectTimeout(60, TimeUnit.SECONDS)//设置连接超时
                    .readTimeout(60, TimeUnit.SECONDS)//读取超时
                    .writeTimeout(60, TimeUnit.SECONDS)//写入超时
                    .addInterceptor(mLoggingInterceptor)//添加日志拦截器：显示链接信息
                    .build()
        }
    }

}
