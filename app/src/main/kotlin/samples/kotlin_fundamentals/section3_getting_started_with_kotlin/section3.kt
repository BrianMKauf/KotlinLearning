package samples.kotlin_fundamentals.section3_getting_started_with_kotlin

import java.util.*

fun main(args: Array<String>) {
    println("Hello World")
    var q = Question()
    q.Answer = "42" //Switch to non parsable string to test try-catch

    q.display()

    println("The answer to the question ${q.Question} is ${q.Answer}")

    val message = if (q.Answer == q.CorrectAnswer) "You are correct" else "Try again :("

    println(message)
    q.printResult()

    val number:Int? = try {
        Integer.parseInt(q.Answer)
    } catch(e:NumberFormatException) {
        null
    }

    println("Number is $number")

    for(i in 1..10) {
        print("$i ")
    }

    println()

    for(i in 10 downTo 1 step 2) {
        print("$i ")
    }

    println()

    for(i in 1 until 10) {
        print("$i ")
    }

    println()

    var numbers = listOf(1,2,3,4,5)

    for(number in numbers) {
        print("$number ")
    }

    println()

    for((index, element) in numbers.withIndex()) {
        println("$element at $index")
    }

    var ages = TreeMap<String, Int>()
    ages["Brian"] = 24
    ages["Alana"] = 27
    ages["Milo"] = 2
    ages["Mia"] = 1

    for((name, age) in ages) {
        println("$name: $age")
    }


}

class Question {
    var Answer: String? = null
    val CorrectAnswer: String = "42"
    val Question: String = "What is the answer to life, the universe, and everything"

    fun display() {
        println("You said $Answer")
    }

    fun printResult() {
        val message = when (Answer) {
            CorrectAnswer -> "You are correct"
            else -> "Try again :("
        }
        println(message)
    }


}