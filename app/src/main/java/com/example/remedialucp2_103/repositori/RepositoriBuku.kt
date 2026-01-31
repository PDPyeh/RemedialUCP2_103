package com.example.remedialucp2_103.repositori

import com.example.remedialucp2_103.room.Buku
import com.example.remedialucp2_103.room.BukuDao
import kotlinx.coroutines.flow.Flow

interface RepositoriBuku{
    fun getAllBukuStream(): Flow<List<Buku>>
    suspend fun insertBuku(buku: Buku)
    fun getBukuStream(id: Int): Flow<Buku?>
    suspend fun deleteBuku(buku: Buku)
    suspend fun updateBuku(buku: Buku)
}

class OfflineRepositoriBuku(
    private val bukuDao: BukuDao
): RepositoriBuku {
    override fun getAllBukuStream(): Flow<List<Buku>> = bukuDao.getAllBuku()
    override suspend fun insertBuku(buku: Buku) = bukuDao.insert(buku)
    override fun getBukuStream(id: Int): Flow<Buku?> = bukuDao.getBuku(id)
    override suspend fun deleteBuku(buku: Buku) = bukuDao.delete(buku)
    override suspend fun updateBuku(buku: Buku) = bukuDao.update(buku)
}