package com.example.remedialucp2_103.viewmodel.provider

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.remedialucp2_103.repositori.AplikasiBuku
import com.example.remedialucp2_103.viewmodel.DetailViewModel
import com.example.remedialucp2_103.viewmodel.EntryViewModel
import com.example.remedialucp2_103.viewmodel.HomeViewModel

object PenyediaViewModel {
    val Factory = viewModelFactory {
        initializer {
            HomeViewModel(aplikasiBuku().container.repositoriBuku)
        }

        initializer {
            EntryViewModel(aplikasiBuku().container.repositoriBuku)
        }

        initializer {
            DetailViewModel(
                this.createSavedStateHandle(),
                aplikasiBuku().container.repositoriBuku
            )
        }

        initializer {
            EditViewModel(this.createSavedStateHandle(),
                aplikasiBuku().container.repositoriBuku)
        }
    }
}

/**
 * Fungsi ekstensi query untuk objek [Application] dan mengembalikan sebuah
 * instance dari [AplikasiSiswa].
 */
fun CreationExtras.aplikasiBuku(): AplikasiBuku =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as AplikasiBuku)