package com.example.jenugumpuapp.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "harvest")
data class Harvest(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val date: String,
    val location: String,
    val quantity: Int,
    val floralSource: String,
    val batchId: String

)