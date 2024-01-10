package net.lxns.maimai.prober.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import net.lxns.maimai.prober.R

data class NavItem(
    val label: Int = 0,
    val icon : ImageVector = Icons.Filled.Home,
    val route : String = ""
) {
    fun bottomNavigationItems(): List<NavItem> {
        return listOf(
            NavItem(
                label = R.string.home,
                icon = Icons.Filled.Home,
                route = Screens.Home.route
            ),
            NavItem(
                label = R.string.settings,
                icon = Icons.Filled.Settings,
                route = Screens.Settings.route
            ),
        )
    }
}