package com.yucelt.sahibindentechchallange.android.component.expandableitem

import androidx.databinding.ObservableField
import com.yucelt.sahibindentechchallange.android.base.basecomponent.BaseComponentViewModel

class ExpandableItemViewModel : BaseComponentViewModel<ExpandableItemViewData>() {

    val dateObservable = ObservableField<String>()
    val monthObservable = ObservableField<String>()
    val marketNameObservable = ObservableField<String>()
    val orderNameObservable = ObservableField<String>()
    val productPriceObservable = ObservableField<Int>()
    val productStateObservable = ObservableField<String>()
    val orderDetailObservable = ObservableField<String>()
    val summaryPriceObservable = ObservableField<Int>()

    val detailViewVisibilityObservable = ObservableField<Boolean>()

    override fun handleInput(viewData: ExpandableItemViewData?) {
        viewData?.run {
            dateObservable.set(date)
            monthObservable.set(month)
            marketNameObservable.set(marketName)
            orderNameObservable.set(orderName)
            productPriceObservable.set(productPrice)
            productStateObservable.set(productState)
            orderDetailObservable.set(orderDetail)
            summaryPriceObservable.set(summaryPrice)
        }
    }

    fun expandOrCollapse(expanded: Boolean) {
        detailViewVisibilityObservable.set(expanded)
    }
}