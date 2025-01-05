package com.meursong.xapi.elements.object;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.meursong.xapi.common.Language;

import java.util.Map;

/**
 * 2024.12.24[susong]: Statements의 활동을 정의하는 클래스
 * Object의 하위 클래스
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Activity extends XapiObject {

    private ActivityDefinition definition;

    public ActivityDefinition getDefinition() {
        return definition;
    }

    public void setDefinition(ActivityDefinition definition) {
        this.definition = definition;
    }

    /**
     * 2024.12.24[susong]: LRS 설계
     * 활동의 메타데이터를 정의하는 클래스 (선택)
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class ActivityDefinition {
        private Map<Language, String> name; // (선택) 활동의 이름. 예) {"en-US": "multiple choice question"}
        private Map<Language, String> description; // (선택) 활동의 설명. 예) {"en-US": "A multiple choice question"}
        private Object extensions; // (선택) 활동의 확장. 예) {"http://example.com/profiles/meetings/attendance": "true"}
        private String type; // (선택) 활동의 설명. 예) "http://adlnet.gov/expapi/activities/cmi.interaction"
    }

}