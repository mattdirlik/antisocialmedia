package com.example.cartalkuk.nav

import com.example.cartalkuk.R
import com.example.cartalkuk.nav.NavConstants.GarageBottomNavItemTitle
import com.example.cartalkuk.nav.NavConstants.GarageRoute
import com.example.cartalkuk.nav.NavConstants.SearchBottomNavItemTitle
import com.example.cartalkuk.nav.NavConstants.SearchRoute

val bottomNavBarItems = listOf(
    BottomNavItem(
        name = SearchBottomNavItemTitle,
        route = SearchRoute,
        iconResId = R.drawable.ic_search_car
    ),
    BottomNavItem(
        name = GarageBottomNavItemTitle,
        route = GarageRoute,
        iconResId = R.drawable.ic_garage
    )
)