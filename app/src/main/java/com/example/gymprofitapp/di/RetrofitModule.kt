package com.example.gymprofitapp.di

import com.example.gymprofitapp.network.ExerciseService
import com.example.gymprofitapp.network.UserLoginService
import com.example.gymprofitapp.network.WorkoutService
import com.example.gymprofitapp.utils.Constant.Companion.baseUrl
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    @Singleton
    @Provides
    fun provideGsonBuilder(): Gson{
        return GsonBuilder()
            .create()
    }

    @Singleton
    @Provides
    fun provideRetrofit(gson: Gson, okHttpClient: OkHttpClient): Retrofit{
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Singleton
    @Provides
    fun provideUserLoginService(retrofit: Retrofit): UserLoginService{
        return retrofit
            .create(UserLoginService::class.java)
    }

    @Singleton
    @Provides
    fun provideWorkoutService(retrofit: Retrofit): WorkoutService{
        return retrofit.create(WorkoutService::class.java)
    }

    @Singleton
    @Provides
    fun provideExerciseService(retrofit: Retrofit): ExerciseService{
        return retrofit.create(ExerciseService::class.java)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return OkHttpClient.Builder()
            .readTimeout(1000, TimeUnit.SECONDS)
            .writeTimeout(100, TimeUnit.SECONDS)
            .addInterceptor(loggingInterceptor).build()
    }

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor()
    }
}