package service

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import service.model.CronModel

internal class CronCalculatorTest {

    @Test
    fun `cronCalculator cron calculator return tomorrow when next run happens next day`() {
        val corn = CronCalculator(10, 50)
        assertEquals("01:30 tomorrow", corn.calculate(CronModel("1", "30", "")))
        assertEquals("08:00 tomorrow", corn.calculate(CronModel("8", "*", "")))


    }

    @Test
    fun `cronCalculator cron calculator return tomorrow when next run happens today`() {
        val corn = CronCalculator(10, 50)
        assertEquals("16:30 today", corn.calculate(CronModel("16", "30", "")))
        assertEquals("10:51 today", corn.calculate(CronModel("*", "*", "")))
        assertEquals("11:30 today", corn.calculate(CronModel("*", "30", "")))
    }
}