package com.naveen.testing
data class Person(val name: String, val age: Int, val city: String)

fun main(){
    println("Hello")
    val people = listOf(
        Person("Alice", 31, "London"),
        Person("Bob", 29, "London"),
        Person("Charles", 31, "Paris"),
        Person("Diana", 40, "Paris"),
        Person("Eve", 29, "London")
    )

  val result  =  people
      .groupBy { it.city }
      .mapValues { entry -> entry.value.map { it.age } }
    /* o/p => .groupBy { it.city }
          {
              London=[Person(name=Alice, age=31, city=London), Person(name=Bob, age=29, city=London), Person(name=Eve, age=29, city=London)],
              Paris=[Person(name=Charles, age=31, city=Paris), Person(name=Diana, age=40, city=Paris)]
           }

        .mapValues { entry -> entry.value.map { it.age } }
        {London=[Alice, Bob, Eve], Paris=[Charles, Diana]}

         .mapValues { entry -> entry.value.map { it.age } }
         {London=[31, 29, 29], Paris=[31, 40]}
     */
    println(result)
}
