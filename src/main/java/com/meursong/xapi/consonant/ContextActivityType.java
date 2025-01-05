package com.meursong.xapi.consonant;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 2024.12.24[susong]: LRS 설계
 * xAPI 규격의 contextActivities 키값을 제한하는 enum클래스
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