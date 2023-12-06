import kotlinx.coroutines.*

/**
 * @author chenxinzhi
 * @date 2023/9/27
 */
@OptIn(ExperimentalStdlibApi::class)
fun main() {
    runBlocking(context = Dispatchers.IO) {
        println(coroutineContext[CoroutineDispatcher])
        //可以再次将线程切换到假设切换到主线程上面执行,这里由于不是安卓,我们切换到default的调度器上面执行,该代码块中的代码是阻塞的
        withContext(context = Dispatchers.Default){
            delay(1000)
            println(coroutineContext[CoroutineDispatcher])
        }
        println(coroutineContext[CoroutineDispatcher])
    }
}