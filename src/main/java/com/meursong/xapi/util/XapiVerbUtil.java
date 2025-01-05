package com.meursong.xapi.util;

import com.meursong.xapi.common.Language;
import com.meursong.xapi.elements.verb.XapiVerbEnum;
import com.meursong.xapi.elements.verb.XapiVerb;

import java.util.Map;

public class XapiVerbUtil {

    private XapiVerbUtil() {}

    // Creates new XapiVerb object with XapiVerbEnum
    public static XapiVerb createVerbWithVerbEnum(XapiVerbEnum verbType) {
        return new XapiVerb(verbType.getId());
    }

    // Creates new XapiVerb object with the given id(uri).
    public static XapiVerb createVerb(String id) {
        XapiCommonUtil.validateUri(id);
        return new XapiVerb(id);
    }

    // Creates new XapiVerb object with the given id(uri) and display.
    public static XapiVerb createVerb(String id, Map<Language, String> display) {
        XapiCommonUtil.validateUri(id);
        XapiCommonUtil.validateDisplay(display);

        return new XapiVerb(id, display);
    }
}