import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class HairSalonTest {

    HairSalon hairSalon = new HairSalon();

    @Test
    public void testGetOpeningDays() {
        String[] expected = { "Monday", "Tuesday" };
        String[] actual = hairSalon.getOpeningDays();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testSalonIsOpenOnMonday() {
        boolean actual = hairSalon.isOpen("Monday");
        assertTrue(actual);
    }

    @Test
    public void testSalonIsClosedOnWednesday() {
        boolean actual = hairSalon.isOpen("Wednesday");
        assertFalse(actual);

    }

    @Test
    public void testExceptionIsThrownIfWeekdayDoesNotEndInDay() {
        String input = "Mon"; // Example input that does not end with "day"
        Exception exception = assertThrows(IllegalArgumentException.class, () -> hairSalon.isOpen(input));

        String expected = "Only weekdays are allowed.";
        assertEquals(expected, exception.getMessage());
    }

}