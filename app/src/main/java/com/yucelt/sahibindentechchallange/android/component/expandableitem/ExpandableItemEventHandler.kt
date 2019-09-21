package com.yucelt.sahibindentechchallange.android.component.expandableitem

import com.yucelt.sahibindentechchallange.android.base.basecomponent.BaseComponentEventHandler

/**
 * Created by YucelTerlemezoglu on 21.09.2019.
 */
interface ExpandableItemEventHandler : BaseComponentEventHandler{

    /**
     * ExpandableItemView expanded or collapsed callback
     */
    fun onExpandedOrCollapsed(expanded: Boolean)
}