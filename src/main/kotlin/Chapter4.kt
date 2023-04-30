import Button.ButtonState
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

fun main(args: Array<String>) {
//    Button().click()
//    Button().showOff()
//    val button = Button()
//    button.showOff()
//    button.setFocus(true)
//    button.click()
}
