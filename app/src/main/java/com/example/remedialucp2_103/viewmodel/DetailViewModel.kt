package com.example.remedialucp2_103.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.remedialucp2_103.repositori.RepositoriBuku
import com.example.remedialucp2_103.viewmodel.DetailProduk
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class DetailViewModel (
    savedStateHandle: SavedStateHandle,
    private val repositoriProduk: RepositoriProduk
) : ViewModel(){

    private val idProduk: Int = checkNotNull(savedStateHandle[DestinasiDetailProduk.itemIdArg])

    val uiDetailState: StateFlow<DetailProdukUiState> =
        repositoriProduk.getProdukStream(idProduk)
            .filterNotNull()
            .map {
                DetailProdukUiState(detailProduk = it.toDetailProduk())
            }.stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = DetailProdukUiState()
            )
    suspend fun deleteProduk(){
        repositoriProduk.deleteProduk(uiDetailState.value.detailProduk.toProduk())
    }

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
}

/**
 * UI state for ItemDetailsScreen
 */
data class DetailProdukUiState(
    val detailProduk: DetailProduk = DetailProduk()
)