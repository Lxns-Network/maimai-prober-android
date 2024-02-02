package net.lxns.maimai.prober

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import net.lxns.maimai.prober.navigation.Router
import org.koin.androidx.compose.KoinAndroidContext
import org.koin.core.annotation.KoinExperimentalAPI


val LocalNavigator = compositionLocalOf<NavHostController> {
    error("No LocalNavController provided")
}

@OptIn(KoinExperimentalAPI::class)
@Composable
fun App() {
    CompositionLocalProvider(LocalNavigator provides rememberNavController()) {
        KoinAndroidContext {
            Router()
        }
    }
}