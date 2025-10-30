package com.example.ecommerce_jetpack_compose.data.datasources

import com.example.ecommerce_jetpack_compose.data.entity.CrudResponse
import com.example.ecommerce_jetpack_compose.data.entity.Sepet
import com.example.ecommerce_jetpack_compose.data.entity.Urunler
import com.example.ecommerce_jetpack_compose.retrofit.eCommerceDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ECommerceDataSource(var eCommerceDao: eCommerceDao) {
    suspend fun urunListele(): List<Urunler> = withContext(Dispatchers.IO) {
        try {
            return@withContext eCommerceDao.loadUrunler().urunler
        } catch (e: Exception) {
            return@withContext emptyList<Urunler>()
        }
    }

    suspend fun sepeteUrunEkle(sepet: Sepet): CrudResponse {
        return eCommerceDao.sepeteUrunEkle(
            sepet.ad,
            sepet.resim,
            sepet.kategori,
            sepet.fiyat,
            sepet.marka,
            sepet.siparisAdeti,
            sepet.kullaniciAdi
        )
    }


}