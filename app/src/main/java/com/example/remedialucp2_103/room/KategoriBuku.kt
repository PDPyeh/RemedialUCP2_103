package com.example.remedialucp2_103.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tblKategoriBuku")
data class KategoriBuku (
    @PrimaryKey(autoGenerate = true)
    val idKategori : Int = 0,
    val nama : String,
)