package com.meursong.xapi.elements.context;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.meursong.xapi.elements.actor.XapiActor;

import java.util.Map;

/**
 * 2024.12.24[susong]: LRS 설계
 * Statements의 컨텍스트를 정의하는 클래스 (전부 Optional)
 * contextActivities로 활동의 부모등을 명시할 수 있음
 * Context가 필요 할 경우 어노테이션의 contextRequired값을 true로 설정하고 Context를 정의할 것
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class XapiContext {
    private Map<ContextActivityType, Object> contextActivities; // parent, grouping, category, other
    private String registration;
    private XapiActor instructor;
    private String revision;
    private String platform;
    private String language;
    private Object extensions;

    @JsonIgnore
    private boolean isValid = true;

    public Map<ContextActivityType, Object> getContextActivities() {
        return contextActivities;
    }

    public String getRegistration() {
        return registration;
    }

    public XapiActor getInstructor() {
        return instructor;
    }

    public String getRevision() {
        return revision;
    }

    public String getPlatform() {
        return platform;
    }

    public String getLanguage() {
        return language;
    }

    public Object getExtensions() {
        return extensions;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setContextActivities(Map<ContextActivityType, Object> contextActivities) {
        this.contextActivities = contextActivities;
    }

    public void setRegistration(String registration) {
        this.registration = registration;
    }

    public void setInstructor(XapiActor instructor) {
        this.instructor = instructor;
    }

    public void setRevision(String revision) {
        this.revision = revision;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setExtensions(Object extensions) {
        this.extensions = extensions;
    }

    public void setValidate(boolean validate) {
        isValid = validate;
    }
}


// https://github.com/adlnet/xAPI-Spec/blob/master/xAPI-Data.md#246-context 참고
//
//                  ** Requirements **
// The "revision" property MUST only be used if the Statement's Object is an Activity.
// The "platform" property MUST only be used if the Statement's Object is an Activity.
// The "language" property MUST NOT be used if not applicable or unknown.
// The "revision" property SHOULD be used to track fixes of minor issues (like a spelling error).
// The "revision" property SHOULD NOT be used if there is a major change in learning objectives, pedagogy, or assets of an Activity. (Use a new Activity id instead).