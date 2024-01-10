package net.lxns.maimai.prober.navigation

sealed class Screens(val route: String) {
    object Home: Screens("home")
    object Settings: Screens("settings")
    object Login: Screens("login")
}
