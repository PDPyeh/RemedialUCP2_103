package com.example.remedialucp2_103.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface KategoriBukuDao {
    @Query("SELECT * from tblKategoriBuku ORDER BY nama ASC")
    fun getAllKategoriBuku(): Flow<List<KategoriBuku>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(kategoriBuku: KategoriBuku)

    @Query("SELECT * from tblKategoriBuku WHERE id = :id")
    fun getKategoriBuku(id: Int): Flow<KategoriBuku?>

    @Update
    suspend fun kategoriupdate(kategoriBuku: KategoriBuku)
    @Delete
    suspend fun kategoridelete(kategoriBuku: KategoriBuku)

}