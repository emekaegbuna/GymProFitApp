package com.example.gymprofitapp.repository.auth

import com.example.gymprofitapp.model.login.TokenModel
import com.example.gymprofitapp.model.login.UserLoginModel
import com.example.gymprofitapp.network.UserLoginService
import com.example.gymprofitapp.repository.auth.AuthRepository
import com.example.gymprofitapp.utils.DataState
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(private val userLoginService: UserLoginService):
    AuthRepository {

    override suspend fun getUserLogin(userLoginModel: UserLoginModel): Flow<DataState<TokenModel>> {
        return flow {
            emit(DataState.Loading)
            delay(1000)
            try {
                val userToken = userLoginService.userLogin(userLoginModel)

            } catch (e: Exception) {
                emit(DataState.Error(e))
            }
        }
    }

    override suspend fun getUserSignup(userLoginModel: UserLoginModel): Flow<DataState<TokenModel>> {
        return flow {
            emit(DataState.Loading)
            delay(1000)
            try {
                val userToken = userLoginService.userSignup(userLoginModel)

            } catch (e: Exception) {
                emit(DataState.Error(e))
            }
        }
    }

}