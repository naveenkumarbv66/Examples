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


/*
Kotlin List Functions -

1. map: Transform each element. 
val squares = numbers.map { it * 2 }
println(squares) //[2, 4, 6, 8, 10, 12]

------------------------------------------------------

2. filter: Keep elements matching condition. 
val evens = numbers.filter { it % 2 == 0 }
println(evens) //[2, 4, 6]

------------------------------------------------------

3. filterNot: Opposite of filter. 
val notEvens = numbers.filterNot { it % 2 == 0 }
println(notEvens) //[1, 3, 5]

------------------------------------------------------

4. groupBy: Group elements by key. 
val result = names.groupBy { it.first() }
println(result) //{A=[Alice], B=[Bob], C=[Charlie], D=[David]}


------------------------------------------------------

5. mapValues: Transform map values. (often used with groupBy).
val grouped = names.groupBy { it.first() }
val onlyLengths = grouped.mapValues { entry -> entry.value.map { it.length } }

println(onlyLengths) //{A=[5], B=[3], C=[7], D=[5]}


------------------------------------------------------

6. flatMap: Flatten nested lists. 
val data = listOf(
    listOf(1, 2),
    listOf(3, 4),
    listOf(5)
)

val merged = data.flatMap { it }
println(merged) //[1, 2, 3, 4, 5]


------------------------------------------------------

7. reduce: Accumulate from first element. 
val sum = numbers.reduce { acc, value -> acc + value }
println(sum) //21

------------------------------------------------------

8. fold: Accumulate with initial value. 
val sum = numbers.fold(10) { acc, value -> acc + value }
println(sum) //31   // 10 + 21

------------------------------------------------------

9. sorted: Sort ascending. 
println(listOf(3,1,2).sorted()) //[1, 2, 3]

------------------------------------------------------

10. sortedBy: Sort by property. 
println(names.sortedBy { it.length }) //[Bob, Alice, David, Charlie]

------------------------------------------------------

11. any: Check if any element matches. 
println(numbers.any { it > 5 }) //true

------------------------------------------------------

12. all: Check if all match. 
println(numbers.all { it > 0 }) //true

------------------------------------------------------

13. none: Check if none match. 
println(numbers.none { it < 0 }) //true

------------------------------------------------------

14. find / firstOrNull: Find first match. 
println(numbers.find { it % 2 == 0 })       // 2
println(numbers.firstOrNull { it > 10 })   // null

------------------------------------------------------

15. take: Take first N elements. 
println(numbers.take(3)) //[1, 2, 3]

------------------------------------------------------

16. drop: Drop first N elements. 
println(numbers.drop(3))

------------------------------------------------------

17. distinct: Remove duplicates. 
println(listOf(1,1,2,3,3).distinct()) //[1, 2, 3]

------------------------------------------------------

18. distinctBy: Unique by property. 
data class Person(val name: String, val age: Int)

val people = listOf(
    Person("A", 20),
    Person("B", 20),
    Person("C", 30)
)

println(people.distinctBy { it.age }) //[Person(name=A, age=20), Person(name=C, age=30)]


------------------------------------------------------

19. partition: Split into match / not match. 
val (even, odd) = numbers.partition { it % 2 == 0 }
println(even)  // [2, 4, 6]
println(odd)   // [1, 3, 5]


------------------------------------------------------

20. zip: Combine two lists.
println(listOf(1,2,3).zip(listOf("A","B","C"))) //[(1, A), (2, B), (3, C)]


------------------------------------------------------

*/
