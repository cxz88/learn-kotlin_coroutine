import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.EmptyCoroutineContext

/**
 * @author chenxinzhi
 * @date 2023/10/10
 */
suspend fun main() {
    runBlocking {  }

    val launch = CoroutineScope(EmptyCoroutineContext).launch {
        test1()
        println("hello")
    }
    launch.join()
    println("world")
}

suspend fun test1() {
    delay(100)
    throw NullPointerException()
}
