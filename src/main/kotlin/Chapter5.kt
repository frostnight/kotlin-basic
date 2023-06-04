import java.util.Collections
import kotlin.math.max

data class Person(val name: String, val age: Int)

fun findTheOldest(people: List<Person>) {
    var maxAge = 0
    var theOldest: Person? = null
    for (person in people) {
        if(person.age > maxAge) {
            maxAge = person.age
            theOldest = person
        }
    }
    println(theOldest)
}

fun printMessageWithPrefix(messages: Collection<String>, prefix: String) {
    messages.forEach {
        println("$prefix $it")
    }
}

fun printProblemCounts(responses: Collection<String>) {
    var clientErrors = 0
    var serverErrors = 0
    responses.forEach {
        if (it.startsWith("4")) {
            clientErrors++
        } else if (it.startsWith("5")) {
            serverErrors++
        }
    }
    println("$clientErrors client errors, $serverErrors server errors")
}

fun salute() = println("Salute!")


fun main(args: Array<String>) {
    val people = listOf(Person("Alice", 29), Person("Bob", 31))
//    findTheOldest(people)
//    println(people.maxBy { it.age })
//    println(people.maxBy{ p -> p.age })
//    println(people.joinToString(" "){p: Person -> p.name})
//    val getAge = {p: Person -> p.age}
//    println(people.maxBy(getAge))

//    val errors = listOf("403 Forbidden", "404 Not Found")
//    printMessageWithPrefix(errors, "Error:")

//    var responses = listOf("200 OK", "418 I'm a teapot", "500 Internal Server Error")
//    printProblemCounts(responses)

    run(::salute)
}