package com.naveen.testing

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext
import kotlin.time.Duration.Companion.seconds

fun main() = runBlocking {
    println("Main thread starts")
    val scope = CoroutineScope(Job()) // Create a new scope with a Job

    // Launch a new coroutine in the GlobalScope.
    val job = scope.launch {
        println("Coroutine started")
        delay(2000L) // Suspend for 2 seconds without blocking the thread
        println("Coroutine resumed after delay")
    }

    // This line executes immediately after the GlobalScope.launch call.
    println("Main thread continues")



    val jobTwo = GlobalScope.async {
        println("async Coroutine started")
        delay(2000L) // Suspend for 2 seconds without blocking the thread
        println("async Coroutine resumed after delay")
        "heyyyy"
    }

    // Wait for the coroutine to complete
    job.join()
    println( jobTwo.await())

    println("Main thread finishes")
   
}


