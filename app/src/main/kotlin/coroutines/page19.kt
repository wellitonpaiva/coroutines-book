package coroutines

import kotlin.concurrent.thread
import kotlinx.coroutines.launch
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking


fun mainThread() {
    repeat(100_000) {
        thread {
            Thread.sleep(1000L)
            println(".")
        }
    }
}

fun main() = runBlocking {
    repeat(100_000) {
        launch {
            delay(1000L)
            print(".")
        }
    }
}
