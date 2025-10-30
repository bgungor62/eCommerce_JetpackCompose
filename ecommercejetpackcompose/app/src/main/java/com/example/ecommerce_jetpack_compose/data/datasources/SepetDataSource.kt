package com.example.ecommerce_jetpack_compose.data.datasources

import android.adservices.adid.AdId
import com.example.ecommerce_jetpack_compose.data.entity.CrudResponse
import com.example.ecommerce_jetpack_compose.data.entity.Sepet
import com.example.ecommerce_jetpack_compose.data.entity.Urunler
import com.example.ecommerce_jetpack_compose.retrofit.eCommerceDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SepetDataSource(var eCommerceDao: eCommerceDao) {
    suspend fun sepetListele(kullaniciAdi: String): List<Sepet> = withContext(Dispatchers.IO) {
        try {
            return@withContext eCommerceDao.sepetListesiGetir(kullaniciAdi).sepet
        } catch (e: Exception) {
            return@withContext emptyList<Sepet>()
        }
    }

    suspend fun urunSil(sepetId: Int, kullaniciAdi: String): CrudResponse {
        return eCommerceDao.urunSil(sepetId, kullaniciAdi)
    }
}