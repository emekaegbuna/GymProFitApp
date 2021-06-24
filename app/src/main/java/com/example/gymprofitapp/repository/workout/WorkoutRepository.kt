package com.example.gymprofitapp.repository.workout

import com.example.gymprofitapp.model.WorkoutModel
import com.example.gymprofitapp.model.login.TokenModel
import com.example.gymprofitapp.utils.DataState
import kotlinx.coroutines.flow.Flow
import java.util.*

interface WorkoutRepository {

    suspend fun getWorkouts(token: TokenModel): Flow<DataState<List<WorkoutModel>>>

    suspend fun getWorkoutByWorkoutId(token: TokenModel, workout_id: UUID): Flow<DataState<WorkoutModel>>

    suspend fun deleteWorkoutByWorkoutId(token: TokenModel, workout_id: UUID): Flow<DataState<Int>>

    suspend fun postWorkout(token: TokenModel, workout: WorkoutModel): Flow<DataState<WorkoutModel>>

    suspend fun updateWorkoutByWorkoutId(token: TokenModel, workout_id: UUID, workout: WorkoutModel): Flow<DataState<WorkoutModel>>
}