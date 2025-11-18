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
