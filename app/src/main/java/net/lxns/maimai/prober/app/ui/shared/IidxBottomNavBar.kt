package net.lxns.maimai.prober.app.ui.shared

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun IidxBottomNavBar(current: String, navHostController: NavHostController) {
    @Composable
    fun RowScope.IidxNavBarItem(
        name: String,
        title: String,
        icon: @Composable () -> Unit
    ) {
        val selected = name == current
        NavigationBarItem(
            selected = selected,
            onClick = { navHostController.navigate(name) },
            icon = icon,
            label = {
                Text(title)
            }
        )
    }
    NavigationBar {
        IidxNavBarItem(name = "home", title = "Home") {
            Icon(Icons.Filled.Home, contentDescription = "navigate to home")
        }
    }
}