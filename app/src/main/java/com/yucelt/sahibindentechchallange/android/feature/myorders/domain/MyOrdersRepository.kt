package com.yucelt.sahibindentechchallange.android.feature.myorders.domain

import com.yucelt.sahibindentechchallange.android.feature.myorders.data.response.MyOrdersResponse
import io.reactivex.Single

/**
 * Created by YucelTerlemezoglu on 22.09.2019.
 */
interface MyOrdersRepository {
    /**
     * Get my orders list datas
     */
    fun getMyOrders(): Single<List<MyOrdersResponse>>
}