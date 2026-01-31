package com.example.remedialucp2_103.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tblBuku")
data class Buku (
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    val nama : String,
    val author : String,
    val tahunTerbit : String,
    val kategoriBuku: KategoriBuku
)