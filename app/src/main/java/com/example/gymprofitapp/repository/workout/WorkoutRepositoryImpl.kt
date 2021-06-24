package com.example.gymprofitapp.repository.workout

import com.example.gymprofitapp.model.WorkoutModel
import com.example.gymprofitapp.model.login.TokenModel
import com.example.gymprofitapp.network.WorkoutService
import com.example.gymprofitapp.repository.workout.WorkoutRepository
import com.example.gymprofitapp.utils.DataState
import kotlinx.coroutines.flow.Flow
import java.util.*

class WorkoutRepositoryImpl(workoutService: WorkoutService): WorkoutRepository {
    override suspend fun getWorkouts(token: TokenModel): Flow<DataState<List<WorkoutModel>>> {
        TODO("Not yet implemented")
    }

    override suspend fun getWorkoutByWorkoutId(
        token: TokenModel,
        workout_id: UUID
    ): Flow<DataState<WorkoutModel>> {
        TODO("Not yet implemented")
    }

    override suspend fun deleteWorkoutByWorkoutId(
        token: TokenModel,
        workout_id: UUID
    ): Flow<DataState<Int>> {
        TODO("Not yet implemented")
    }

    override suspend fun postWorkout(
        token: TokenModel,
        workout: WorkoutModel
    ): Flow<DataState<WorkoutModel>> {
        TODO("Not yet implemented")
    }

    override suspend fun updateWorkoutByWorkoutId(
        token: TokenModel,
        workout_id: UUID,
        workout: WorkoutModel
    ): Flow<DataState<WorkoutModel>> {
        TODO("Not yet implemented")
    }
}