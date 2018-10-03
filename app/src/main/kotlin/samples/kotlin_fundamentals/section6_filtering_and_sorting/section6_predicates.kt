package samples.kotlin_fundamentals.section6_filtering_and_sorting

fun main(args: Array<String>) {
    val ints = listOf(1, 2, 3, 4, 5)

    var largeInts = ints.all { it > 6 }
    println(largeInts)

    largeInts = ints.all { it > 3 }
    println(largeInts)

    largeInts = ints.any { it > 3 }
    println(largeInts)

    val numberOfInts = ints.count { it > 3 }
    println(numberOfInts)

    // Predicate
    val greaterThan3 = { v: Int -> v > 3 }

    val numberOfInts2 = ints.count(greaterThan3)
    println(numberOfInts2)

    println(ints.find(greaterThan3))

    // Returns null because it does not exist
    println(ints.find { it > 7 })

    // We see this is Int?, this means this variable
    // can be an integer or a null value
    var found: Int? = ints.find { it > 6 }

}
