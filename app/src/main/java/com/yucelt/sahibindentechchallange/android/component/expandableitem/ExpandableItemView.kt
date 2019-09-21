package com.yucelt.sahibindentechchallange.android.component.expandableitem

import android.content.Context
import android.util.AttributeSet
import androidx.databinding.BindingAdapter
import com.yucelt.sahibindentechchallange.android.R
import com.yucelt.sahibindentechchallange.android.base.basecomponent.BaseViewComponent
import com.yucelt.sahibindentechchallange.android.databinding.ComponentExpandableItemBinding

/**
 * Created by YucelTerlemezoglu on 21.09.2019.
 */

@BindingAdapter("viewData")
fun ExpandableItemView.setData(viewData: ExpandableItemViewData?) {
    viewData?.let { viewModel?.handleInput(it) }
}


/**
 * Kullanım şekli:
 *
 * <com.yucelt.sahibindentechchallange.android.component.expandableitem.ExpandableItemView
 *      viewData="@{viewModel.viewDataObservableField}" />
 */
class ExpandableItemView : BaseViewComponent<ComponentExpandableItemBinding, ExpandableItemViewModel>  {

    companion object {
        val LAYOUT_RES_ID = R.layout.component_expandable_item
    }

    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun provideLayoutId() = LAYOUT_RES_ID

    override fun provideViewModel() = ExpandableItemViewModel()

    override fun bindViewModel(binding: ComponentExpandableItemBinding?) {
        binding?.viewModel = viewModel
    }
}