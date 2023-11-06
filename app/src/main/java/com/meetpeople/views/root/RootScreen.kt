package com.meetpeople.views.root

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.meetpeople.views.NavGraphs
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph

@RootNavGraph
@Destination
@Composable
fun RootScreen() {
    Scaffold {
        DestinationsNavHost(modifier = Modifier.padding(it), navGraph = NavGraphs.root)
    }
}