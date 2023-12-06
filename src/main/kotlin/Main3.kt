import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.selects.select

/**
 * @author chenxinzhi
 * @date 2023/9/20
 */
fun main() {
    runBlocking {
        delay(11)
        val async = async {
            1
        }




        val 名称:String="小明"
        println(名称)





        println("hello")
        //不执行await()携程代码块中的代码还是会执行,但是可以会在上面的hello后面执行
        async.await()
        //
        val async1 = async(start = CoroutineStart.LAZY) {
            1
        }
        async1.await()//调用了await后相当于就执行了start
        select {
            //谁先返回就返回谁,只取其中一个
            async.onAwait{
                it
            }
            async1.onAwait{
                it
            }
        }
    }

}

