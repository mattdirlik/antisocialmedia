package com.example.cartalkuk.nav

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.cartalkuk.nav.NavConstants.GarageRoute
import com.example.cartalkuk.nav.NavConstants.SearchRoute
import com.example.cartalkuk.ui.garage.GarageScreen
import com.example.cartalkuk.ui.home.HomeScreen

@Composable
fun CarTalkNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = GarageRoute
    ) {
        composable(SearchRoute) {
            HomeScreen()
        }
        composable(GarageRoute) {
            GarageScreen()
        }
    }
}