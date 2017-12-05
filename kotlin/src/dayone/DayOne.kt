package dayone

class CaptchaSolver(step: Int) {
    var step: Int = step

    fun solve(input: String): Int {
        var sum = 0
        val array = input.toCharArray()
        (0 until array.size)
                .filter { array[it] == array[(it + step) % array.size] }
                .forEach { sum += array[it].toString().toInt() }
        return sum
    }
}

fun main(args: Array<String>) {
    println(CaptchaSolver(1).solve(args[0]))
    println(CaptchaSolver(args[0].length/2).solve(args[0]))
}