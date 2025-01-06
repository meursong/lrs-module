package com.meursong.xapi.elements.verb;
import com.meursong.xapi.common.Language;
import com.meursong.xapi.sample.XapiVerbEnum;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class XapiVerbRegistry {

    // Unified storage for all verbs (default and custom)
    private static final Map<String, XapiVerb> verbRegistry = new ConcurrentHashMap<>();

    static {
        // Initialize with default verbs from XapiVerbEnum
        for (XapiVerbEnum verbEnum : XapiVerbEnum.values()) {
            verbRegistry.put(verbEnum.getId(), verbEnum.getXapiVerb());
        }
    }

    // Registers or updates a verb
    public static void registerOrUpdateVerb(String id, Map<Language, String> display) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("Verb ID cannot be null or empty.");
        }

        if (display == null || display.isEmpty()) {
            throw new IllegalArgumentException("Display map cannot be null or empty.");
        }

        // Add or update the verb in the registry
        verbRegistry.put(id, new XapiVerb(id, display));
    }

    // Retrieves a verb by its ID
    public static XapiVerb getVerb(String id) {
        XapiVerb verb = verbRegistry.get(id);
        if (verb == null) {
            throw new IllegalArgumentException("Verb ID not found: " + id);
        }
        return verb;
    }

    // Deletes a verb by its ID
    public static void deleteVerb(String id) {
        if (!verbRegistry.containsKey(id)) {
            throw new IllegalArgumentException("Verb ID not found: " + id);
        }
        verbRegistry.remove(id);
    }

    // Retrieves all verbs
    public static Map<String, XapiVerb> getAllVerbs() {
        return Map.copyOf(verbRegistry);
    }
}
