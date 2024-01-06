package coroutines

import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

private val executor = Executors.newSingleThreadScheduledExecutor {
    Thread(it, "sheduler").apply { isDaemon = true }
}

suspend fun delay(timeMillis: Long) = suspendCoroutine { cont ->
    executor.schedule({cont.resume(Unit)}, timeMillis, TimeUnit.MILLISECONDS)
} 

suspend fun main() {
    println("before")

    delay(1000)

    println("after")
}