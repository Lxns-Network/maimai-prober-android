package net.lxns.maimai.prober.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import net.lxns.maimai.prober.components.TabNavBar
import net.lxns.maimai.prober.components.TopBar
import net.lxns.maimai.prober.navigation.NavItem
import net.lxns.maimai.prober.navigation.Screens

@Composable
fun MainScreen(navHostController: NavHostController) {
    var navigationSelectedItem by remember { mutableIntStateOf(0) }
    val navController = rememberNavController()

    val topBarState = rememberSaveable { mutableStateOf(false) }
    val bottomBarState = rememberSaveable { mutableStateOf(false) }

    val navBackStackEntry by navController.currentBackStackEntryAsState()

    topBarState.value = isTopLevelScreens(navBackStackEntry = navBackStackEntry)
    bottomBarState.value = isTopLevelScreens(navBackStackEntry = navBackStackEntry)

    Scaffold(
        topBar = { if (topBarState.value) TopBar(navController = navController) },
        bottomBar = { if (bottomBarState.value) TabNavBar(
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
fun isTopLevelScreens(navBackStackEntry: NavBackStackEntry?) =
    NavItem().bottomNavigationItems().any { it.route == navBackStackEntry?.destination?.route }