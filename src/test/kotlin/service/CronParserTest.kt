package service

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import validation.TimeValidator
import java.io.IOException
import java.lang.Exception

internal class CronParserTest {

    @Test
    fun `test parser successful when cron is correct`() {

        val result = CronParser.parser("* 19 /bin/run_me_sixty_times")

        assertEquals("19", result.hour)
        assertEquals("*", result.minute)
        assertEquals("/bin/run_me_sixty_times", result.path)

    }

    @Test
    fun `test parser throws exception when length  is incorect`() {
        org.junit.jupiter.api.assertThrows<IOException> { CronParser.parser("**** 19 /bin/run_me_sixty_times") }
    }

    @Test
    fun `test parser throws exception when cron is not complited`() {
        org.junit.jupiter.api.assertThrows<IOException> { CronParser.parser("* 19") }
    }
}