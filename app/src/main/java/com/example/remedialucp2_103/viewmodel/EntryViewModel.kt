package com.example.remedialucp2_103.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.remedialucp2_103.repositori.RepositoriBuku
import com.example.remedialucp2_103.room.Buku

class EntryViewModel(private val repositoriBuku: RepositoriBuku) : ViewModel() {

    var uiStateBuku by mutableStateOf(UIStateBuku())
        private set

    // Fungsi untuk memvalidasi input
    private fun validasiInput(uiState: DetailBuku = uiStateBuku.detailBuku): Boolean {
        return with(uiState) {
            nama.isNotBlank() && author.isNotBlank() && tahunTerbit.isNotBlank() && kategoriBuku.isNotBlank()
        }
    }

    fun updateUIState(detailBuku: DetailBuku) {
        uiStateBuku =
            UIStateBuku(
                detailBuku = detailBuku,
                validasiInput(detailBuku)
            )
    }

    // Fungsi untuk menyimpan data yang di-entry
    suspend fun saveBuku() {
        if (validasiInput()) {
            repositoriBuku.insertBuku(uiStateBuku.detailBuku.toBuku())
        }
    }
}

data class UIStateBuku(
    val detailBuku: DetailBuku = DetailBuku(),
    val isEntryValid: Boolean = false
)

data class DetailBuku(
    val id: Int = 0,
    val nama: String = "",
    val author: String = "",
    val tahunTerbit: String = "",
    val kategoriBuku: String = ""
)

fun DetailBuku.toBuku(): Buku = Buku(
    id = id,
    nama = nama,
    author = author,
    tahunTerbit = tahunTerbit,
    kategoriBuku = kategoriBuku
)

fun Buku.toUIStateBuku(isEntryValid: Boolean = false): UIStateBuku =
    UIStateBuku(
        detailBuku = this.toDetailBuku(),
        isEntryValid = isEntryValid
    )

fun Buku.toDetailBuku(): DetailBuku = DetailBuku(
    id = id,
    nama = nama,
    author = author,
    tahunTerbit = tahunTerbit,
    kategoriBuku = kategoriBuku
)