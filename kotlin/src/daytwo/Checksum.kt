package daytwo

class Checksum(part: Int) {
    private val part: Int = part
    private val newlineRegex = "\\n".toRegex()
    private val spaceAndTabRegex = "\\s+|\\t+".toRegex()

    fun calculate(input: String): Int {
        val sequences = input.split(newlineRegex)
        return sequences.sumBy {
            val sequence = it.split(spaceAndTabRegex).map { it.toInt() }
            when (part) {
                1 -> getPartOneChecksum(sequence)
                2 -> getPartTwoChecksum(sequence)
                else -> throw RuntimeException("Part unknown")
            }
        }
    }

    private fun getPartOneChecksum(ints: List<Int>): Int {
        val sortedInts = ints.sortedDescending()
        return sortedInts.first() - sortedInts.last()
    }

    private fun getPartTwoChecksum(ints: List<Int>): Int {
        var result = 0
        ints.forEach { int ->
            ints.filter { int != it && int % it == 0 }.forEach { result = int / it }
        }
        return result
    }
}

fun main(args: Array<String>) {
    println(Checksum(1).calculate(args[0]))
    println(Checksum(2).calculate(args[0]))
}