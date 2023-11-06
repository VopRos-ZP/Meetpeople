package com.meetpeople.nav.graph

import com.ramcosta.composedestinations.annotation.NavGraph
import com.ramcosta.composedestinations.annotation.RootNavGraph

@RootNavGraph
@AuthNavGraph
@NavGraph
annotation class BottomNavGraph(val start: Boolean = false)
