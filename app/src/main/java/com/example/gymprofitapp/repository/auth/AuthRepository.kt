package com.example.gymprofitapp.repository.auth

import com.example.gymprofitapp.model.login.TokenModel
import com.example.gymprofitapp.model.login.UserLoginModel
import com.example.gymprofitapp.utils.DataState
import kotlinx.coroutines.flow.Flow

interface AuthRepository {

    suspend fun getUserLogin(userLoginModel: UserLoginModel): Flow<DataState<TokenModel>>
    suspend fun getUserSignup(userLoginModel: UserLoginModel): Flow<DataState<TokenModel>>


}