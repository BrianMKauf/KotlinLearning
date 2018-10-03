package samples.kotlin_fundamentals.section6_filtering_and_sorting

fun main(args: Array<String>) {
    val ints = listOf(1, 2, 3, 4, 5)

    val smallInts = ints.filter { it < 4 }

    println(smallInts.toString())

    val squaredInts = ints.map { it * it }

    for (i: Int in squaredInts) println(i)

    val smallSquaredInts = ints.filter { it < 5 }.map { it * it }

    println(smallSquaredInts)

    val meetings = listOf(Meeting(1, "Board Meeting"), Meeting(2, "Committe Meeting"))
    val titles = meetings.filter { it -> it.title.startsWith("C") }.map { m -> m.title }
    for (t in titles) println(t)

}

class Meeting(val id: Int, val title: String) {}