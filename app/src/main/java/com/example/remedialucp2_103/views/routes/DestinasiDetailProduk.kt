package com.example.remedialucp2_103.views.routes

import com.example.remedialucp2_103.R

object DestinasiDetailBuku : DestinasiNavigasi {
    override val route = "detail_siswa"
    override val titleRes = R.string.detail_Buku
    const val itemIdArg = "idSiswa"
    val routeWithArgs = "$route/{$itemIdArg}"
}