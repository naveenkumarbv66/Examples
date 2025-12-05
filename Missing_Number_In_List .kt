package com.naveen.testing

fun main(){
    println("Finding a missing number in a sequence")
    val inputList = listOf<Int>(1,4,2,5,2,4,5,2,4,5,6,3,8)
    val rang_number = 8 // Like from 1 to 8.

    val sunm_list = inputList.toSet().sum()
    val original_sum = rang_number * (rang_number+1) /2 // Sum of first n natural numbers
    val missing_number = original_sum - sunm_list

    println("Method One: ".plus(missing_number)) // 7

    //------- Another Method -------------------------------
    val given_rang = 0..8
    var result = mutableListOf<Int>()
    for(number in given_rang){
        if(number !in inputList){
            result.add(number)
        }
    }
    println("Method Two: ".plus(result))

}