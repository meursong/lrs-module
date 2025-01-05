package com.meursong.xapi.dto.element.xapiActor;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 2024.12.24[susong]: Actor의 하위 클래스
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Account {
    private String name;    // accountId
    private String homePage;    // homepage domain

    public String getName() {
        return name;
    }

    public String getHomePage() {
        return homePage;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setHomePage(String homePage) {
        this.homePage = homePage;
    }
}