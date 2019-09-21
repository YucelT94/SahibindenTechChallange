package com.yucelt.sahibindentechchallange.android.base.basecomponent

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**
 * Created by YucelTerlemezoglu on 21.09.2019.
 */
abstract class BaseViewComponent<DB : ViewDataBinding, VM : BaseComponentViewModel>(
    context: Context,
    attributeSet: AttributeSet? = null,
    int: Int = 0
) : ConstraintLayout(context, attributeSet, int) {
    var binding: DB? = null
    var viewModel: VM? = null

    init {
        this.a(context)
    }

    private fun a(context: Context) {
        if (this.isInEditMode) {
            View.inflate(context, this.provideLayoutId(), this)
        } else {
            this.viewModel = this.provideViewModel()
            this.binding = DataBindingUtil.inflate(
                LayoutInflater.from(context),
                this.provideLayoutId(),
                this,
                true
            )
            this.bindViewModel(this.binding)
        }
    }

    abstract fun provideViewModel(): VM

    abstract fun bindViewModel(binding: DB?)

    abstract fun provideLayoutId(): Int

}
