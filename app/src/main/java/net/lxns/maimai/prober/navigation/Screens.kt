package net.lxns.maimai.prober.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import org.koin.compose.koinInject

sealed class Screens(val route: String) {
    object Landing : Screens("landing")

    @Composable
    fun route(navHost: NavHostController = koinInject(), navOptions: NavOptions? = null) {
        navHost.navigate(route, navOptions)
    }
}
