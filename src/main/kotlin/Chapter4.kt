import Button.ButtonState
import java.io.File
import java.io.Serializable

interface Clickable {
    fun click()
    fun showOff() = println("I'm clickable!")
}

interface Focusable {
    fun setFocus(b: Boolean) =
        println("I ${if (b) "got" else "lost"} focus.")
    fun showOff() = println("I'm focusable!")
}


//class Button : Clickable, Focusable {
//    override fun click() = println("I was clicked")
//    override fun showOff() {
//        super<Clickable>.showOff()
//        super<Focusable>.showOff()
//    }
//}

open class RichButton : Clickable {
    fun disable() {}
    open fun animate() {}
    final override fun click() {}
}

abstract class Animated {
    abstract fun animate()
    open fun stopAnimating(){}
    fun animateTwice(){}
}

interface State: Serializable

interface View {
    fun getCurrentState(): State
    fun restoreState(state: State){}
}

class Button: View {
    override fun getCurrentState(): State = ButtonState()
    override fun restoreState(state: State) {
        super.restoreState(state)
    }
    class ButtonState: State {}
}

//interface User {
//    val nickname: String
//}

//class PrivateUser(override val nickname: String): User
//
//class SubscribingUser(private val email: String): User {
//    override val nickname: String
//        get() = email.substringBefore('@')
//}
//
fun getFacebookName(accountId: Int): String {
    return "facebook Name"
}
//
//class FacebookUser(val accountId: Int) : User {
//    override val nickname = getFacebookName(accountId)
//}

//class User(val name: String) {
//    var address: String = "unspecified"
//        set(value: String) {
//            println("""
//                Address was changed for $name:
//                "$field" -> "$value".""".trimIndent())
//            field = value
//        }
//}

//class LengthCounter {
//    var counter: Int = 0
//        private set
//    fun addWord(word: String){
//        counter += word.length
//    }
//}

class Clinet(val name: String, val postalCode: Int) {

    override fun equals(other: Any?): Boolean {
        if(other == null || other !is Clinet)
            return false
        return name == other.name && postalCode == other.postalCode
    }

    override fun hashCode(): Int = name.hashCode() * 31 + postalCode
    override fun toString() = "Client(name=$name, postalCode=$postalCode)"

    fun copy(name: String = this.name, postalCode: Int = this.postalCode) = Clinet(name, postalCode)
}

//data class Clinet(val name: String, val postalCode: Int)

class CountingSet<T>(
    val innerSet: MutableCollection<T> = HashSet<T>()
): MutableCollection<T> by innerSet {
    var objectsAdded = 0
    override fun add(element: T): Boolean {
        objectsAdded++
        return innerSet.add(element)
    }

    override fun addAll(c: Collection<T>): Boolean {
        objectsAdded += c.size
        return innerSet.addAll(c)
    }
}

object CaseInsensitiveFileComparator: Comparator<File> {
    override fun compare(file1: File, file2: File): Int {
        return file1.path.compareTo(file2.path, ignoreCase = true)
    }
}

data class Person(val name: String) {
    object NameComparator: Comparator<Person> {
        override fun compare(p1: Person, p2: Person): Int =
            p1.name.compareTo(p2.name)
    }
}

class User private constructor(val nickName: String){

    companion object {
        fun newSubscribingUser(email: String) = User(email.substringBefore('@'))

        fun newFacebookUser(accountId: Int) {
             User(getFacebookName(accountId))
        }
    }
}


fun main(args: Array<String>) {
//    Button().click()
//    Button().showOff()
//    val button = Button()
//    button.showOff()
//    button.setFocus(true)
//    button.click()
//    println(PrivateUser("test@kotlin.org").nickname)
//    println(SubscribingUser("test@kotlin.org").nickname)
//    val user = User("Alice")
//    user.address = "Elsenheimerstrasse 47, 80687 Muenchen"

//    val lengthCounter = LengthCounter()
//    lengthCounter.addWord("Hi!")
//    println(lengthCounter.counter)

//    val client1 = Clinet("오현석", 4122)
//    val clinet2 = Clinet("오현석", 4122)
//    println(client1 == clinet2)

//    val processed = hashSetOf(Clinet("오현석", 4122))
//    println(processed.contains(Clinet("오현석", 4122)))

//    val lee = Clinet("이계영", 4122)
//    println(lee.copy(postalCode = 4000))

//    val cset = CountingSet<Int>()
//    cset.addAll(listOf(1, 1, 2))
//    println("${cset.objectsAdded} objects were added, ${cset.size} remain")

//    println(CaseInsensitiveFileComparator.compare(File("/User"), File("/user")))

//    val files = listOf(File("/Z"), File("/a"))
//    println(files.sortedWith(CaseInsensitiveFileComparator))

//    val persons = listOf(Person("Bob"), Person("Alice"))
//    println(persons.sortedWith(Person.NameComparator))

    val subscribingUser = User.newSubscribingUser("bob@gmail.com")
    val facebookUser = User.newFacebookUser(4)
    println(subscribingUser.nickName)
}
