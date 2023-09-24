import java.beans.PropertyChangeListener
import java.beans.PropertyChangeSupport
import java.lang.IndexOutOfBoundsException
import java.math.BigDecimal
import java.time.LocalDate
import java.time.Period
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

data class Point(val x: Int, val y: Int) {
    operator fun plus(other: Point): Point {
        return Point(x + other.x, y + other.y)
    }

    override fun equals(obj: Any?): Boolean {
        if (obj === this) return true
        if (obj !is Point) return false
        return obj.x == x && obj.y == y
    }
}

class PersonCh7(
    val firstName: String, val lastName: String
) : Comparable<PersonCh7> {
    override fun compareTo(other: PersonCh7): Int {
        return compareValuesBy(this, other, PersonCh7::lastName, PersonCh7::firstName)
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

operator fun Point.get(index: Int): Int {
    return when(index) {
        0 -> x
        1 -> y
        else ->
            throw IndexOutOfBoundsException("Invalid coordinate $index")
    }
}

data class MutablePoint(var x: Int, var y: Int)

operator fun MutablePoint.set(index: Int, value: Int) {
    when(index) {
        0 -> x = value
        1 -> y = value
        else ->
            throw IndexOutOfBoundsException("Invalid coordinate $index")
    }
}

data class Rectangle(val upperLeft: Point, val lowerRight: Point)

operator fun Rectangle.contains(p: Point): Boolean {
    return p.x in upperLeft.x until lowerRight.x  &&
            p.y in upperLeft.y until lowerRight.y
}

operator fun ClosedRange<LocalDate>.iterator() : Iterator<LocalDate> =
    object : Iterator<LocalDate> {
        var current = start
        override fun hasNext() =
            current <= endInclusive
        override fun next() = current.apply {
            current = plusDays(1)
        }
    }

data class NameComponents(
    val name: String,
    val extension: String)

fun splitFilename(fullName: String): NameComponents {
    val (name, extension) = fullName.split('.', limit = 2)
    return NameComponents(name, extension)
}

fun printEntries(map: Map<String, String>) {
    for ((key, value) in map) {
        println("$key -> $value")
    }
}

open class PropertyChangeAware {
    protected val changeSupport = PropertyChangeSupport(this)

    fun addPropertyChangeListener(listener: PropertyChangeListener) {
        changeSupport.addPropertyChangeListener(listener)
    }

    fun removePropertyChangeListner(listener: PropertyChangeListener) {
        changeSupport.removePropertyChangeListener(listener)
    }
}

class ObservableProperty(
//    var propName: String, var propValue: Int,
//    val changeSupport: PropertyChangeSupport
    var propValue: Int, val changeSupport: PropertyChangeSupport
) {
//    fun getValue(): Int = propValue
//    fun setValue(newValue: Int) {
//        val oldValue = propValue
//        propValue = newValue
//        changeSupport.firePropertyChange(propName, oldValue, newValue)
//    }

    operator fun getValue(p: PersonCh72nd, prop: KProperty<*>) : Int = propValue
    operator fun setValue(p: PersonCh72nd, prop: KProperty<*>, newValue: Int) {
        val oldValue = propValue
        propValue = newValue
        changeSupport.firePropertyChange(prop.name, oldValue, newValue)
    }
}

class PersonCh72nd(
    val name: String, age: Int, salary: Int
) : PropertyChangeAware() {
//    var age: Int = age
//        set(newValue){
//            val oldValue = field
//            field = newValue
//            changeSupport.firePropertyChange(
//                "age", oldValue, newValue
//            )
//        }
//    var salary: Int = salary
//        set(newValue) {
//            val oldValue = field
//            field = newValue
//            changeSupport.firePropertyChange(
//                "salary", oldValue, newValue
//            )
//        }

//    val _age= ObservableProperty("age", age, changeSupport)
//    var age: Int
//        get() = _age.getValue()
//        set(value) { _age.setValue(value) }
//    val _salary = ObservableProperty("salary", salary, changeSupport)
//    var salary: Int
//        get() = _salary.getValue()
//        set(value) { _salary.setValue(value)}

//    var age: Int by ObservableProperty(age, changeSupport)
//    var salary: Int by ObservableProperty(salary, changeSupport)

    private val observer = {
        prop: KProperty<*>, oldValue: Int, newValue: Int ->
        changeSupport.firePropertyChange(prop.name, oldValue, newValue)
    }

    var age: Int by Delegates.observable(age, observer)
    var salary: Int by Delegates.observable(salary, observer)
}

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

//    var bd = BigDecimal.ZERO
//    println(bd++)
//    println(++bd)

//    println(Point(10, 20 ) == Point(10, 20))
//    println(Point(10, 20) != Point(5, 5))
//    println(null == Point(1,2))

//    val p1 = PersonCh7("Alice", "Smith")
//    val p2 = PersonCh7("Bob", "Johnson")
//    println(p1 < p2)

//    val p = Point(10, 20)
//    println(p[1])

//    val p = MutablePoint(10, 20)
//    p[1] = 42®
//    println(p)

//    val rect = Rectangle(Point(10, 20), Point(50, 50))
//    println(Point(20, 30) in rect)
//    println(Point(5, 5) in rect)

//    val now = LocalDate.now()
//    val vacation = now..now.plusDays(10)
//    println(now.plusWeeks(1) in vacation)

//    val newYear = LocalDate.ofYearDay(2017, 1)
//    val daysOff = newYear.minusDays(1)..newYear
//    for (dayOff in daysOff) { println(dayOff) }

//    val (name, ext) = splitFilename("example.kt")
//    println(name)
//    print(ext)

//    val map = mapOf("Oracle" to "Java", "JetBrains" to "Kotlin")
//    printEntries(map)

    val p = PersonCh72nd("Dmitry", 34, 2000)
    p.addPropertyChangeListener(
        PropertyChangeListener { event ->
            println("Property ${event.propertyName} changed " +
                "from ${event.oldValue} to ${event.newValue}")
        }
    )
    p.age = 35
    p.salary = 2100
}

