package com.meetpeople.views.signIn

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.meetpeople.nav.graph.AuthNavGraph
import com.meetpeople.views.destinations.SignUpScreenDestination
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator

@AuthNavGraph(start = true)
@Destination
@Composable
fun SignInScreen(navigator: DestinationsNavigator) {
    Column {
        Text(text = "SignIn")
        Button(onClick = { navigator.navigate(SignUpScreenDestination) }) {
            Text(text = "to SignUp")
        }
    }
}