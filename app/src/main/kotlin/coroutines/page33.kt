package coroutines

import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class User

inline fun requestUser(func: (User) -> Unit) = func(User())

suspend fun requestUser(): User {
    return suspendCoroutine { cont ->
        requestUser { user: User -> cont.resume(user) }
    }
}

suspend fun main() {
    println("before")
    val user = requestUser()
    println(user)
    println("after")
}