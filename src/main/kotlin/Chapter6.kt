import java.io.BufferedReader
import java.io.File
import java.io.StringReader
import java.lang.IllegalArgumentException
import java.lang.NumberFormatException

fun strLen(s: String) = s.length

fun strLenSafe(s: String?): Int =
    s?.length ?: 0

fun printAllCaps(s: String?){
    val allCaps: String? = s?.uppercase()
    println(allCaps)
}

class Employee(val name: String, val manager: Employee?)
fun managerName(employee: Employee): String? = employee.manager?.name

class Address(val streetAddress: String, val zipCode: Int, val city: String, val country: String)
class Company(val name: String, val address: Address?)
class PersonCh6(val name: String, val company: Company?)

fun PersonCh6.countryName() = company?.address?.country ?: "Unknown"

fun printShippingLabel(person: PersonCh6) {
    val address = person.company?.address?: throw IllegalArgumentException("No address")
    with (address) {
        println(streetAddress)
        println("$zipCode $city, $country")
    }
}

class PersonCh6V2(val firstName: String, val lastName: String) {
    override fun equals(o: Any?): Boolean {
        val otherPerson = o as? PersonCh6V2 ?: return false

        return otherPerson.firstName == firstName && otherPerson.lastName == lastName
    }

    override fun hashCode(): Int =
        firstName.hashCode() * 37 + lastName.hashCode()
}

fun ignoreNulls(s: String?) {
    val sNotNull: String = s!!
    println(sNotNull.length)
}

fun sendEmailTo(email: String) {
    println("Sending email to $email")
}

fun verifyUserInput(input: String?){
    if (input.isNullOrBlank()) {
        println("Please fill in the required fields")
    }
}

fun <T: Any> printHashCode(t: T){
    println(t.hashCode())
}

fun yellAt(person: PersonJava) {
    println(person.name.uppercase() + "!!!")
}

fun yellAtSafe(person: PersonJava) {
    println((person.name ?: "Anyone").uppercase() + "!!!")
}

class StringPrinter: StringProcessor {
    override fun process(value: String?) {
        println(value)
    }
}

class NullableStringPrinter : StringProcessor {
    override fun process(value: String?) {
        if (value != null){
            println(value)
        }
    }
}

class PersonCh6V3(val name: String, val age: Int? = null) {
    fun isOlderThan(other: PersonCh6V3): Boolean? {
        if (age == null || other.age == null)
           return null
        return age > other.age
    }
}

fun readNumbers(reader: BufferedReader): List<Int?> {
    val result = ArrayList<Int?>()
    for (line in reader.lineSequence()) {
        try {
            val number = line.toInt()
            result.add(number)
        } catch (e: NumberFormatException) {
            result.add(null)
        }
    }
    return result
}

fun addValidNumbers(numbers: List<Int?>) {
//    var sumOfValidNumbers = 0
//    var invalidNumbers = 0
//
//    for(number in numbers) {
//        if(number != null) {
//            sumOfValidNumbers += number
//        } else {
//            invalidNumbers++
//        }
//    }
//    println("Sum of valid numbers: $sumOfValidNumbers")
//    println("Invalid numbers: $invalidNumbers")

    // refactoring
    val validNumbers = numbers.filterNotNull()
    println("Sum of valid numbers: ${validNumbers.sum()}")
    println("Invalid numbers: ${numbers.size - validNumbers.size}")

}

fun <T> copyElements(source: Collection<T>, target: MutableCollection<T>) {
    for(item in source) {
        target.add(item)
    }
}

class FileIndexer : FileContentProcessor {
    override fun processContents(path: File, binaryContents: ByteArray?, textContents: List<String>?) {
        TODO("Not yet implemented")
    }
}

class PersonParser: DataParser<PersonCh6V3> {
    override fun parseData(input: String, output: MutableList<PersonCh6V3>, errors: MutableList<String?>) {
        TODO("Not yet implemented")
    }
}


fun main(args: Array<String>) {
//    val x: String? = null
//    println(strLenSafe("abc"))

//    printAllCaps("abc")
//    printAllCaps(null)

//    val ceo = Employee("Da Boss", null)
//    val developer = Employee("Bob Smith", ceo)
//    println(managerName(developer))
//    println(managerName(ceo))

//    val person = PersonCh6("Dmitry", null)
//    println(person.countryName())

//    val address = Address("Elsestr. 47", 80687, "Munich", "Germany")
//    val jetbrains = Company("JetBrains", address)
//    val person = PersonCh6("Dmitry", jetbrains)
//    printShippingLabel(person)
//    printShippingLabel(PersonCh6("Alexey", null))

//    val p1 = PersonCh6V2("Dmitry", "Jemerov")
//    val p2 = PersonCh6V2("Dmitry", "Jemerov")
//    println(p1 == p2)
//    print(p1.equals(42))


//    verifyUserInput(" ")
//    verifyUserInput(null)
//    ignoreNulls(null)
//    var email: String? = "yole@example.com"
//    email?.let {
//        sendEmailTo(it)
//    }
//    email = null
//    email?.let { sendEmailTo(it) }

//    printHashCode(42)

//    yellAtSafe(PersonJava(null))

//    println(PersonCh6V3("Sam", 35).isOlderThan(PersonCh6V3("Amy", 42)))
//    println(PersonCh6V3("Sam", 35).isOlderThan(PersonCh6V3("Jane")))

//    var reader = BufferedReader(StringReader("1\nABC\n42"))
//    val numbers = readNumbers(reader)
//    addValidNumbers(numbers)

//    val source: Collection<Int> = arrayListOf(3, 5, 7)
//    val target: MutableCollection<Int> = arrayListOf(1)
//    copyElements(source, target)
//    println(target)

//    val letters = Array<String>(26) { i -> ('a' + i).toString()}
//    println(letters.joinToString(""))

    val strings = listOf("a", "b", "c")
    println("%s/%s/%s".format(*strings.toTypedArray()))

}

