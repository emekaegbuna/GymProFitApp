package com.example.gymprofitapp.model

import java.util.*

data class EquipmentModel(
    val equipment_id: UUID,
    val equipment_name: String,
    val equipment_description: String,
    val equipment_img_uri: String)
