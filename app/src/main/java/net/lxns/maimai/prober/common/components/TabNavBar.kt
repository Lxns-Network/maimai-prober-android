package net.lxns.maimai.prober.common.components

import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.NavGraph.Companion.findStartDestination
import net.lxns.maimai.prober.common.navigation.NavItem

@Composable
fun TabNavBar(navController: NavController, navigationSelectedItem: Int, onClick: (Int) -> Unit) {
    NavigationBar {
        NavItem().bottomNavigationItems().forEachIndexed { index, navItem ->
            NavigationBarItem(
                selected = index == navigationSelectedItem,
                label = {
                    Text(stringResource(id = navItem.label))
                },
                icon = {
                    Icon(
                        navItem.icon,
                        contentDescription = stringResource(id = navItem.label)
                    )
                },
                onClick = {
                    onClick(index)
                    navController.navigate(navItem.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}