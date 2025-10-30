package com.example.ecommerce_jetpack_compose.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.ecommerce_jetpack_compose.data.entity.Urunler
import com.example.ecommerce_jetpack_compose.ui.viewmodels.MainViewModel
import com.example.ecommerce_jetpack_compose.ui.viewmodels.SepetViewModel
import com.example.ecommerce_jetpack_compose.ui.viewmodels.UrunDetayViewModel
import com.google.gson.Gson


@Composable
fun AppNavigation(
    mainViewModel: MainViewModel,
    urunDetayViewModel: UrunDetayViewModel,
    sepetViewModel: SepetViewModel,) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "mainScreen") {
        composable("mainScreen") {
            MainScreen(navController = navController, mainViewModel = mainViewModel)
        }
        composable("sepetScreen") {
            SepetScreen(sepetViewModel = sepetViewModel)
        }
        composable(
            "urunDetayScreen/{urun}",
            arguments = listOf(navArgument("urun") { type = NavType.StringType })
        ) {
            val jsonUrun = it.arguments?.getString("urun")
            val urun = Gson().fromJson(jsonUrun, Urunler::class.java)
            if (urun != null) {
                UrunDetayScreen(
                    urun = urun,
                    urunDetayViewModel = urunDetayViewModel,
                    navController = navController
                )
            }
        }
    }


}