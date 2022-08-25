package service

import service.model.CronModel
import validation.InputValidation

import java.io.IOException

object CronParser {

    fun parser(line: String): CronModel {
        val input = line.split(" ")
        if (input.size < 3) {
            throw IOException("this data is not valid")
        }
        val min = input[0]
        val hour = input[1]
        if (InputValidation.validateMinute(min) && InputValidation.validateHour(hour)) {
            val path = input[2]
            return CronModel(
                hour = hour,
                minute = min,
                path = path
            )
        } else {
            throw IOException("this data is not valid")
        }

    }

}