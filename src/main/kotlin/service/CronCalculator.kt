package service

import service.model.CronModel

class CronCalculator(private val localHour: Int, private val localMinute: Int) {

    public fun calculate(cron: CronModel): String {
        val (h, m) = calculateTimes(cron.hour, cron.minute)
        val day = calculateDay(h, m)
        return "${h.toString().padStart(2, '0')}:${m.toString().padStart(2, '0')} $day"
    }

    private fun calculateDay(hour: Int, minute: Int): String {

        return if (localHour != hour) {
            if (localHour > hour) "tomorrow" else "today"
        } else {
            if (localMinute > minute) "tomorrow" else "today"
        }
    }

    private fun calculateTimes(hour: String, minute: String): Pair<Int, Int> {

        if (hour != "*" && minute != "*")
            return Pair(hour.toInt(), minute.toInt())

        if (hour == "*" && minute == "*")
            return hourPlusOne(localHour, localMinute)

        if (minute == "*") {
            val m = if (localHour == hour.toInt()) {
                minPlusOne(localMinute)
            } else
                0
            return Pair(hour.toInt(), m)
        }

        if (hour == "*") {
            val h =
                if (localMinute >= minute.toInt())
                    hourPlusOne(localHour)
                else
                    localHour
            return Pair(h, minute.toInt())
        }
        return Pair(0, 0)
    }

    private fun minPlusOne(minute: Int): Int {
        return if (minute + 1 >= 60)
            0
        else
            (minute + 1)
    }

    private fun hourPlusOne(hour: Int): Int {
        return if (hour + 1 >= 24)
            0
        else
            (hour + 1)
    }

    private fun hourPlusOne(hour: Int, minute: Int): Pair<Int, Int> {
        return if (minute + 1 >= 60)
            Pair(hourPlusOne(hour), 0)
        else
            Pair(hour, minute + 1)
    }
}