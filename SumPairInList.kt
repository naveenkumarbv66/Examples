package com.naveen.testing

fun main(){
    println("Hello")
    val inputList = listOf<Int>(1,4,2,5,2,4,2,3,2,4,3,6,2,3,1)
    var result = HashMap<Int, Int>()
    val TOTAL_AMOUNT = 3

    // -------------------------------------------------

    inputList.forEachIndexed { index, item ->
        for (itemInside in inputList){
            if(item + itemInside == TOTAL_AMOUNT){
                result[item] = itemInside
            }
        }
    }
    println(result)

    // -------------------------------------------------

    var resultTwo = HashMap<Int, Int>()
    inputList.forEachIndexed { index, item ->
        val difference = TOTAL_AMOUNT - item
        if(inputList.contains(difference)){
            resultTwo[item] = difference
        }
    }
    println(resultTwo)
}