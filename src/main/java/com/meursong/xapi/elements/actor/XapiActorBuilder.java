package com.meursong.xapi.elements.actor;

import java.util.List;

public class XapiActorBuilder {
    private String name;
    private String mbox;
    private XapiAccount account;
    private List<XapiAgent> members;

    public static XapiActorBuilder builder() {
        return new XapiActorBuilder();
    }

    public XapiActorBuilder name(String name) {
        this.name = name;
        return this;
    }

    public XapiActorBuilder mbox(String mbox) {
        this.mbox = mbox;
        return this;
    }

    public XapiActorBuilder account(XapiAccount account) {
        this.account = account;
        return this;
    }

    public XapiActorBuilder members(List<XapiAgent> members) {
        this.members = members;
        return this;
    }

    public XapiActor buildAgent() {
        if (mbox == null && (account == null || !account.isValid())) {
            throw new IllegalArgumentException("Invalid Agent: must have either mbox or valid account.");
        }

        XapiAgent agent = new XapiAgent();
        agent.setName(name);
        agent.setMbox(mbox);
        agent.setAccount(account);
        return agent;
    }

    public XapiActor buildGroup() {
        if (members == null || members.isEmpty()) {
            throw new IllegalArgumentException("Invalid Group: must have at least one member.");
        }

        return new XapiGroup(name, members);
    }
}
