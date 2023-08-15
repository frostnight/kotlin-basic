import java.math.BigDecimal

data class Point(val x: Int, val y: Int) {
    operator fun plus(other: Point): Point {
        return Point(x + other.x, y + other.y)
    }
}

operator fun Point.times(scale: Double): Point {
    return Point((x * scale).toInt(), (y * scale).toInt())
}

operator fun Char.times(count: Int): String {
    return toString().repeat(count)
}

operator fun <T> MutableCollection<T>.plusAssign(element: T) {
    this.add(element)
}

operator fun Point.unaryMinus(): Point {
    return Point(-x, -y)
}

operator fun BigDecimal.inc() = this + BigDecimal.ONE

fun main(args: Array<String>) {
//    val p1 = Point(10, 20)
//    val p2 = Point(30, 40)
//    println(p1 + p2)

//    val p = Point(10, 20)
//    println(p * 1.5)

//    println('a' * 3)

//    var point = Point(1, 2)
//    point += Point(3, 4)
//    println(point)

//    val numbers = ArrayList<Int>()
//    numbers += 42
//    println(numbers[0])

//    val list = arrayListOf(1, 2)
//    list += 3   // +=는 "list"를 변경한다.
//    val newList = list + listOf(4, 5)   // +는 두 리스트의 모든 원소를 포함하는 새로운 리스트를 반환한다.
//    println(list)
//    println(newList)

//    val p = Point(10, 20)
//    println(-p)

    var bd = BigDecimal.ZERO
    println(bd++)
    println(++bd)
}

