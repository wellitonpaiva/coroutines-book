package coroutines

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

val seq = sequence {
    println("generating first")
    yield(1)
    println("generating second")
    yield(2)
    println("generating third")
    yield(3)
    println("done")
}

fun main() {
    for(num in seq) {
        println("the next number is $num")
    }
}
