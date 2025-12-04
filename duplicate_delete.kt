package com.naveen.testing

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

data class PersonTest(val name: String, val id: Int, val location: String)

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

    //----------------------------------------------------------------------

    val personList = listOf<PersonTest>(
       PersonTest("one",1,"one"),
       PersonTest("two",2,"two"),
       PersonTest("three",3,"three"),
       PersonTest("four",4,"four"),
       PersonTest("Five",5,"Five"),
       PersonTest("six",6,"six"),
       PersonTest("six",6,"six"),
       PersonTest("one",1,"one"),
       PersonTest("Five test",5,"Five test"),
       PersonTest("four test",4,"four test"),
   )

    val removeDuplicateRow = personList.distinct()

    val removeDuplicateRowByID = personList.distinctBy { it.id }

    println(removeDuplicateRowByID)

    println(removeDuplicateRow)

    //toSet() (removes duplicates but order not guaranteed)
}


