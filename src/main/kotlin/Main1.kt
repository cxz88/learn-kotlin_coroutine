/**
 * @author chenxinzhi
 * @date 2023/8/31
 */
//@OptIn(DelicateCoroutinesApi::class)
fun main() {
    //全局作用的携程作用域,不阻塞当前线程,不建议使用,由于他的作用域是整个生命周期的,我们无法在这个里面将其关闭,会报错
//    var globalScope = GlobalScope
//    var launch = globalScope.launch {
//        delay(1000)
//        println("hello")
//    }
//    globalScope.cancel() //无法正常关闭
////    launch.cancel()
//    //建议使用该方法创建携程,会作用在当前作用域上面,跟随当前作用域存在,并且可以关闭其创建的所有携程
//    var coroutineScope = CoroutineScope(Dispatchers.Default)
//    coroutineScope.launch {
//
//    }
//    coroutineScope.cancel()//可以正常取消
//    while (true);

}