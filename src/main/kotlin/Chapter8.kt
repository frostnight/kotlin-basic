import java.lang.StringBuilder
import java.time.Period

fun twoAndThree(operation: (Int, Int) -> Int) {
    val result = operation(2, 3)
    println("The result is $result")
}


fun String.filter(predicate: (Char) -> Boolean) : String {
    val sb = StringBuilder()
    for (index in 0 until length) {
        val element = get(index)
        if (predicate(element)) sb.append(element)
    }
    return sb.toString()
}

fun processTheAnswer(f: (Int) -> Int) {
    println(f(42))
}

fun <T> Collection<T>.joinToString(
    separator: String = ", ",
    prefix: String = "",
    postfix: String = "",
    transform: ((T) -> String)? = null
): String {
    val result = StringBuilder(prefix)
    for((index, element) in this.withIndex()) {
        if(index > 0) result.append(separator)
        val str = transform?.invoke(element)
            ?: element.toString()
        result.append(str)
    }
    result.append(postfix)
    return result.toString()
}

enum class Delivery { STANDARD, EXPEDITED }

class Order(val itemCount: Int)

fun getShippingCostCalculator(delivery: Delivery): (Order) -> Double {
    if (delivery == Delivery.EXPEDITED) {
        return { order -> 6 + 2.1 * order.itemCount }
    }
    return { order -> 1.2 * order.itemCount }
 }

data class PersonCh8(
    val firstName: String,
    val lastName: String,
    val phoneNumber: String?
)

class ContractListFilters {
    var prefix: String = ""
    var onlyWithPhoneNumber: Boolean = false

    fun getPredicate(): (PersonCh8) -> Boolean {
        val startWithPrefix = { p: PersonCh8 ->
            p.firstName.startsWith(prefix) || p.lastName.startsWith(prefix)
        }
        if(!onlyWithPhoneNumber) {
            return startWithPrefix
        }
        return {
            startWithPrefix(it)
                    && it.phoneNumber != null
        }
    }
}

data class SiteVisit(
    val path: String,
    val duration: Double,
    val os: OS
)

enum class OS { WINDOWS, LINUX, MAC, IOS, ANDROID }

val log = listOf(
    SiteVisit("/", 34.0, OS.WINDOWS),
    SiteVisit("/", 22.0, OS.MAC),
    SiteVisit("/login", 12.0, OS.WINDOWS),
    SiteVisit("signup", 8.0, OS.IOS),
    SiteVisit("/", 16.3, OS.ANDROID)
)

fun main(args: Array<String>) {
//    twoAndThree{a, b -> a + b}
//    twoAndThree{a, b -> a * b}

//    println("ab1c".filter { it in 'a'..'z' })

//    val letters = listOf("Alpha", "Beta")
//    println(letters.joinToString { it.lowercase()})
//    println(letters.joinToString(separator = "! ", postfix = "! ", transform = {it.uppercase()}))

//    val calculator = getShippingCostCalculator(Delivery.EXPEDITED)
//    println("Shipping costs ${calculator(Order(3))}")

    val contacts = listOf(PersonCh8("Dmitry", "Jemerov", "123-4567"),
            PersonCh8("Sveltlana", "Isakova", null))
    val contractListFilters = ContractListFilters()
    with(contractListFilters) {
        prefix = "Dm"
        onlyWithPhoneNumber = true
    }
    println(contacts.filter(contractListFilters.getPredicate()))

}