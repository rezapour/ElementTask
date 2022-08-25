package validation

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import validation.InputValidation

internal class InputValidationTest {

    @Test
    fun `validate return true when the conditions are met `() {
        assertEquals(true, InputValidation.validateHour("2"))
        assertEquals(true, InputValidation.validateMinute("12"))
        assertEquals(true, InputValidation.validateHour("*"))
        assertEquals(true, InputValidation.validateMinute("*"))
    }


    @Test
    fun `validate return true when the time is not correct `() {
        assertEquals(false, InputValidation.validateHour("80"))
        assertEquals(false, InputValidation.validateMinute("90"))

    }

    @Test
    fun `validate return true when the input is not digit  `() {
        assertEquals(false, InputValidation.validateMinute("asdad"))
    }

    @Test
    fun `validate return true when the input is more than one star `() {
        assertEquals(false, InputValidation.validateMinute("*****"))
    }


}