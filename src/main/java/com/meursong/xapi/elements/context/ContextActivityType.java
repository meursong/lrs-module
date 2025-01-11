package com.meursong.xapi.elements.context;

import com.fasterxml.jackson.annotation.JsonProperty;


/**
 * An enumeration representing different types of context activities.
 */
public enum ContextActivityType {
    @JsonProperty("parent")
    PARENT,
    @JsonProperty("grouping")
    GROUPING,
    @JsonProperty("category")
    CATEGORY,
    @JsonProperty("other")
    OTHER
}