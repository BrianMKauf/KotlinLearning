package samples.kotlin_fundamentals.section6_filtering_and_sorting

fun main(args: Array<String>) {
    val meetings = listOf(MeetingSection7(1, "Board Meeting"), MeetingSection7(2, "Committee Meeting"))

    val titles = meetings.asSequence().filter { it -> it.title.startsWith("C") }.map { it.title }

    for (t in titles) println(t)

    val titlesSequence = meetings
            .asSequence()
            .filter { println("filter{$it}");it.title.endsWith("g") }
            .map { println("map{$it}"); it.title }

    //filter and mapped not called until sequence is used(i.e. toList, println, etc..)

    //for (t in titlesSequence)println(t)


    /**
     * With sequence, we don't map both before finding it
     */
    val titlesUpperCase = meetings.asSequence().map { println("map{$it}"); it.title.toUpperCase() }
            .find { it.startsWith("BOARD") }

    println(titlesUpperCase)
}

class MeetingSection7(val id: Int, val title: String) {
    val people = listOf(Person("Sam"), Person("Alex"))
}

data class PersonSection7(val name: String)