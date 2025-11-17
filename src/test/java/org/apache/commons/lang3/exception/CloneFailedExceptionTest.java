package org.apache.commons.lang3.exception;

import org.junit.Test;
import static org.junit.Assert.*;

public class CloneFailedExceptionTest {

    @Test
    public void testMessageConstructor() {
        CloneFailedException e = new CloneFailedException("msg");
        assertEquals("msg", e.getMessage());
    }

    @Test
    public void testCauseConstructor() {
        Throwable cause = new RuntimeException("cause");
        CloneFailedException e = new CloneFailedException(cause);
        assertEquals(cause, e.getCause());
    }

    @Test
    public void testMessageAndCause() {
        Throwable cause = new RuntimeException("cause");
        CloneFailedException e = new CloneFailedException("m", cause);
        assertEquals("m", e.getMessage());
        assertEquals(cause, e.getCause());
    }
}
