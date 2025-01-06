package com.meursong.xapi.util;

import com.meursong.xapi.common.Language;
import com.meursong.xapi.elements.verb.XapiVerb;
import com.meursong.xapi.elements.verb.XapiVerbRegistry;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class XapiVerbResistryTest {

    @Test
    void test() {

        // Register a custom Verb
        String verbId = "https://example.com/xapi/verbs/reviewed";
        Map<Language, String> display = Map.of(
                Language.EN_US, "reviewed",
                Language.KO_KR, "검토하다"
        );

        XapiVerbRegistry.registerOrUpdateVerb(verbId, display);

        // Retrieve the registered Verb
        XapiVerb reviewedVerb = XapiVerbRegistry.getVerb(verbId);

        System.out.println("Registered Verb ID: " + reviewedVerb.getId());
        System.out.println("Display (English): " + reviewedVerb.getDisplay().get("en"));
        System.out.println("Display (Korean): " + reviewedVerb.getDisplay().get("ko"));

    }

}
