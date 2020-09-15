package com.leme.marvel.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.leme.marvel.data.MarvelRepository
import com.leme.marvel.ui.MainViewModel

class MainVMFactory(private val repository: MarvelRepository): ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repository) as T
    }
}