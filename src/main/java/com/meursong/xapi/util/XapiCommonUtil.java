package com.meursong.xapi.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meursong.xapi.elements.context.ContextActivityType;
import com.meursong.xapi.common.Language;
import com.meursong.xapi.elements.actor.XapiAccount;
import com.meursong.xapi.elements.actor.XapiActor;
import com.meursong.xapi.elements.actor.XapiAgent;
import com.meursong.xapi.elements.context.XapiContext;
import com.meursong.xapi.elements.object.Activity;

import java.net.URI;
import java.util.Map;
import java.util.UUID;

/**
 * 2024.12.24[susong]: xAPI와 관련된 유틸리티 클래스
 * xAPI 스펙에 맞는 Actor, XapiVerb, Object, Context, Statement를 생성하는 메서드를 제공
 */
public class XapiCommonUtil {

    private XapiCommonUtil() {
        // 인스턴스화 방지
    }

    // Object Id 빌더
    public static String buildObjectId(String objectBaseUrl, String targetObject, String variable) {

        // 유효성 검증
        boolean isValid = true;

        if (objectBaseUrl == null || objectBaseUrl.isEmpty()) {
            isValid = false;
        }

        if (targetObject == null || targetObject.isEmpty()) {
            isValid = false;
        }

        if (!isValid) {
            throw new IllegalArgumentException("Invalid arguments for building xapiObject ID");
        }

        StringBuilder url = new StringBuilder(objectBaseUrl)
                .append(targetObject);

        if (variable != null && !variable.isEmpty()) {
            url.append("/").append(variable);
        }

        return url.toString();
    }

    // Object Id 빌더
    public static String buildObjectId(String objectBaseUrl, String targetObject) {
        StringBuilder url = new StringBuilder(objectBaseUrl)
                .append(targetObject);


        return url.toString();
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
