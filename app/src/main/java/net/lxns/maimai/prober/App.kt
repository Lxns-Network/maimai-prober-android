package net.lxns.maimai.prober

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import net.lxns.maimai.prober.navigation.Router
import org.koin.android.ext.koin.androidLogger
import org.koin.compose.KoinApplication
import org.koin.dsl.module


@Composable
fun App() {
    val nav = rememberNavController()

    KoinApplication(application = {
        androidLogger()
        module {
            single<NavHostController> { nav }
        }
    }) {
        Router()
    }
}