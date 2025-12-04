package com.naveen.testing


fun main(){
    println("Hello")

    val num = 5
        .also { println("Also 1: $it") }
        .let { //Import
            println("Let: $it")
            it + 5
        }
        .also {
            println("Also 2: $it")
            it + it
        }
        .run { //Import
            println("Run: $this")
            this + 10
        }
        .apply { 
            println("Apply: $this")
            this + this
        }

    with(num){
        println("with: $this")
        this * this
    }

    println(num)

    /*
        Hello
        Also 1: 5
        Let: 5
        Also 2: 10
        Run: 10
        Apply: 20
        with: 20
        20
     */
}
