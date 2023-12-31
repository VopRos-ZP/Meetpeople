package com.meetpeople.views.root

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.meetpeople.nav.graph.BottomNavGraph
import com.meetpeople.views.NavGraphs
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph

@BottomNavGraph(start = true)
@Destination
@Composable
fun RootScreen() {
    Scaffold {
        Text(modifier = Modifier.padding(it), text = "bottom bar")
        //DestinationsNavHost(modifier = Modifier.padding(it), navGraph = NavGraphs.)
    }
}