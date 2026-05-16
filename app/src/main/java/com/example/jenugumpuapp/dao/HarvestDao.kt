package com.example.jenugumpuapp.database

import androidx.room.Dao
import androidx.room.Entity
import androidx.room.Insert
import androidx.room.Query
import com.example.jenugumpuapp.model.Harvest

@Dao
interface HarvestDao {

    @Insert
    suspend fun insertHarvest(harvest: Harvest)

    @Query("SELECT SUM(quantity) FROM harvest")
    suspend fun getTotalStock(): Int?

    @Query("SELECT * FROM harvest")
    suspend fun getAllHarvests(): List<Harvest>

    @Query("SELECT COUNT(*) FROM harvest")
    suspend fun getHarvestCount(): Int

    @Query("SELECT COUNT(DISTINCT batchId) FROM harvest")
    suspend fun getBatchCount(): Int


}