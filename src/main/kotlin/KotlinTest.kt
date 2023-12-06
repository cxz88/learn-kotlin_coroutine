import org.jetbrains.annotations.NotNull

/**
 * @author chenxinzhi
 * @date 2023/11/23
 */
class Data {
    @field:NotNull
    var name: String = "小明"
        get():String {
            println("get")
            return field;
        }
        set(value) {
            field = value
        }

}

fun main() {
    var data = Data()
    println(data.name)
}