package com.meursong.xapi.util;

import com.meursong.xapi.common.Language;
import java.net.URI;
import java.util.Map;
import java.util.UUID;

/**
 * Utility class that provides common utility methods for xAPI.
 */
public class XapiCommonUtil {

    private XapiCommonUtil() {
        // prevent instantiation
    }

    public static String generateId() {
        return UUID.randomUUID().toString();
    }

    // Validates that the given id is a valid URI
    public static void validateUri(String id) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("Verb ID cannot be null or empty.");
        }

        try {
            URI uri = new URI(id);

            // Ensure the URI has a scheme (e.g., http, https)
            if (uri.getScheme() == null || uri.getScheme().isEmpty()) {
                throw new IllegalArgumentException("Invalid URI format: missing scheme in Verb ID: " + id);
            }

            // ensure the scheme is valid (e.g., http or https)
            if (!uri.getScheme().matches("https?")) {
                throw new IllegalArgumentException("Invalid URI scheme for Verb ID: " + id);
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("Invalid URI format for Verb ID: " + id, e);
        }
    }

    public static void validateDisplay(Map<Language, String> display) {
        if (display == null) {
            throw new IllegalArgumentException("Display map cannot be null.");
        }

        for (Map.Entry<Language, String> entry : display.entrySet()) {
            if (entry.getKey() == null || entry.getValue() == null || entry.getValue().isEmpty()) {
                throw new IllegalArgumentException(
                        "Invalid display entry: key and value must not be null or empty. Entry: " + entry);
            }
        }
    }
}
