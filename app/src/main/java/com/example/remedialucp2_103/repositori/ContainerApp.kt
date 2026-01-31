package com.example.remedialucp2_103.repositori

import android.app.Application
import android.content.Context
import com.example.remedialucp2_103.room.BukuDao
import com.example.remedialucp2_103.room.DatabaseBuku

interface ContainerApp {
    val repositoriBuku : RepositoriBuku
    val repositoriKategoriBuku : RepositoriKategoriBuku
}

class ContainerDataApp(private val context: Context):
    ContainerApp{
    override val repositoriBuku: RepositoriBuku by lazy {
        OfflineRepositoriBuku(
            bukuDao = DatabaseBuku.getDatabase(context).bukuDao())
    }
    override val repositoriKategoriBuku: RepositoriKategoriBuku by lazy {
        OfflineRepositoriKategoriBuku(
            katbukuDao = DatabaseBuku.getDatabase(context).katbukuDao())
    }
}

class AplikasiBuku : Application(){
    lateinit var container: ContainerApp

    override fun onCreate(){
        super.onCreate()
        container = ContainerDataApp(context = this)
    }

}
