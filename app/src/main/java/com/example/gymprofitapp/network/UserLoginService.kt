package com.example.gymprofitapp.network

import com.example.gymprofitapp.model.login.TokenModel
import com.example.gymprofitapp.model.login.UserLoginModel
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface UserLoginService {

    @POST("/auth/login")
    suspend fun userLogin(@Body userLoginModel: UserLoginModel): TokenModel?

    @POST("auth/signup")
    suspend fun userSignup(@Body userLoginModel: UserLoginModel): TokenModel?

    @POST("auth/refresh_token")
    suspend fun refreshToken(@Body userLoginModel: UserLoginModel, @Body tokenModel: TokenModel): TokenModel?
}