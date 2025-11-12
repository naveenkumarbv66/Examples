package com.naveen.testing

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main()  {

    // option one
    var inputArray = listOf<Int>(1,2,4,3,5,1,2,4,3,3,7)
    val result = inputArray.toSet()
    println("inputArray.toSet() ".plus(result))

    //option two
    inputArray = mutableListOf<Int>(11,11,12,11,15,16,15,12,18)
    val resultTwo = mutableListOf<Int>()
    inputArray.forEachIndexed { index, i ->
        if(!resultTwo.contains(i)) resultTwo.add(i)
    }
    println("resultTwo.contains(i) ".plus(resultTwo))
}


