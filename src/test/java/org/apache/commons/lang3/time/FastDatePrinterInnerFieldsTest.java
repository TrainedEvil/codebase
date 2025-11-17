package org.apache.commons.lang3.time;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Date;
import java.util.TimeZone;
import java.util.Locale;

public class FastDatePrinterInnerFieldsTest {

    @Test
    public void testTwentyFourHourField() {
        FastDatePrinter p = new FastDatePrinter("k", TimeZone.getTimeZone("UTC"), Locale.US);
        String out = p.format(new Date(0));
        assertNotNull(out);
        assertTrue(out.length() > 0);
    }

    @Test
    public void testTwelveHourField() {
        FastDatePrinter p = new FastDatePrinter("h", TimeZone.getTimeZone("UTC"), Locale.US);
        String out = p.format(new Date(0));
        assertNotNull(out);
        assertTrue(out.length() > 0);
    }
}
