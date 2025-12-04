package com.naveen.testing



fun main(){

    val inputList = listOf<Int>(1,5,2,5,10,14,99,50,29,30,35,20,1,4,5)

    //With inbuilt functions
    var resultWithInbuilt = inputList
        .distinct() //Remove duplicate items
        .sortedByDescending { it } // Sort by descending order
        .getOrNull(1) //Get 2nd item from the list if not return NULL.
    println(resultWithInbuilt ?: "Input size less than 1 so NO 2nd largest number.")

     resultWithInbuilt = inputList
        .distinct() //Remove duplicate items
        .sorted() // Sort by ascending order
        .dropLast(1) //Removes the last 1 element from the list and returns a new list.
        .lastOrNull() //Returns the last element of the list. if not return NULL.
    println(resultWithInbuilt ?: "Input size less than 1 so NO 2nd largest number.")

    //Without inbuilt functions
    var MAX = Int.MIN_VALUE
    var SECOND_MAX = Int.MIN_VALUE

    for (item in inputList){
        if(item > MAX){
            SECOND_MAX = MAX
            MAX = item
        }else if(item > SECOND_MAX && item != MAX){
            SECOND_MAX = item
        }
    }
    println(SECOND_MAX)
}
