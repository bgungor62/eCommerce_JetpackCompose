package com.example.ecommerce_jetpack_compose.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ecommerce_jetpack_compose.data.entity.CrudResponse
import com.example.ecommerce_jetpack_compose.data.entity.Sepet
import com.example.ecommerce_jetpack_compose.data.repos.UrunlerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class UrunDetayViewModel @Inject constructor(var repository: UrunlerRepository) : ViewModel() {


    private val _crudResult = MutableStateFlow<CrudResponse?>(null)
    val crudResult: StateFlow<CrudResponse?> = _crudResult

    fun sepeteUrunEkle(sepet: Sepet) {
        CoroutineScope(Dispatchers.Main).launch {
            val result = repository.sepeteUrunEkle(sepet)
            _crudResult.value = result
        }

    }
}