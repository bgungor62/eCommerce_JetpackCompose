package com.example.ecommerce_jetpack_compose.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ecommerce_jetpack_compose.data.entity.Urunler
import com.example.ecommerce_jetpack_compose.data.repos.UrunlerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(var repository: UrunlerRepository) : ViewModel() {

    var urunlerList = MutableLiveData<List<Urunler>>()

    init {
        loadUrunler()
    }

    fun loadUrunler() {
        CoroutineScope(Dispatchers.Main).launch {
            urunlerList.value = repository.urunListele()
        }
    }
}