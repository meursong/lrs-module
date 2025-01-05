package com.meursong.xapi.elements.verb;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.meursong.xapi.common.Language;

import java.util.Map;

/**
 * 2024.12.24[susong]: LRS 설계
 * xAPI 규격의 Verb를 정의하는 클래스
 * XapiVerbConstants  를 참조하여 사용
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class XapiVerb {
    private String id; // required

    @JsonProperty("display")
    private Map<Language, String> display; // optional

    public boolean isValid() {
        return id != null && !id.isEmpty();
    }

    public String getId() {
        return id;
    }

    public Map<Language, String> getDisplay() {
        return display;
    }


    public XapiVerb() {}

    public XapiVerb(String id) {
        this.id = id;
    }

    public XapiVerb(String id, Map<Language, String> display) {
        this.id = id;
        this.display = display;
    }

}
