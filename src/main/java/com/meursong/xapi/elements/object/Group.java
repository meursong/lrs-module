package com.meursong.xapi.elements.object;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;


/**
 * Represents a group in the xAPI specification.
 * Extends XapiObject for common properties.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Group extends XapiObject {
    private String name;
    private List<Agent> members;
}