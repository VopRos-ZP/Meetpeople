package com.meetpeople.nav.graph

import com.ramcosta.composedestinations.annotation.NavGraph

@BottomNavGraph(start = true)
@NavGraph
annotation class HomeNavGraph(val start: Boolean = false)
