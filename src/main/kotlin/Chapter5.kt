import java.lang.StringBuilder
import java.time.Period
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

class Book(val title: String, val authors: List<String>)


fun main(args: Array<String>) {
//    val people = listOf(Person("Alice", 29), Person("Bob", 31),
//    Person("Carol", 31))
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

//    run(::salute)

//    val maxAge = people.maxBy(Person::age)!!.age
//    println(maxAge)
//    people.filter { it.age == maxAge }

//    val strings = listOf("abc", "def")
//    println(strings.flatMap { it.toList() })

//    val books = listOf(Book("Thursday Next", listOf("Jasper Fforde")),
//                        Book("Mort", listOf("Terry Pratchett")),
//                        Book("Good Omens", listOf("Terry Pratchett", "Neil Gaiman")))
//    println(books.flatMap { it.authors }.toSet())

//    people.asSequence()
//        .map(Person::name)
//        .filter { it.startsWith("A") }
//        .toList()

//    val people2 = listOf(Person("Alice", 29), Person("Bob", 31),
//    Person("Charles", 31), Person("Dan", 21))
//    println(people2.asSequence().map(Person::name).filter { it.length < 4 }.toList())
//    println(people2.asSequence().filter{ it.name.length < 4 }.map(Person::name).toList())

//    val naturalNumbers = generateSequence(0) { it + 1}
//    val numbersTo100 = naturalNumbers.takeWhile { it <= 100 }
//    println(numbersTo100.sum())

//    fun createAllDoneRunnable(): Runnable {
//        return Runnable { println("All done!") }
//    }
//    createAllDoneRunnable().run()

//    fun alphabet(): String {
//        val result = StringBuilder()
//        for(letter in 'A' .. 'Z') {
//            result.append(letter)
//        }
//        result.append("\nNow I know the alphabet!")
//        return result.toString()
//    }

//    fun alphabet(): String {
//        val stringBuilder = StringBuilder()
//        return with(stringBuilder) {
//            for ( letter in 'A'..'Z'){
//                this.append(letter)
//            }
//            append("\nNow I know the alphabet!2")
//            this.toString()
//        }
//    }

//    fun alphabet() = with(StringBuilder()) {
//        for(letter in 'A'..'Z') {
//            append(letter)
//        }
//        append("\nNow I know the alphabet")
//        toString()
//    }

//    fun alphabet() = StringBuilder().apply {
//        for (letter in 'A'..'Z') {
//            append(letter)
//        }
//        append("\nNow I know the alphabet!")
//    }.toString()

    fun alphabet() = buildString {
        for(letter in 'A'..'Z'){
            append(letter)
        }
        append("\nNow I Know the alphabet!")
    }

    println(alphabet())
}