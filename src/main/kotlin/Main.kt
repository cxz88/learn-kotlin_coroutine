import kotlinx.coroutines.*

@OptIn(ExperimentalStdlibApi::class)
suspend fun main() {
    //一般用来处理一些耗时任务
//  CoroutineScope(Dispatchers.IO).launch {
//      test()
//  }
    //在不指定携程上下文的时候默认继承外层的线程
//    runBlocking {
//        println("111")
//    }
    //指定了就会使用指定的线程
//    runBlocking(Dispatchers.IO) {
//        println("111")
//    }
    // runBlocking默认创建的是阻塞的的携程直到执行完成才会往下执行
//    val runBlocking = runBlocking(Dispatchers.IO) {
//        delay(1000)
//        1
//    }
//    val runBlocking = runBlocking(Dispatchers.IO) {
//        println(Thread.currentThread().name)
//        delay(1000)
//        //没有指定的调度器的时候默认还是在io调度器上面,所以被分配的还是io线程,但是我们并不直到分配的是那个线程
//        val job = launch {
//            delay(1000)
//            //此时创建的并非是阻塞的
//            println(Thread.currentThread().name)
//        }
//        println(job.isActive)
//        job.cancel()
//        println(job.isActive)
//
//    }
    //模拟一个网路请求任务
    runBlocking(Dispatchers.Default) {
        println("当前运行的线程是1:${Thread.currentThread().name}")
        println("当前的调度器1${coroutineContext[CoroutineDispatcher]}")
        //进行网络请求
        withContext(context = Dispatchers.IO) {
            request {
                println("当前的调度器4${coroutineContext[CoroutineDispatcher]}")
//            //请求成功以后进入主线程进行操作,一般用于安卓的ui更新
//            //coroutineContext是上一层携程的调度器线程
                withContext(context = coroutineContext) {
                    println("当前运行的线程是3:${Thread.currentThread().name}")
                    println("当前的调度器3${coroutineContext[CoroutineDispatcher]}")
                }
            }
        }
    }


}

@OptIn(ExperimentalStdlibApi::class)
suspend fun request(function: suspend () -> Unit) {
    withContext(Dispatchers.Default) {
        delay(1000)
        println("当前运行的线程是2:${Thread.currentThread().name}")
        println("当前的调度器2${coroutineContext[CoroutineDispatcher]}")
        println("网络请求成功")
        function()
    }

}

suspend fun test() {

    println("携程开始")
    Thread.sleep(1000)
    println("携程结束")

}
