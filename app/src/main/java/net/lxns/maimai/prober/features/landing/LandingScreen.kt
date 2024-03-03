package net.lxns.maimai.prober.features.landing

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import net.lxns.maimai.prober.LocalNavigator

@Composable
@Preview
fun LandingScreen(navHostController: NavHostController = LocalNavigator.current){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Yes this is a placeholder")
        Text(text = "App icon 还没约")
        LinearProgressIndicator(
            modifier = Modifier.fillMaxWidth(0.7F)
        )
    }
}