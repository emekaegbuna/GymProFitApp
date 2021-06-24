package com.example.gymprofitapp.repository

import com.example.gymprofitapp.model.ExerciseModel
import com.example.gymprofitapp.model.WorkoutModel
import com.example.gymprofitapp.model.login.TokenModel
import com.example.gymprofitapp.utils.DataState
import kotlinx.coroutines.flow.Flow
import java.util.*

interface ExerciseRepository {


    suspend fun getExercises(token: TokenModel): Flow<DataState<List<ExerciseModel>>>

    suspend fun getExerciseByExerciseId(token: TokenModel, exercise_id: UUID): Flow<DataState<ExerciseModel>>

    suspend fun getExercisesByWorkoutId(token: TokenModel, workout_id: UUID): Flow<DataState<List<ExerciseModel>>>

    suspend fun deleteExerciseByExerciseId(token: TokenModel, exercise_id: UUID): Flow<DataState<Int>>

    suspend fun postExercise(token: TokenModel, exercise: ExerciseModel): Flow<DataState<ExerciseModel>>

    suspend fun postExerciseToWorkoutByWorkoutId(token: TokenModel, exercise_id: UUID, workout_id: UUID): Flow<DataState<ExerciseModel>>

    suspend fun updateExerciseByExerciseId(token: TokenModel, exercise_id: UUID, exercise: ExerciseModel): Flow<DataState<ExerciseModel>>
}