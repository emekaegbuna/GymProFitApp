package com.example.gymprofitapp.network

import com.example.gymprofitapp.model.WorkoutModel
import com.example.gymprofitapp.model.login.TokenModel
import com.example.gymprofitapp.model.login.UserLoginModel
import retrofit2.http.*
import java.util.*

interface WorkoutService {

    @GET("workout")
    suspend fun getWorkouts(@Header("token") token: TokenModel): List<WorkoutModel>

    @GET("workout")
    suspend fun getWorkoutByWorkoutId(@Header("token") token: TokenModel, @Path("workout_id")workout_id: UUID): WorkoutModel

    @POST("workout")
    suspend fun addWorkout(@Header("token") token: TokenModel, @Body workout: WorkoutModel): WorkoutModel

    @DELETE("workout")
    suspend fun deleteWorkout(@Header("token") token: TokenModel, @Path("workout_id") workout_id: UUID): Int

    @PUT("workout")
    suspend fun updateWorkout(@Header("token") token: TokenModel, @Path("workout_id") workout_id: UUID, @Body workout: WorkoutModel): WorkoutModel
}