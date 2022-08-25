package validation

object InputValidation {

    private fun validate(input: String): Boolean {
        val regex = Regex(pattern = "[0-9*]+")
        if (!input.matches(regex))
            return false

        if (input.contains("*") && (input.length != 1))
            return false


        if (input.length > 2)
            return false

        return true
    }

    fun validateHour(hour: String): Boolean {
        return validate(hour) && (hour == "*" || hour.toInt() < 24)
    }

    fun validateMinute(minutes: String): Boolean {
        return validate(minutes) && (minutes == "*" || minutes.toInt() < 60)
    }


}