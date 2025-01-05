package com.meursong.xapi.dto.element.xapiActor;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class XapiAgent implements XapiActor {
    private final String objectType = "Agent"; // "Agent" 고정
    private String mbox;                      // 이메일 주소
    private String name;                      // 이름
    private XapiAccount account;              // 계정 정보

    @JsonIgnore
    private boolean isValidate = true;

    public XapiAgent() {}

    public XapiAgent(String mbox, String name, XapiAccount account) {
        this.mbox = mbox;
        this.name = name;
        this.account = account;
        this.isValidate = validate();
    }

    @Override
    public String getObjectType() {
        return objectType;
    }

    @Override
    public boolean isValidate() {
        return validate();
    }

    private boolean validate() {
        return (mbox != null && !mbox.isEmpty()) ||
                (account != null && account.isValid());
    }

    // Getter & Setter
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

    public XapiAccount getAccount() {
        return account;
    }

    public void setAccount(XapiAccount account) {
        this.account = account;
    }
}
