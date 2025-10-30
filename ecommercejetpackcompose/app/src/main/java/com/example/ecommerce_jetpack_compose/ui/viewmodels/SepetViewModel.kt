package com.example.ecommerce_jetpack_compose.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ecommerce_jetpack_compose.data.entity.Sepet
import com.example.ecommerce_jetpack_compose.data.repos.SepetRepository
import com.example.ecommerce_jetpack_compose.data.repos.UrunlerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SepetViewModel @Inject constructor(
    private val sepetRepository: SepetRepository
) : ViewModel() {

    val sepetList = MutableLiveData<List<Sepet>>()


    fun loadSepetList(kullaniciAdi: String) {
        CoroutineScope(Dispatchers.Main).launch {
            sepetList.value = sepetRepository.sepetListesiGetir(kullaniciAdi)
        }
    }

    fun urunSil(sepedId: Int, kullaniciAdi: String) {
        CoroutineScope(Dispatchers.Main).launch {
            sepetRepository.urunSil(sepedId, kullaniciAdi)
            sepetList.value = sepetRepository.sepetListesiGetir(kullaniciAdi)
        }
    }
}