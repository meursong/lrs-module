package com.meursong.xapi.elements.object;

import com.fasterxml.jackson.annotation.JsonInclude;


/**
 * Represents an agent in the xAPI specification.
 * Extends XapiObject for common properties.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Agent extends XapiObject {
    private String name;
    private String mbox;
}
