package com.yucelt.sahibindentechchallange.android.feature.myorders.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.yucelt.sahibindentechchallange.android.R
import com.yucelt.sahibindentechchallange.android.component.expandableitem.ExpandableItemViewData
import com.yucelt.sahibindentechchallange.android.databinding.RowListItemBinding
import java.util.*

/**
 * Created by YucelTerlemezoglu on 22.09.2019.
 */

class MyOrdersListAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val TAG = MyOrdersListAdapter::class.java.name

    private val viewDatas: MutableList<ExpandableItemViewData> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val holderPhotoBinding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context), R.layout.row_list_item, parent, false
        )
        return MyOrdersItemViewHolder(holderPhotoBinding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as? MyOrdersItemViewHolder)?.onBind(getItem(position))
    }

    private fun getItem(position: Int): ExpandableItemViewData {
        return viewDatas[position]
    }

    override fun getItemCount(): Int {
        return viewDatas.size
    }

    fun addData(list: List<ExpandableItemViewData>) {
        this.viewDatas.clear()
        this.viewDatas.addAll(list)
        notifyDataSetChanged()
    }


    inner class MyOrdersItemViewHolder(private val dataBinding: ViewDataBinding) :
        RecyclerView.ViewHolder(dataBinding.root) {
        fun onBind(viewData: ExpandableItemViewData) {
            val binding = dataBinding as RowListItemBinding
            binding.item = viewData
        }
    }
}