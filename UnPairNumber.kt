package com.naveen.testing


//identify the number that does not have a matching pair
fun foo(array: Array<Int>): Int {
    val outputList = mutableListOf<Int>()

    for (number in array){
        if(outputList.contains(number)){
           outputList.remove(number)
        } else {
            outputList.add(number)
        }
    }

    return outputList.getOrNull(0) ?: 0
}

fun fooTwo(array: Array<Int>): Int {
    var result = 0
    for (num in array) {
        result = result xor num
    }
    return result
}

fun main(){
    val array = arrayOf(1, 1, 2, 2, 4, 4, 5, 5, 5, 4, 4, 1, 2, 1, 2)
    val bar = foo(array)
    val barTwo = fooTwo(array)
    println("$bar")
    println("$barTwo")

}