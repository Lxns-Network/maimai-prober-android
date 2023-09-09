@file:OptIn(ExperimentalMaterial3Api::class)

package net.lxns.maimai.prober.app.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import net.lxns.maimai.prober.app.Routes
import net.lxns.maimai.prober.app.ui.shared.IidxBottomNavBar

@Composable
fun MainScreen(navHostController: NavHostController) {

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(title = {
                Text("Overview")
            }, navigationIcon = {
                IconButton(onClick = {

                }) {
                    Icon(imageVector = Icons.Filled.Menu, contentDescription = "menu")
                }
            }, actions = {
                IconButton(onClick = { /*TODO*/ }) {
                    Icon(
                        imageVector = Icons.Filled.Refresh,
                        contentDescription = "refresh data"
                    )
                }
            })
        },
        bottomBar = {
            IidxBottomNavBar(current = Routes.MAIN, navHostController = navHostController)
        }
    ) {

        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {


        }
    }
}