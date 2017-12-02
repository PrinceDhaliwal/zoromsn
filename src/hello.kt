import org.jetbrains.annotations.NotNull
import java.io.File
import java.util.logging.Logger
import kotlin.test.assertEquals

fun main(args: Array<String>) {
    println(sum(10, 20))
    printSum(10, 30)
    println("Hello, World")

    var a = 10
    val s = "a is $a"
    a = 20
    val s2 = "${s.replace("is", "was")}, but now is $a"
    println(s2)

    loops()
    javaInterop()

    simpleClass()

    maps()
    lazyProperties()

    ifNotNullShorthand()

    ifNotElseNullShorthand()

    whenStatement()

    val intArray = arrayOfMinuses(5)
    println(intArray.joinToString(", "))

    oops();
}

fun loops() {
    val list = listOf("a", "b", "c", "d")
    for (item in list) {
        println(item)
    }

    val map = list.map { it -> it + "a" }

    for (item in map) {
        println(item)
    }
}

fun javaInterop() {
    val me = HelloWorld("Prince")
    me.sayHello()

    me.callBackToKot()
}

fun printSum(a: Int, b: Int) {
    println("sum of $a and $b is ${a + b}")
}

fun sum(a: Int, b: Int) : Int = a + b

val logger = Logger.getLogger("PRINCE")

fun simpleClass() {
    val cust = Customer("Prince", "dhaliwalprince@hotmail.com")
    val anot = Customer("Prince", "dhaliwalprince@hotmail.com")
    assertEquals(cust, anot)

    cust.sayHello()

    logger.info("customer and another customer are equal and are ${cust.toString()} $anot")

}

data class Customer(val name: String, val email: String)

fun Customer.toString() : String {
    return "Customer: Name{$name}, Email{$email}"
}

fun Customer.sayHello() {
    println("Hello there")
}

fun maps() {
    val map = hashMapOf<String, String>(Pair("name", "Prince"), Pair("year", "4th"))
    map["name"] = "Dhaliwal"

    val fixedMap = hashMapOf<String, String>("name" to "Prince Dhaliwal", "year" to "4th")
    fixedMap["name"] = "Dhaliwal Prince"
    for ((k, v) in map) {
        println("$k is $v")
    }

    for ((k, v) in fixedMap) {
        println("$k is $v")
    }
}

fun lazyProperties() {
    val s: String by lazy {
        "PRince" + "Dhaliwal"
    }

    println(s);

    println(s.toSpaceCamelCase())
}

// extension functions
fun String.toSpaceCamelCase(): String {
    return this.toUpperCase()
}

fun ifNotNullShorthand() {
    val files = File(Resource.name).listFiles()
    files?.forEach { println(it.name) }
}

// creating singleton
object Resource {
    val name = "src"
}

fun ifNotElseNullShorthand() {
    val map = mapOf<String, String>("name" to "Prince", "dhaliwal" to "yes", "email" to "dhaliwalPrince")
    val email = map["email"] ?: throw IllegalStateException("Email is not defined")
    println(email);
}


fun whenStatement() : Int {
    val x = 10
    return when (x) {
        20 -> 20
        10 -> 10
        else -> throw IllegalStateException("Invalid value of x")
    }
}

// builder style usage of methods that return Unit
fun arrayOfMinuses(size: Int): IntArray {
    return IntArray(size).apply { fill(-1) }
}

fun oops() {
    var f = Foo()
    f.f()

    f = DerivedFoo()
    f.f()
}

open class Foo {
    open fun f() { println(x) }
    open val x: Int get() = 1
}

class DerivedFoo : Foo() {
    override val x: Int get() = super.x + 1
}
