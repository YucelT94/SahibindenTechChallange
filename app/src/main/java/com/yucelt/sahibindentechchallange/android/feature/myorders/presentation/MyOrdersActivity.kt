package com.yucelt.sahibindentechchallange.android.feature.myorders.presentation

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.yucelt.sahibindentechchallange.android.R
import com.yucelt.sahibindentechchallange.android.databinding.ActivityMyOrdersBinding
import com.yucelt.sahibindentechchallange.android.feature.login.presentation.LoginActivity
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

/**
 * Created by YucelTerlemezoglu on 22.09.2019.
 */
class MyOrdersActivity : DaggerAppCompatActivity() {

    private lateinit var binding: ActivityMyOrdersBinding
    private var adapter: MyOrdersListAdapter? = null


    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: MyOrdersViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(MyOrdersViewModel::class.java)
    }

    companion object {
        private val TAG = MyOrdersActivity::class.java.name

        /**
         * Activity geçişi için intent oluşturma fonksiyonu
         */
        fun newIntent(context: Context) = Intent(context, MyOrdersActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = MyOrdersListAdapter()

        binding = DataBindingUtil.setContentView(this, R.layout.activity_my_orders)
        binding.run {
            myOrdersList.adapter = adapter
            myOrdersButton.setOnClickListener { refreshMyOrders() }
            logOutButton.setOnClickListener { showDialog() }
        }

        viewModel.adapterLiveData.observe(this@MyOrdersActivity, Observer {
            adapter?.addData(it)
        })

        viewModel.generataAdapterData()
    }

    override fun onBackPressed() {}

    private fun refreshMyOrders() {
        viewModel.generataAdapterData()
    }

    private fun showDialog() {
        val alert = AlertDialog.Builder(this)
        alert.setTitle("Çıkış")
        alert.setMessage("Çıkış yapmak istediğinize emin misiniz?")
        alert.setCancelable(false)
        alert.setPositiveButton("İstiyorum") { dialogInterface: DialogInterface, i: Int ->
            logOut()
        }
        alert.setNegativeButton("İstemiyorum") { dialogInterface: DialogInterface, i: Int ->
            dialogInterface.dismiss()
        }
        alert.show()
    }

    private fun logOut() {
        viewModel.logOut()
        startActivity(LoginActivity.newIntent(this@MyOrdersActivity))
    }
}