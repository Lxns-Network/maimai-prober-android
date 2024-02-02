package net.lxns.maimai.prober.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavOptions
import net.lxns.maimai.prober.LocalNavigator
import org.koin.compose.koinInject

sealed class Screens(val route: String) {
    object Landing : Screens("landing")
    object Home: Screens("home")

    @Composable
    fun route(navHost: NavHostController = LocalNavigator.current, navOptions: NavOptions? = null) {
        navHost.navigate(route, navOptions)
    }
}
