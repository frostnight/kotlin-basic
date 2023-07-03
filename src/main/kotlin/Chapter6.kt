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
    val address = Address("Elsestr. 47", 80687, "Munich", "Germany")
    val jetbrains = Company("JetBrains", address)
    val person = PersonCh6("Dmitry", jetbrains)
    printShippingLabel(person)
    printShippingLabel(PersonCh6("Alexey", null))
}
