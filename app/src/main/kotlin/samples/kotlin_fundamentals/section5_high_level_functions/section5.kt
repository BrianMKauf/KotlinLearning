package samples.kotlin_fundamentals.section5_high_level_functions

fun main(args: Array<String>) {
    var program = Program()

    /**
     * First way, just calling the method
     */

    program.fibonacci(8)

    /**
     * Second way, using action and the Process interface
     */

    program.fibonacci(8, object : Process {
        override fun execute(value: Int) {
            println(value)
        }
    })

    /**
     *  Third way, using function
     *  The lambda (a -> println(a)), -> is read "goes to"
     *  The lambda can also be println(a) or (8, ::println)
     */

    program.fibonacci(8) { a -> println(a) }

    /**
     * lambdas can be mutated
     */
    var total = 0
    program.fibonacci(8) { it -> total += it }
    println(total)
}

interface Process {
    fun execute(value: Int)
}

class Program {

    fun fibonacci(limit: Int) {
        var prev = 0
        var prevprev: Int
        var current = 1

        for (i: Int in 1..limit) {
            println(current)

            var temp = current
            prevprev = prev
            prev = temp
            current = prev + prevprev
        }
    }

    fun fibonacci(limit: Int, action: Process) {
        var prev = 0
        var prevprev: Int
        var current = 1

        for (i: Int in 1..limit) {
            action.execute(current)

            var temp = current
            prevprev = prev
            prev = temp
            current = prev + prevprev
        }
    }

    fun fibonacci(limit: Int, action: (Int) -> Unit) {
        var prev = 0
        var prevprev: Int
        var current = 1

        for (i: Int in 1..limit) {
            action(current)

            var temp = current
            prevprev = prev
            prev = temp
            current = prev + prevprev
        }
    }


}
