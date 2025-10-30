package com.example.ecommerce_jetpack_compose.retrofit

import com.example.ecommerce_jetpack_compose.data.entity.CrudResponse
import com.example.ecommerce_jetpack_compose.data.entity.Sepet
import com.example.ecommerce_jetpack_compose.data.entity.SepetResponse
import com.example.ecommerce_jetpack_compose.data.entity.UrunlerResponse
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface eCommerceDao {
    //http://kasimadalan.pe.hu/urunler/tumUrunleriGetir.php ürünleri listeleme
    //http://kasimadalan.pe.hu/urunler/sepettekiUrunleriGetir.php  sepetteli ürünleri getir
    //http://kasimadalan.pe.hu/urunler/sepeteUrunEkle.php sepete ürün ekleme
    //http://kasimadalan.pe.hu/urunler/sepettenUrunSil.php sepetten ürün silme
    //http://kasimadalan.pe.hu/urunler/resimler/telefon.png  ürün resim getirme

    @GET("urunler/tumUrunleriGetir.php")
    suspend fun loadUrunler(): UrunlerResponse

    @POST("urunler/sepeteUrunEkle.php")
    @FormUrlEncoded
    suspend fun sepeteUrunEkle(
        @Field("ad") ad: String,
        @Field("resim") resim: String,
        @Field("kategori") kategori: String,
        @Field("fiyat") fiyat: Int,
        @Field("marka") marka: String,
        @Field("siparisAdeti") siparisAdedi: Int,
        @Field("kullaniciAdi") kullaniciAdi: String,
    ): CrudResponse


    @POST("urunler/sepettekiUrunleriGetir.php")
    @FormUrlEncoded
    suspend fun sepetListesiGetir(@Field("kullaniciAdi") kullaniciAdi: String): SepetResponse

    @POST("urunler/sepettenUrunSil.php")
    @FormUrlEncoded
    suspend fun urunSil(
        @Field("sepetId") sepetId: Int,
        @Field("kullaniciAdi") kullaniciAdi: String
    ): CrudResponse

}