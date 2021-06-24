package com.example.gymprofitapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "workout")
data class WorkoutModel(
    @PrimaryKey
    val id: UUID?,
    val workout_name: String,
    val level:String,
    val focus_area:String?,
    val calorie_usage: Int?,
    val workout_description: String,
    val duration: Int,
    val workout_img_uri: String)
