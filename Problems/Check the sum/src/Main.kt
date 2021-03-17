fun main() {
    val a: Int = readLine()!!.toInt()
    val b: Int = readLine()!!.toInt()
    val c: Int = readLine()!!.toInt()

    println(resultAsString(pairSumsTo20(a, b, c)))
}

fun resultAsString(res: Boolean): String {
    return if (res) "true" else "false"
}

fun pairSumsTo20(first: Int, second: Int, third: Int): Boolean {
    return sumsTo20(first, second) || sumsTo20(first, third) || sumsTo20(second, third)
}

fun sumsTo20(first: Int, second: Int): Boolean {
    return first + second == 20
}