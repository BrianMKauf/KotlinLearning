package samples.kotlin_fundamentals.section5_high_level_functions

import java.time.LocalDate


class Meeting {
    var Title: String = ""
    var When: LocalDate = LocalDate.MIN
    var Who = mutableListOf<String>()

    fun create() {
        println("Created!!")
    }
}

fun main(args: Array<String>) {
    val m = Meeting()
    m.Title = "Board Meeting"
    m.When = LocalDate.of(2017, 1, 1)
    m.Who.add("Kevin")

    /**
     *
     * with() is a function on the standard library. It takes the thing
     * to operate on and then a lambda, the thing that operates on it
     *
     * This is a lamdba(the stuff within braces)
     *
     *
     */
    with(m) {
        Title = "Board Meeting"
        When = LocalDate.of(2017, 1, 1)
        Who.add("Kevin")
    }

    /**
     * Apply
     */

    m.apply  {
        Title = "Board Meeting"
        When = LocalDate.of(2017, 1, 1)
        Who.add("Kevin")
    }.create()

}