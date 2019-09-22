package com.yucelt.sahibindentechchallange.android.feature.myorders.data.repo

import com.yucelt.sahibindentechchallange.android.base.room.AppDatabase
import com.yucelt.sahibindentechchallange.android.feature.myorders.data.MyOrdersApiService
import com.yucelt.sahibindentechchallange.android.feature.myorders.data.response.MyOrdersResponse
import com.yucelt.sahibindentechchallange.android.feature.myorders.domain.MyOrdersRepository
import io.reactivex.Single

/**
 * Created by YucelTerlemezoglu on 22.09.2019.
 */
class MyOrdersDataRepository(
    private val database: AppDatabase,
    private val service: MyOrdersApiService
) : MyOrdersRepository {
    override fun getMyOrders(): Single<List<MyOrdersResponse>> = service.getMyOrders()
}