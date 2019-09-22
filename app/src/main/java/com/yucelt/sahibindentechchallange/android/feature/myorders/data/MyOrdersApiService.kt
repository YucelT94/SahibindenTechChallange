package com.yucelt.sahibindentechchallange.android.feature.myorders.data

import com.yucelt.sahibindentechchallange.android.feature.myorders.data.response.MyOrdersResponse
import io.reactivex.Single
import retrofit2.http.GET

/**
 * Created by YucelTerlemezoglu on 21.09.2019.
 */
interface MyOrdersApiService {
    /**
     * Get my orders list
     */
    @GET(".")
    fun getMyOrders(): Single<List<MyOrdersResponse>>
}
