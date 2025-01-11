package com.meursong.xapi.elements.object;

import com.fasterxml.jackson.annotation.JsonInclude;


/**
 * Represents a sub-statement in the xAPI specification.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SubStatement extends XapiObject {
    private XapiObject actor;
    private Verb verb;
    private XapiObject xapiObject;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Verb {
        private String id;
        private String display;
    }
}
