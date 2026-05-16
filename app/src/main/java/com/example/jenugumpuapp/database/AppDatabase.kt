package com.example.jenugumpuapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.jenugumpuapp.database.HarvestDao
import com.example.jenugumpuapp.model.Harvest


@Database(entities = [Harvest::class],
    version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {


    abstract fun harvestDao(): HarvestDao
}