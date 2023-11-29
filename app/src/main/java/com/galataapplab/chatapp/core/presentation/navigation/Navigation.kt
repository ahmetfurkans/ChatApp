package com.galataapplab.chatapp.core.presentation.navigation

import androidx.compose.material.ScaffoldState
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.galataapplab.chatapp.core.util.Routes
import com.galataapplab.chatapp.presentation.login.LoginScreen
import com.galataapplab.chatapp.presentation.login.OTPVerificationScreen
import com.galataapplab.chatapp.presentation.profile.ProfileScreen
import com.galataapplab.chatapp.presentation.walkthrough.WalkthroughScreen

@Composable
fun Navigation(navController: NavHostController, scaffoldState: ScaffoldState) {

    // TODO
    val startDestination = Routes.WALK_THROUGH

    NavHost(
        navController = navController, startDestination = startDestination
    ) {

        navigation(
            startDestination = Routes.LOGIN, route = "login"
        ) {
            composable(Routes.LOGIN) { entry ->
                LoginScreen(
                    navController = navController
                )
            }

            composable(Routes.VERIFY) { entry ->
                OTPVerificationScreen(
                    navController = navController
                )
            }
        }

        composable(Routes.WALK_THROUGH) {
            WalkthroughScreen {
                navController.navigate(Routes.LOGIN)
            }
        }
        composable(Routes.PROFILE) {
            ProfileScreen(navController = navController)
        }
    }
}