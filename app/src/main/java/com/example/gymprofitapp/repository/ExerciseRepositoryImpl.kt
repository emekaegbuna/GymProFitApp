package com.example.gymprofitapp.repository

import com.example.gymprofitapp.model.ExerciseModel
import com.example.gymprofitapp.model.login.TokenModel
import com.example.gymprofitapp.network.ExerciseService
import com.example.gymprofitapp.utils.DataState
import kotlinx.coroutines.flow.Flow
import java.util.*

class ExerciseRepositoryImpl(exerciseService: ExerciseService): ExerciseRepository {
    override suspend fun getExercises(token: TokenModel): Flow<DataState<List<ExerciseModel>>> {
        TODO("Not yet implemented")
    }

    override suspend fun getExerciseByExerciseId(
        token: TokenModel,
        exercise_id: UUID
    ): Flow<DataState<ExerciseModel>> {
        TODO("Not yet implemented")
    }

    override suspend fun getExercisesByWorkoutId(
        token: TokenModel,
        workout_id: UUID
    ): Flow<DataState<List<ExerciseModel>>> {
        TODO("Not yet implemented")
    }

    override suspend fun deleteExerciseByExerciseId(
        token: TokenModel,
        exercise_id: UUID
    ): Flow<DataState<Int>> {
        TODO("Not yet implemented")
    }

    override suspend fun postExercise(
        token: TokenModel,
        exercise: ExerciseModel
    ): Flow<DataState<ExerciseModel>> {
        TODO("Not yet implemented")
    }

    override suspend fun postExerciseToWorkoutByWorkoutId(
        token: TokenModel,
        exercise_id: UUID,
        workout_id: UUID
    ): Flow<DataState<ExerciseModel>> {
        TODO("Not yet implemented")
    }

    override suspend fun updateExerciseByExerciseId(
        token: TokenModel,
        exercise_id: UUID,
        exercise: ExerciseModel
    ): Flow<DataState<ExerciseModel>> {
        TODO("Not yet implemented")
    }
}