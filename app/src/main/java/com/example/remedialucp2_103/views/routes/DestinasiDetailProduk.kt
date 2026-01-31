package com.example.remedialucp2_103.views.routes

import com.example.remedialucp2_103.R

object DestinasiDetailProduk : DestinasiNavigasi {
    override val route = "detail_siswa"
    override val titleRes = R.string.detail_produk
    const val itemIdArg = "idSiswa"
    val routeWithArgs = "$route/{$itemIdArg}"
}