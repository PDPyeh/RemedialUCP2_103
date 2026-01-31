package com.example.remedialucp2_103.room

import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Buku::class, KategoriBuku::class], version = 1, exportSchema = false)
abstract class DatabaseBuku : RoomDatabase() {
    abstract fun bukuDao() : BukuDao
    abstract fun katbukuDao(): KategoriBukuDao

    companion object {
        @Volatile
        private var Instance: DatabaseBuku? = null

        fun getDatabase(context: android.content.Context): DatabaseBuku {
            return (Instance?: synchronized(this){
                Room.databaseBuilder(
                    context, klass= DatabaseBuku::class.java,
                    "buku_database")
                    .build().also{Instance=it}
            })
        }
    }
}