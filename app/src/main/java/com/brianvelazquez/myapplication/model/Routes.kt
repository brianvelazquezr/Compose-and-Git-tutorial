package com.brianvelazquez.myapplication.model

sealed class Routes(val route: String) {
    object Screen1:Routes("screen1")
    object Screen2:Routes("screen2")
    object Screen3:Routes("screen3")
    object Screen4:Routes("screen4/{num}"){
        fun createRoute(num: Int): String = "screen4/$num"
    }
    object Screen5:Routes("screen5?string={string}"){
        fun createRoute(string: String): String = "screen5?string=$string"
    }
}