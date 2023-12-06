
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.AbstractCoroutineContextElement
import kotlin.coroutines.CoroutineContext

/**
 * @author chenxinzhi
 * @date 2023/9/4
 */
@OptIn(ExperimentalStdlibApi::class) //表示同意ExperimentalStdlibApi的使用,相当于用户许可协议,同意了才能用
fun main() {
    val coroutineName = CoroutineName
    println(coroutineName)
//    runBlocking {
//        launch(CoroutineName("coroutine1")) {
//            val coroutineContext1 = coroutineContext
//            println(coroutineContext1)
//            val coroutineName1 = coroutineContext.get(coroutineName) //这里取的实际是CoroutineName
//            println(coroutineName1)
//            val coroutineName3 = CoroutineName
//            println(coroutineName3)
//        }
//    }
//    runBlocking {
//        launch(Dispatchers.IO) {
//            //获取上下文中的调度器名称
//            val coroutineDispatcher = coroutineContext[CoroutineDispatcher]
//            println(coroutineDispatcher)
//
//        }
//    }
    //在不指定调度器的时候会使用最外面的正在使用的线程
    runBlocking {
        launch {
            //获取上下文中的调度器名称
            val coroutineDispatcher = coroutineContext[CoroutineDispatcher]
            println(coroutineDispatcher)

        }
    }
}

class C
interface A {
    var name: C
}

class B() {


}

data class CoroutineName(
    /**
     * User-defined coroutine name.
     */
    val name: String
) : AbstractCoroutineContextElement(CoroutineName) {
    /**
     * Key for [CoroutineName] instance in the coroutine context.
     */
    companion object Key : CoroutineContext.Key<CoroutineName>

    /**
     * Returns a string representation of the object.
     */
    override fun toString(): String = "CoroutineName($name)"
}