package validation

import java.lang.Exception

object TimeValidator {
    @Throws(Exception::class)
     fun validate(time: String): Pair<Int, Int> {
        println(time)
        //12:55
        val localTime = time.split(":")
        val localHour = localTime[0].toInt()
        val localMinute = localTime[1].toInt()


        if (validateTimes(localHour, localMinute))
            return Pair(localHour, localMinute)
        else
            throw Exception("Time Format it is not correct")
    }


    private fun validateTimes(hour: Int, minute: Int) = (hour < 24 && minute < 60)


}