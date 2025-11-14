package com.naveen.testing

import androidx.compose.runtime.key

fun majorityElement(input: IntArray){
    var hashMap = HashMap<Int, Int>()

    input.forEach { value ->
        val count = hashMap.getOrDefault(value, 0) + 1
        hashMap[value] = count
    }

    val result = hashMap.toList().sortedByDescending { it.second }.toMap()

    println(result)

    for ((key,value) in result){
        if(value >= result.size / 2){
            println("Number: ".plus(key).plus(" Count: ").plus(value))
        }
    }
}


fun main(){
    println("Hello")
    val nums1 = intArrayOf(12,32,12,10,32,1,2,32,10,13)
    majorityElement(nums1)
}