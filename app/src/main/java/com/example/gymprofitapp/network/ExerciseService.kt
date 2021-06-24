package com.example.gymprofitapp.network

import com.example.gymprofitapp.model.ExerciseModel
import com.example.gymprofitapp.model.WorkoutModel
import com.example.gymprofitapp.model.login.TokenModel
import com.example.gymprofitapp.utils.DataState
import kotlinx.coroutines.flow.Flow
import retrofit2.http.*
import java.util.*

interface ExerciseService {

    @GET("/exercise")
    suspend fun getExercises(@Header("token") token: TokenModel): List<ExerciseModel>

    @GET("/exercise")
    suspend fun getExercisesByWorkoutId(@Header("token") token: TokenModel, @Query("workout_id") workout_id: UUID): List<ExerciseModel>

    @GET("exercise/{exercise_id}")
    suspend fun getExerciseByExerciseId(@Header("token") token: TokenModel, @Path("exercise_id")exercise_id: UUID): ExerciseModel

    @POST("exercise")
    suspend fun addExercise(@Header("token") token: TokenModel, @Body exercise: ExerciseModel): ExerciseModel

    @POST("exercise/{exercise_id}/{workout_id}")
    suspend fun postExerciseToWorkoutByWorkoutId(@Header("token") token: TokenModel, @Path("exercise_id") exercise_id: UUID, @Path("workout_id") workout_id: UUID): Flow<DataState<ExerciseModel>>

    @DELETE("exercise/{exercise_id}")
    suspend fun deleteExercise(@Header("token") token: TokenModel, @Path("exercise_id") exercise_id: UUID): Int

    @PUT("exercise/{exercise_id}")
    suspend fun updateExercise(@Header("token") token: TokenModel, @Path("exercise_id") exercise_id: UUID, @Body workout: ExerciseModel): ExerciseModel
}