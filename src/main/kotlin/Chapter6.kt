import java.lang.IllegalArgumentException

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

//    ignoreNulls(null)
//    var email: String? = "yole@example.com"
//    email?.let {
//        sendEmailTo(it)
//    }
//    email = null
//    email?.let { sendEmailTo(it) }

//    verifyUserInput(" ")
//    verifyUserInput(null)

//    printHashCode(42)

//    yellAtSafe(PersonJava(null))


}
