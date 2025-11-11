package com.naveen.testing

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val channel = Channel<Int>()

    // Producer coroutine
    launch {
        for (x in 1..5) {
            channel.send(x * x) // Send squared numbers to the channel
            delay(100)
        }
        channel.close() // Close the channel when done sending
    }

    // Consumer coroutine
    launch {
        for (y in channel) { // Iterate over the channel to receive elements
            println(y)
        }
        println("Channel closed and all elements received.")
    }

    println("Main thread finishes")
}


