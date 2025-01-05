package com.meursong.xapi.elements.actor;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class XapiAccount {
    private String name;      // 계정 이름
    private String homePage;  // 계정 홈 페이지 URL

    public XapiAccount() {}

    public XapiAccount(String name, String homePage) {
        this.name = name;
        this.homePage = homePage;
    }

    // 유효성 검사
    public boolean isValid() {
        return name != null && !name.isEmpty() && homePage != null && !homePage.isEmpty();
    }

    // Getter & Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHomePage() {
        return homePage;
    }

    public void setHomePage(String homePage) {
        this.homePage = homePage;
    }
}
