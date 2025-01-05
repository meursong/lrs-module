package com.meursong.xapi.util;

import com.meursong.xapi.common.Language;
import com.meursong.xapi.sample.XapiVerbEnum;
import com.meursong.xapi.elements.verb.XapiVerb;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class XapiVerbUtilTest {
    @Test
    void createVerbWithInvalidUri_test() {
        String invalidUri = "not-a-valid-uri";
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            XapiVerbUtil.createVerb(invalidUri);
        });
        assertEquals("Invalid URI format for Verb ID: not-a-valid-uri", exception.getMessage());
    }

    @Test
    void createVerbWithValidUri_test() {
        String validUri = "http://example.com/verbs/custom";
        XapiVerb verb = XapiVerbUtil.createVerb(validUri);
        assertNotNull(verb);
        assertEquals(validUri, verb.getId());
    }

    @Test
    void createVerbWithEnum_test() {
        XapiVerb verb = XapiVerbUtil.createVerbWithVerbEnum(XapiVerbEnum.COMPLETED);
        assertNotNull(verb);
        assertEquals("http://adlnet.gov/expapi/verbs/completed", verb.getId());
        assertNull(verb.getDisplay()); // Display is not provided, so it should be null
    }

    @Test
    void createVerbWithIdAndDisplay_test() {
        String validUri = "http://example.com/verbs/custom";
        Map<Language, String> display = Map.of(
                Language.EN_US, "Custom Verb",
                Language.FR_FR, "Verbe Personnalisé",
                Language.KO_KR, "커스텀 Verb"
        );

        XapiVerb verb = XapiVerbUtil.createVerb(validUri, display);

        assertNotNull(verb);
        assertEquals(validUri, verb.getId());
        assertNotNull(verb.getDisplay());
        assertEquals("Custom Verb", verb.getDisplay().get(Language.EN_US));
        assertEquals("Verbe Personnalisé", verb.getDisplay().get(Language.FR_FR));
        assertEquals("커스텀 Verb", verb.getDisplay().get(Language.KO_KR));
    }
    @Test
    void createVerbWithEmptyDisplay_test() {
        String validUri = "http://example.com/verbs/custom";
        Map<Language, String> display = Map.of(); // Empty display map

        XapiVerb verb = XapiVerbUtil.createVerb(validUri, display);

        assertNotNull(verb);
        assertEquals(validUri, verb.getId());
        assertNotNull(verb.getDisplay());
        assertTrue(verb.getDisplay().isEmpty()); // Display should be an empty map
    }

    @Test
    void createVerbWithInvalidDisplay_test() {
        String validUri = "http://example.com/verbs/custom";
        Map<Language, String> display = null; // Null display map

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            XapiVerbUtil.createVerb(validUri, display);
        });
        assertEquals("Display map cannot be null.", exception.getMessage());
    }
}