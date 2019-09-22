package com.yucelt.sahibindentechchallange.android.component.expandableitem

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.transition.*
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
class ExpandableItemView :
    BaseViewComponent<ComponentExpandableItemBinding, ExpandableItemViewModel> {

    companion object {
        val LAYOUT_RES_ID = R.layout.component_expandable_item
    }

    var eventHandler: ExpandableItemEventHandler? = null


    constructor(context: Context) : this(context, null)

    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
        context,
        attrs,
        defStyleAttr
    )

    override fun provideLayoutId() = LAYOUT_RES_ID

    override fun provideViewModel() = ExpandableItemViewModel()

    override fun bindViewModel(binding: ComponentExpandableItemBinding?) {
        binding?.viewModel = viewModel
        init()
    }

    private fun init() {
        dataBinding.run {
            setBackgroundColor(ContextCompat.getColor(context, R.color.colorPrimary))

            rootView.setOnClickListener {
                val expanded = accounts.visibility != View.VISIBLE
                this@ExpandableItemView.viewModel?.expandOrCollapse(expanded)

                TransitionManager.beginDelayedTransition(accounts.rootView as ViewGroup,
                    AutoTransition()
                        .setOrdering(TransitionSet.ORDERING_TOGETHER)
                        .addListener(object : TransitionListenerAdapter() {
                            override fun onTransitionEnd(transition: Transition) {
                                eventHandler?.onExpandedOrCollapsed(expanded)
                            }
                        })
                )
            }
        }
    }
}