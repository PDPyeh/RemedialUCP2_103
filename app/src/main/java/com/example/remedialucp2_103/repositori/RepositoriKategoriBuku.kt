package com.example.remedialucp2_103.repositori


import com.example.remedialucp2_103.room.KategoriBuku
import com.example.remedialucp2_103.room.KategoriBukuDao
import kotlinx.coroutines.flow.Flow

interface RepositoriKategoriBuku{
    fun getAllKatBukuStream(): Flow<List<KategoriBuku>>
    suspend fun insertKatBuku(katbuku: KategoriBuku)
    fun getKatBukuStream(id: Int): Flow<KategoriBuku?>
    suspend fun deleteKatBuku(katbuku: KategoriBuku)
    suspend fun updateKatBuku(katbuku: KategoriBuku)
}

class OfflineRepositoriKategoriBuku(
    private val katbukuDao: KategoriBukuDao
): RepositoriKategoriBuku {
    override fun getAllKatBukuStream(): Flow<List<KategoriBuku>> = katbukuDao.getAllKategoriBuku()
    override suspend fun insertKatBuku(katbuku: KategoriBuku) = katbukuDao.insert(katbuku)
    override fun getKatBukuStream(id: Int): Flow<KategoriBuku?> = katbukuDao.getKategoriBuku(id)
    override suspend fun deleteKatBuku(katbuku: KategoriBuku) = katbukuDao.kategoridelete(katbuku)
    override suspend fun updateKatBuku(katbuku: KategoriBuku) = katbukuDao.kategoridelete(katbuku)
}