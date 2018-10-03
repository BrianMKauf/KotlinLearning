package samples.kotlin_fundamentals.section6_filtering_and_sorting

fun main(args: Array<String>) {

    val meetings = listOf(Meeting2(1, "Board Meeting"), Meeting2(2, "Committee Meeting"))

    /**
     * Suppose we want to extract all of the people from meetings
     *
     * Note: it -> it.people could also be Meeting::people
     */
    // This gives you a list of list of persons
    val people = meetings.map { it -> it.people }

    //This gives you a list of persons
    val peopleFlat = meetings.flatMap { it -> it.people }

    println(peopleFlat.size)
    for( p in peopleFlat) println(p.name)


    //Without hashcode method(making it a data class), this still returns all 4 values
    val peopleFlatDistinct = meetings.flatMap { it -> it.people }.distinct()
    println(peopleFlatDistinct.size)
    for(p in peopleFlatDistinct) println(p.name)

}

class Meeting2(val id: Int, val title: String) {
    val people = listOf(Person("Sam"), Person("Alex"))
}

data class Person(val name: String)