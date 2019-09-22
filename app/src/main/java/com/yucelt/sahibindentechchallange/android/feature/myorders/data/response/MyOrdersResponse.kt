package com.yucelt.sahibindentechchallange.android.feature.myorders.data.response

import com.google.gson.annotations.SerializedName
import com.yucelt.sahibindentechchallange.android.base.network.BaseResponse
import com.yucelt.sahibindentechchallange.android.component.expandableitem.ExpandableItemViewData

/**
 * Created by YucelTerlemezoglu on 21.09.2019.
 */
class MyOrdersResponse : BaseResponse() {
    @SerializedName("date")
    var date: String? = null

    @SerializedName("month")
    var month: String? = null

    @SerializedName("marketName")
    var marketName: String? = null

    @SerializedName("orderName")
    var orderName: String? = null

    @SerializedName("productPrice")
    var productPrice: Double? = null

    @SerializedName("productState")
    var productState: String? = null

    @SerializedName("productDetail")
    var productDetail: ProductDetail? = null

    /**
     * Product Model of Response
     */
    class ProductDetail {

        @SerializedName("orderDetail")
        val orderDetail: String? = null

        @SerializedName("summaryPrice")
        val summaryPrice: Double? = null
    }

    fun toExpandableItemViewData() = ExpandableItemViewData(
        date,
        month,
        marketName,
        orderName,
        productPrice,
        productState,
        productDetail?.orderDetail,
        productDetail?.summaryPrice
    )
}