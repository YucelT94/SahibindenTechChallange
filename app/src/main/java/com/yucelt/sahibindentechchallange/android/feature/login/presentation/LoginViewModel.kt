package com.yucelt.sahibindentechchallange.android.feature.login.presentation

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.yucelt.sahibindentechchallange.android.base.room.User
import com.yucelt.sahibindentechchallange.android.feature.login.domain.iteractor.LoginUseCase
import javax.inject.Inject

/**
 * Created by YucelTerlemezoglu on 22.09.2019.
 */
class LoginViewModel
@Inject constructor(private val useCase: LoginUseCase) : ViewModel() {
    private val TAG = LoginViewModel::class.java.simpleName
    val userObservable = ObservableField<User>()

    fun createUser(user: User) {
        useCase.insert(user)
        getUser()
    }

    fun getUser() = userObservable.set(useCase.getUser())

    fun updarteUser(id: Long, rememberMe: Boolean) = useCase.updateUser(id, rememberMe)
}