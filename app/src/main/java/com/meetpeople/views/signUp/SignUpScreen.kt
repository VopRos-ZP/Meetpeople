package com.meetpeople.views.signUp

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.meetpeople.nav.graph.AuthNavGraph
import com.meetpeople.views.destinations.RootScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@AuthNavGraph
@Destination
@Composable
fun SignUpScreen(navigator: DestinationsNavigator) {
    Column {
        Text(text = "SignUp")
        Button(onClick = { navigator.navigate(RootScreenDestination) }) {
            Text(text = "to bottom bar")
        }
    }
}