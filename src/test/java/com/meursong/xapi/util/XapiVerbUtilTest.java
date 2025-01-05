package com.meursong.xapi.util;

import com.meursong.xapi.dto.element.xapiVerb.XapiVerb;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class XapiVerbUtilTest {
    @Test
    void createVerbWithInvalidUri_shouldThrowException() {
        String invalidUri = "not-a-valid-uri";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            XapiVerbUtil.createVerb(invalidUri);
        });
        assertEquals("Invalid URI format for Verb ID: not-a-valid-uri", exception.getMessage());
    }

    @Test
    void createVerbWithValidUri_shouldCreateVerb() {
        String validUri = "http://example.com/verbs/custom";
        XapiVerb verb = XapiVerbUtil.createVerb(validUri);
        assertNotNull(verb);
        assertEquals(validUri, verb.getId());
    }
}