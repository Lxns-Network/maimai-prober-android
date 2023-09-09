package net.lxns.maimai.prober.app

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import net.lxns.maimai.prober.app.screen.MainScreen

object Routes {
    const val MAIN = "main"
}

@Composable
fun IidxApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Routes.MAIN) {
        composable(Routes.MAIN) {
            MainScreen(navController)
        }
    }
}