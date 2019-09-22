package com.yucelt.sahibindentechchallange.android.feature.login.presentation

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.yucelt.sahibindentechchallange.android.R
import com.yucelt.sahibindentechchallange.android.base.room.User
import com.yucelt.sahibindentechchallange.android.databinding.ActivityLoginBinding
import com.yucelt.sahibindentechchallange.android.feature.myorders.presentation.MyOrdersActivity
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

/**
 * Created by YucelTerlemezoglu on 22.09.2019.
 */
class LoginActivity : DaggerAppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private var loginId: Long = 0
    private var loginName: String? = null
    private var loginPassword: String? = null
    private var isRemember: Boolean = false

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: LoginViewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(LoginViewModel::class.java)
    }

    companion object {
        private val TAG = LoginActivity::class.java.name

        /**
         * Activity geçişi için intent oluşturma fonksiyonu
         */
        fun newIntent(context: Context) = Intent(context, LoginActivity::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)

        createUser()

        if (viewModel.userObservable.get()?.rememberMe == true) {
            startActivity(MyOrdersActivity.newIntent(this@LoginActivity))
        }

        binding.run {
            loginButton.setOnClickListener {
                if (userName.text.toString() == loginName && password.text.toString() == loginPassword) {
                    isRemember = rememberMe.isChecked
                    updateUser(loginId, isRemember)
                    startActivity(MyOrdersActivity.newIntent(this@LoginActivity))
                } else {
                    showDialog()
                }
            }
        }
    }

    private fun createUser() {
        viewModel.run {
            getUser()
            if (userObservable.get() == null) {
                createUser(User(1, "kariyer", "2019ADev", false))
            }

            userObservable.get()?.run {
                loginId = id
                loginName = name
                loginPassword = password
            }
        }
    }

    private fun updateUser(id: Long, remember: Boolean) {
        viewModel.run {
            updarteUser(id, remember)
        }
    }

    private fun showDialog() {
        val alert = AlertDialog.Builder(this)
        alert.setTitle("Uyarı")
        alert.setMessage("Kullanıcı adı ve ya şifreniz hatalı.")
        alert.setCancelable(false)
        alert.setPositiveButton("Tamam") { dialogInterface: DialogInterface, i: Int ->
            dialogInterface.dismiss()
        }
        alert.show()
    }
}