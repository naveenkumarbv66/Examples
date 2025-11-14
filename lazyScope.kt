package com.naveen.testing

import androidx.compose.runtime.key

val demoLazy by lazy {
    println("Lazy scope is executed")
    "Hey hello, how you doing"
}


fun main(){
    println("Hello")

    println(demoLazy)
    println(demoLazy)
    println(demoLazy)

    /*
        Hello
        Lazy scope is executed
        Hey hello, how you doing
        Hey hello, how you doing
        Hey hello, how you doing

    */
}
