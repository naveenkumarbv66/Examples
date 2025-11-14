package com.naveen.testing

val add: (Int, Int)->Int = {x,y -> x+y}
val sub: (Int, Int)->Int = {x,y -> x-y}

fun fighterOrderDemo(a: Int, b:Int, highterOrderFunctionParamert: (Int,Int)->Int): Int{
   return highterOrderFunctionParamert(a,b)
}

fun main(){
    println("Hello")

    println(fighterOrderDemo(4,6,add))

    val subResult = fighterOrderDemo(4,6,sub)
    println(subResult)

    // Call the higher-order function with a lambda directly
    println(fighterOrderDemo(4,6, { x,y -> x*y } ))
}