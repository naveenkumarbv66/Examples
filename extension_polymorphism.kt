package com.naveen.testing

open class BaseClass{
    open fun someMethodTwo() {
        println("BaseClass.someMethodTwo")
    }
}

class DerivedClass: BaseClass(){
    override fun someMethodTwo() {
        println("DerivedClass.someMethodTwo")
    }
}

fun BaseClass.SomeMethod(){
    println("BaseClass.SomeMethod")
}

fun DerivedClass.SomeMethod(){
    println("DerivedClass.SomeMethod")
}

fun printExtensionMessage(base: BaseClass){
    base.SomeMethod()
}

fun printPolymorphismMessage(base: BaseClass){
    base.someMethodTwo()
}

fun main(){
    println("Hello")

    printExtensionMessage(DerivedClass()) //BaseClass.SomeMethod

    //dynamic behavior (polymorphism) : Use open member functions, not extensions
    printPolymorphismMessage(DerivedClass()) //DerivedClass.someMethodTwo

    /*

    Kotlin does NOT do dynamic dispatch for extension functions

    | What happens?                             | Why?                                                                                  |
    | ----------------------------------------- | ------------------------------------------------------------------------------------- |
    | `BaseClass.SomeMethod` is printed         | Extension functions use **static dispatch** (based on variable type, not object type) |
    | Passing a `DerivedClass()` doesn’t matter | Only the **compile-time type** matters (`BaseClass`)                                  |

    */
}
