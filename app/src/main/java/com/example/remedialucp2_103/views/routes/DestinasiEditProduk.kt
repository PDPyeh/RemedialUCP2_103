package com.example.remedialucp2_103.views.routes

import com.example.remedialucp2_103.R

object DestinasiEditBuku : DestinasiNavigasi {
    override val route = "item_edit"
    override val titleRes = R.string.edit_Buku
    const val itemIdArg = "idSiswa"
    val routeWithArgs = "$route/{$itemIdArg}"
}