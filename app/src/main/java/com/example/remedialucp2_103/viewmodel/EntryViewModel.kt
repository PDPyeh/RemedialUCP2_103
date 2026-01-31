package com.example.remedialucp2_103.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.remedialucp2_103.repositori.RepositoriProduk
import com.example.remedialucp2_103.room.Buku

class EntryViewModel(private val repositoriProduk: RepositoriProduk) : ViewModel() {

    var uiStateProduk by mutableStateOf(UIStateProduk())
        private set

    // Fungsi untuk memvalidasi input
    private fun validasiInput(uiState: DetailProduk = uiStateProduk.detailProduk): Boolean {
        return with(uiState) {
            nama.isNotBlank() && ukuran.isNotBlank() && warna.isNotBlank() && kategoriProduk.isNotBlank()
        }
    }

    fun updateUIState(detailProduk: DetailProduk) {
        uiStateProduk =
            UIStateProduk(
                detailProduk = detailProduk,
                validasiInput(detailProduk)
            )
    }

    // Fungsi untuk menyimpan data yang di-entry
    suspend fun saveProduk() {
        if (validasiInput()) {
            repositoriProduk.insertProduk(uiStateProduk.detailProduk.toProduk())
        }
    }
}

data class UIStateProduk(
    val detailProduk: DetailProduk = DetailProduk(),
    val isEntryValid: Boolean = false
)

data class DetailProduk(
    val id: Int = 0,
    val nama: String = "",
    val warna: String = "",
    val ukuran: String = "",
    val kategoriProduk: String = ""
)

fun DetailProduk.toProduk(): Buku = Buku(
    id = id,
    nama = nama,
    warna = warna,
    ukuran = ukuran,
    KategoriProduk = kategoriProduk
)

fun Buku.toUIStateProduk(isEntryValid: Boolean = false): UIStateProduk =
    UIStateProduk(
        detailProduk = this.toDetailProduk(),
        isEntryValid = isEntryValid
    )

fun Buku.toDetailProduk(): DetailProduk = DetailProduk(
    id = id,
    nama = nama,
    warna = warna,
    ukuran = ukuran,
    KategoriProduk = kategoriProduk
)