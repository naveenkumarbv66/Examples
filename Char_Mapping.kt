package com.naveen.testing

fun isValid(s: String): Boolean {
    val stack = ArrayDeque<Char>()
    val pairs = mapOf(
        ')' to '(',
        '}' to '{',
        ']' to '['
    )

    for (ch in s) {
        if (ch in pairs.values) {
            // Opening bracket → push to stack
            stack.addLast(ch)
        } else if (ch in pairs.keys) {
            // Closing bracket → check stack
            if (stack.isEmpty() || stack.removeLast() != pairs[ch]) {
                return false
            }
        }
    }

    // Valid only if stack is empty
    return stack.isEmpty()
}


fun main(){
    println(isValid("()"))        // true
    println(isValid("()[]{}"))    // true
    println(isValid("(]"))        // false
    println(isValid("([])"))      // true
    println(isValid("([)]"))      // false
}

/*
ArrayDeque in Kotlin is a double-ended queue (deque) implementation that is fast, lightweight, and non-synchronized. It's ideal for use as a stack or a queue because it provides:

push/pop from both ends

No synchronization overhead

Better performance than Stack, LinkedList, or ArrayList for stack/queue operations

----------------

Why ArrayDeque is recommended?

Better than Stack (which is synchronized and slow)

Better than LinkedList (higher memory overhead)

No capacity limit like ArrayList

----------------

val stack = ArrayDeque<Char>()
stack.addLast('(')       // push
stack.removeLast()       // pop
stack.last()             // peek

---------------------

val queue = ArrayDeque<String>()

queue.addLast("A")   // enqueue
queue.addLast("B")
queue.addLast("C")

println(queue.removeFirst()) // dequeue → A
println(queue.first())       // peek → B

-----------------------

val stack = ArrayDeque<Int>()

stack.addLast(10)   // push
stack.addLast(20)
stack.addLast(30)

println(stack.removeLast()) // pop → 30
println(stack.last())       // peek → 20

--------------------

*/
