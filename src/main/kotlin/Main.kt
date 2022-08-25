import service.CronCalculator
import service.CronParser
import validation.TimeValidator
import java.lang.Exception

fun main(args: Array<String>) {
    val (h, m) = if (args.isNotEmpty()) {
        TimeValidator.validate(args[0])
    } else
        throw Exception("Please enter the local time!")

    val input = generateSequence(::readLine)
    val lines = input.toList()

    val calculator = CronCalculator(h, m)

    for (line: String in lines) {
        try {
            val corn = CronParser.parser(line)
            println("${calculator.calculate(corn)} ~${corn.path}")
        } catch (e: Exception) {
            println(e.message)
        }
    }
}








