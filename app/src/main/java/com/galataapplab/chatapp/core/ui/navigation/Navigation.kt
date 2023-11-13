package com.galataapplab.chatapp.core.ui.navigation

import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.galataapplab.chatapp.core.util.Routes
import com.galataapplab.chatapp.ui.walkthrough.WalkthroughScreen

@Composable
fun Navigation(navController: NavHostController, scaffoldState: ScaffoldState) {

    // TODO
    val startDestination = Routes.WALK_THROUGH

    NavHost(
        navController = navController, startDestination = startDestination
    ) {
        composable(Routes.WALK_THROUGH) {
            WalkthroughScreen {
                navController.navigate(Routes.LOGIN)
            }
        }
        composable(Routes.LOGIN) {}
        composable(Routes.VERIFY) {}
        composable(Routes.PROFILE) {}
    }
}