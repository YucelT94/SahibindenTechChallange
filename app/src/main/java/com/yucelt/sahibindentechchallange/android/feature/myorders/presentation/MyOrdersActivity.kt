package com.yucelt.sahibindentechchallange.android.feature.myorders.presentation

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.yucelt.sahibindentechchallange.android.R
import com.yucelt.sahibindentechchallange.android.databinding.ActivityMyOrdersBinding
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

/**
 * Created by YucelTerlemezoglu on 22.09.2019.
 */
class MyOrdersActivity : DaggerAppCompatActivity() {

    private lateinit var activityMyOrdersBinding: ActivityMyOrdersBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: MyOrdersViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(MyOrdersViewModel::class.java)
    }

    companion object {
        private val TAG = MyOrdersActivity::class.java.name
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityMyOrdersBinding = DataBindingUtil.setContentView(this, R.layout.activity_my_orders)


    }
}