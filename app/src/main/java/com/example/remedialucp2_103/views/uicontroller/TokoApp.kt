package com.example.ucp2pam.views.uicontroller

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.ucp2pam.views.EntryProdukScreen
import com.example.ucp2pam.views.HomeScreen
import com.example.ucp2pam.views.routes.DestinasiDetailProduk
import com.example.ucp2pam.views.routes.DestinasiDetailProduk.itemIdArg
import com.example.ucp2pam.views.routes.DestinasiEditProduk
import com.example.ucp2pam.views.routes.DestinasiEntry
import com.example.ucp2pam.views.routes.DestinasiHome

@Composable
fun SiswaApp(navController: NavHostController = rememberNavController(),
             modifier: Modifier = Modifier) {
    HostNavigasi(navController = navController)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HostNavigasi(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = DestinasiHome.route,
        modifier = modifier
    ) {
        composable(DestinasiHome.route) {
            HomeScreen(
                navigateToItemEntry = { navController.navigate(DestinasiEntry.route) },
                navigateToItemUpdate = { navController.navigate("${DestinasiDetailProduk.route}/${it}")}
            )
        }
        composable(DestinasiEntry.route) {
            EntryProdukScreen(navigateBack = { navController.popBackStack() })
        }


    }
}