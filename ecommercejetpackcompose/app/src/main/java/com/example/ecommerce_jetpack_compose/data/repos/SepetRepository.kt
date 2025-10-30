package com.example.ecommerce_jetpack_compose.data.repos

import com.example.ecommerce_jetpack_compose.data.datasources.ECommerceDataSource
import com.example.ecommerce_jetpack_compose.data.datasources.SepetDataSource
import com.example.ecommerce_jetpack_compose.data.entity.CrudResponse
import com.example.ecommerce_jetpack_compose.data.entity.Sepet

class SepetRepository(var sepetDataSource: SepetDataSource) {
    //suspend fun sepeteUrunEkle(sepet: Sepet): CrudResponse = dataSource.sepeteUrunEkle(sepet)

    suspend fun sepetListesiGetir(kullaniciAdi: String): List<Sepet> =
        sepetDataSource.sepetListele(kullaniciAdi)

    suspend fun urunSil(sepedId: Int, kullaniciAdi: String): CrudResponse =
        sepetDataSource.urunSil(sepedId, kullaniciAdi)

}