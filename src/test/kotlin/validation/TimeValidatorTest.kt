package validation

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.assertThrows
import validation.TimeValidator

internal class TimeValidatorTest {

    @Test
    fun setTime() {
        assertEquals(Pair(10, 20), TimeValidator.validate("10:20"))
        assertThrows<java.lang.Exception> { TimeValidator.validate("103:202") }
        assertThrows<java.lang.Exception> { TimeValidator.validate("asdadasdsa") }
    }
}