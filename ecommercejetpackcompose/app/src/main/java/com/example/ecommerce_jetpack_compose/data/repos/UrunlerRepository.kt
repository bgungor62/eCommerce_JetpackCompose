package com.example.ecommerce_jetpack_compose.data.repos

import com.example.ecommerce_jetpack_compose.data.datasources.ECommerceDataSource
import com.example.ecommerce_jetpack_compose.data.entity.CrudResponse
import com.example.ecommerce_jetpack_compose.data.entity.Sepet
import com.example.ecommerce_jetpack_compose.data.entity.Urunler

class UrunlerRepository(var dataSource: ECommerceDataSource) {
    suspend fun urunListele(): List<Urunler> = dataSource.urunListele()

    suspend fun sepeteUrunEkle(sepet: Sepet): CrudResponse = dataSource.sepeteUrunEkle(sepet)
}