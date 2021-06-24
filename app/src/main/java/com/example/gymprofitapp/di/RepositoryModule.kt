package com.example.gymprofitapp.di

import com.example.gymprofitapp.network.ExerciseService
import com.example.gymprofitapp.network.UserLoginService
import com.example.gymprofitapp.network.WorkoutService
import com.example.gymprofitapp.repository.ExerciseRepository
import com.example.gymprofitapp.repository.ExerciseRepositoryImpl
import com.example.gymprofitapp.repository.workout.WorkoutRepository
import com.example.gymprofitapp.repository.workout.WorkoutRepositoryImpl
import com.example.gymprofitapp.repository.auth.AuthRepository
import com.example.gymprofitapp.repository.auth.AuthRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Singleton
    @Provides
    fun provideAuthRepository(userLoginService: UserLoginService): AuthRepository {
        return AuthRepositoryImpl(userLoginService)
    }

    @Singleton
    @Provides
    fun provideWorkoutRepository(workoutService: WorkoutService): WorkoutRepository {
        return WorkoutRepositoryImpl(workoutService)
    }

    @Singleton
    @Provides
    fun provideExerciseRepository(exerciseService: ExerciseService): ExerciseRepository {
        return ExerciseRepositoryImpl(exerciseService)
    }
}