import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

fun main() = runBlocking {
//Using Coroutines (Recommended for Kotlin)
   val numbers = (1..100).toList()  // Example list
    val chunkSize = 20  // split list into 5 chunks
    val chunks = numbers.chunked(chunkSize)\

    val time = measureTimeMillis {
        val results = chunks.map { chunk ->
            async(Dispatchers.Default) {
                chunk.sum()  // Do your heavy calculation here
            }
        }.awaitAll()

        val finalResult = results.sum()
        println("Partial Results: $results")
        println("Final Result: $finalResult")
    }

    println("Completed in $time ms")
}

//Using Threads (Not preferred but possible)\

fun main() {
    val numbers = (1..100).toList()
    val chunkSize = 20
    val chunks = numbers.chunked(chunkSize)
    
    val results = MutableList(chunks.size) { 0 }
    val threads = mutableListOf<Thread>()

    for ((index, chunk) in chunks.withIndex()) {
        val thread = Thread {
            results[index] = chunk.sum()
        }
        threads.add(thread)
        thread.start()
    }

    threads.forEach { it.join() } // wait for all threads

    val finalResult = results.sum()
    println("Partial Results: $results")
    println("Final Result: $finalResult")
}

// If List is Very Large \'97 Use CPU Cores Efficiently
val chunkSize = numbers.size / Runtime.getRuntime().availableProcessors()
