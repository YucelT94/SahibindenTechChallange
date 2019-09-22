package com.yucelt.sahibindentechchallange.android.component.expandableitem

import android.content.Context
import android.view.View
import androidx.annotation.ColorRes
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import com.yucelt.sahibindentechchallange.android.R
import com.yucelt.sahibindentechchallange.android.base.basecomponent.BaseComponentViewModel

/**
 * Created by YucelTerlemezoglu on 21.09.2019.
 */
class ExpandableItemViewModel : BaseComponentViewModel<ExpandableItemViewData>() {

    val dateObservable = ObservableField<String>()
    val monthObservable = ObservableField<String>()
    val marketNameObservable = ObservableField<String>()
    val orderNameObservable = ObservableField<String>()
    val productPriceObservable = ObservableField<String>()
    val productStateObservable = ObservableField<String>()
    val orderDetailObservable = ObservableField<String>()
    val summaryPriceObservable = ObservableField<String>()

    val colorObservable = ObservableInt()
    val detailViewVisibilityObservable = ObservableInt(View.GONE)

    override fun handleInput(viewData: ExpandableItemViewData?) {
        viewData?.run {
            dateObservable.set(date)
            monthObservable.set(month)
            marketNameObservable.set(marketName)
            orderNameObservable.set(orderName)
            productPriceObservable.set("$productPrice TL")
            productStateObservable.set(productState)
            orderDetailObservable.set(orderDetail)
            summaryPriceObservable.set("$summaryPrice TL")
            colorObservable.set(getStatusColor(productState))
        }
    }

    fun expandOrCollapse(expanded: Boolean) {
        if (expanded) detailViewVisibilityObservable.set(View.VISIBLE)
        else detailViewVisibilityObservable.set(View.GONE)
    }

    @ColorRes
    private fun getStatusColor(productState: String?): Int {
        return when {
            productState.equals("Hazırlanıyor") -> R.color.orange
            productState.equals("Onay Bekliyor") -> R.color.red
            productState.equals("Yolda") -> R.color.green
            else -> R.color.gray
        }
    }
}