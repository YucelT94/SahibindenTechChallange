package com.yucelt.sahibindentechchallange.android.di.module

import com.google.gson.Gson
import com.yucelt.sahibindentechchallange.android.base.room.AppDatabase
import com.yucelt.sahibindentechchallange.android.feature.myorders.data.MyOrdersApiService
import com.yucelt.sahibindentechchallange.android.feature.myorders.data.repo.MyOrdersDataRepository
import com.yucelt.sahibindentechchallange.android.feature.myorders.domain.MyOrdersRepository
import com.yucelt.sahibindentechchallange.android.util.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by YucelTerlemezoglu on 21.09.2019.
 */
@Module(includes = [ApplicationModule::class])
class NetworkModule {

    @Provides
    @Singleton
    fun providesRetrofit(
        gsonConverterFactory: GsonConverterFactory,
        rxJava2CallAdapterFactory: RxJava2CallAdapterFactory,
        okHttpClient: OkHttpClient
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(gsonConverterFactory)
            .addCallAdapterFactory(rxJava2CallAdapterFactory)
            .client(okHttpClient)
            .build()
    }


    @Provides
    @Singleton
    fun providesGson(): Gson {
        return Gson()
    }

    @Provides
    @Singleton
    fun providesGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Provides
    @Singleton
    fun providesRxJavaCallAdapterFactory(): RxJava2CallAdapterFactory {
        return RxJava2CallAdapterFactory.create()
    }

    @Singleton
    @Provides
    fun provideService(retrofit: Retrofit): MyOrdersApiService {
        return retrofit.create(MyOrdersApiService::class.java)
    }

    // TODO: Servisleri ekle
    @Singleton
    @Provides
    fun provideMyOrdersRepository(
        appDatabase: AppDatabase,
        service: MyOrdersApiService
    ): MyOrdersRepository {
        return MyOrdersDataRepository(appDatabase, service)
    }
}