package samples.kotlin_fundamentals.section4_function_in_kotlin

fun main(args: Array<String>) {
    display("Brian!")
    println(max(2, 5))
    log("Brian")
    log("Brian", 2)
}

fun display(message: String) {
    println("Hello, World: $message")
}


fun max(a: Int, b: Int): Int = if (a > b) a else b

fun log(message: String, loglevel: Int = 1) {
    println(message + loglevel)
}