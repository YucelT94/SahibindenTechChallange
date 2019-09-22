package com.yucelt.sahibindentechchallange.android.component.expandableitem

import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import com.yucelt.sahibindentechchallange.android.R
import com.yucelt.sahibindentechchallange.android.base.basecomponent.BaseComponentViewModel
import com.yucelt.sahibindentechchallange.android.util.Month

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
    val detailViewVisibilityObservable = ObservableField<Boolean>(false)

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
            colorObservable.set(setStatusColor(productState))
        }
    }

    fun expandOrCollapse(expanded: Boolean) {
        detailViewVisibilityObservable.set(expanded)
    }

    private fun setStatusColor(productState: String?): Int {
        return when {
            productState.equals("Hazırlanıyor") -> R.color.orange
            productState.equals("Onay Bekliyor") -> R.color.red
            productState.equals("Yolda") -> R.color.green
            else -> R.color.gray
        }

    }
}