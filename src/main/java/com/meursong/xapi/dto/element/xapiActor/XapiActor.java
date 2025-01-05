package com.meursong.xapi.dto.element.xapiActor;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 2024.12.24[susong]: xAPI의 Actor를 표현하는 클래스
 * Agent와 Group을 모두 표현할 수 있음 (Default: Agent로 사용할 것)
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class XapiActor {
    private String objectType; // Agent 혹은 Group
    private String mbox;
    private String name;
    private Account account;
    @JsonIgnore
    private boolean isValidate = true;

    // 기본 생성자
    public XapiActor() {}

    // 모든 필드 생성자
    public XapiActor(String objectType, String mbox, String name, Account account, boolean isValidate) {
        this.objectType = objectType;
        this.mbox = mbox;
        this.name = name;
        this.account = account;
        this.isValidate = isValidate;
    }

    // Getter and Setter
    public String getObjectType() {
        return objectType;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public String getMbox() {
        return mbox;
    }

    public void setMbox(String mbox) {
        this.mbox = mbox;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public boolean isValidate() {
        return isValidate;
    }

    public void setValidate(boolean validate) {
        isValidate = validate;
    }
}
