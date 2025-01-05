package com.meursong.xapi.dto.element.xapiVerb;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.meursong.xapi.consonant.Language;

import java.util.Map;

/**
 * 2024.12.24[susong]: LRS 설계
 * xAPI 규격의 Verb를 정의하는 클래스
 * XapiVerbConstants  를 참조하여 사용
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class XapiVerb {
    private final String id;
    private final Map<Language, String> display;

    @JsonIgnore
    private boolean isValid = true;

    public String getId() {
        return id;
    }

    public Map<Language, String> getDisplay() {
        return display;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValidate(boolean validate) {
        isValid = validate;
    }

    public XapiVerb(String id, Map<Language, String> display) {
        this.id = id;
        this.display = display;
    }

    @Override
    public String toString() {
        return "XapiVerb{" +
                "id='" + id + '\'' +
                ", display=" + display +
                '}';
    }
}
