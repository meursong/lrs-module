package com.meursong.xapi.elements.object;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.meursong.xapi.common.Language;

import java.util.Map;


/**
 * Represents an activity in the xAPI specification.
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

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class ActivityDefinition {
        private Map<Language, String> name; // (Optional) e.g., {"en-US": "multiple choice question"}
        private Map<Language, String> description; // (Optional) e.g., {"en-US": "A multiple choice question"}
        private Object extensions; // (Optional) e.g., {"http://example.com/profiles/meetings/attendance": "true"}
        private String type; // (Optional) e.g., "http://adlnet.gov/expapi/activities/cmi.interaction"
    }

}