package com.example.ecommerce_jetpack_compose.di

import com.example.ecommerce_jetpack_compose.data.datasources.ECommerceDataSource
import com.example.ecommerce_jetpack_compose.data.datasources.SepetDataSource
import com.example.ecommerce_jetpack_compose.data.repos.SepetRepository
import com.example.ecommerce_jetpack_compose.data.repos.UrunlerRepository
import com.example.ecommerce_jetpack_compose.retrofit.eCommerceDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideUrunlerRepository(eCommerceDataSource: ECommerceDataSource): UrunlerRepository {
        return UrunlerRepository(eCommerceDataSource)
    }

    @Provides
    @Singleton
    fun provideUrunlerDataSource(eCommerceDao: eCommerceDao): ECommerceDataSource {
        return ECommerceDataSource(eCommerceDao)
    }

    @Provides
    @Singleton
    fun provideSepetRepository(sepetDataSource: SepetDataSource): SepetRepository {
        return SepetRepository(sepetDataSource)
    }

    @Provides
    @Singleton
    fun provideSepetDataSource(eCommerceDao: eCommerceDao): SepetDataSource {
        return SepetDataSource(eCommerceDao)
    }

    @Provides
    @Singleton
    fun provideCommerceDao(retrofit: Retrofit): eCommerceDao {
        return retrofit.create(eCommerceDao::class.java)
    }

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://kasimadalan.pe.hu/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


}