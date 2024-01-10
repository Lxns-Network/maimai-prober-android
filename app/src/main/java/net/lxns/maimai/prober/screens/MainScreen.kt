package net.lxns.maimai.prober.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import net.lxns.maimai.prober.components.TabNavBar
import net.lxns.maimai.prober.components.TopBar
import net.lxns.maimai.prober.navigation.NavItem
import net.lxns.maimai.prober.navigation.Screens

@Composable
fun MainScreen(navHostController: NavHostController) {
    var navigationSelectedItem by remember { mutableIntStateOf(0) }
    val navController = rememberNavController()

    val hasScaffoldSlots by navController.hasScaffoldSlots()

    Scaffold(
        topBar = { if (hasScaffoldSlots) TopBar(navController = navController) },
        bottomBar = { if (hasScaffoldSlots) TabNavBar(
            navController = navController,
            navigationSelectedItem = navigationSelectedItem,
            onClick = { navigationSelectedItem++ }
        ) },

    ) {
        NavHost(
            navController = navController,
            startDestination = Screens.Home.route,
            modifier = Modifier.padding(paddingValues = it)
        ) {
            composable(Screens.Home.route) {
                HomeScreen(navController)
            }

            composable(Screens.Settings.route) {
                SettingsScreen()
            }

            composable(Screens.Login.route) {
                LoginScreen()
            }
        }
    }
}

@Composable
private fun NavController.hasScaffoldSlots(): State<Boolean> {
    val hasScaffoldSlotsState = remember { mutableStateOf(true) }

    DisposableEffect(key1 = this) {
        val listener = NavController.OnDestinationChangedListener { _, destination, _ ->
            when {
                destination.hierarchy
                    .any {
                        NavItem()
                            .bottomNavigationItems()
                            .any { item -> it.route == item.route  }
                    } -> {
                    hasScaffoldSlotsState.value = true
                }
                else -> {
                    hasScaffoldSlotsState.value = false
                }
            }
        }
        addOnDestinationChangedListener(listener)
        // TODO: Figure out what to return here
    }
    return hasScaffoldSlotsState
}