package com.example.remedialucp2_103.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.remedialucp2_103.repositori.RepositoriBuku
import com.example.remedialucp2_103.views.routes.DestinasiDetailBuku
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class DetailViewModel (
    savedStateHandle: SavedStateHandle,
    private val repositoriBuku: RepositoriBuku
) : ViewModel(){

    private val idBuku: Int = checkNotNull(savedStateHandle[DestinasiDetailBuku.itemIdArg])

    val uiDetailState: StateFlow<DetailBukuUiState> =
        repositoriBuku.getBukuStream(idBuku)
            .filterNotNull()
            .map {
                DetailBukuUiState(detailBuku = it.toDetailBuku())
            }.stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = DetailBukuUiState()
            )
    suspend fun deleteBuku(){
        repositoriBuku.deleteBuku(uiDetailState.value.detailBuku.toBuku())
    }

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
}

/**
 * UI state for ItemDetailsScreen
 */
data class DetailBukuUiState(
    val detailBuku: DetailBuku = DetailBuku()
)