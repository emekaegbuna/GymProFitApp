package com.example.gymprofitapp.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gymprofitapp.model.login.TokenModel
import com.example.gymprofitapp.model.login.UserLoginModel
import com.example.gymprofitapp.repository.auth.AuthRepositoryImpl
import com.example.gymprofitapp.utils.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(val authRepositoryImpl: AuthRepositoryImpl) : ViewModel() {

    private val _dataState: MutableLiveData<DataState<TokenModel>> = MutableLiveData()
    val dataState: LiveData<DataState<TokenModel>>
        get() = _dataState

    fun getUserLogin(userLoginModel: UserLoginModel){

        viewModelScope.launch {
            authRepositoryImpl.getUserLogin(userLoginModel)
                .map{ dataState ->
                    _dataState.value = dataState
                }.launchIn(viewModelScope)

        }

    }

    fun getUserSignup(userLoginModel: UserLoginModel){

        viewModelScope.launch {
            authRepositoryImpl.getUserSignup(userLoginModel)
                .map{ dataState ->
                    _dataState.value = dataState
                }.launchIn(viewModelScope)

        }

    }
}