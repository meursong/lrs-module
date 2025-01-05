package com.meursong.xapi.util;

import com.meursong.xapi.dto.element.xapiActor.XapiAccount;
import com.meursong.xapi.dto.element.xapiActor.XapiAgent;
import com.meursong.xapi.dto.element.xapiActor.XapiGroup;

import java.util.List;

public class XapiActorUtil {

    private XapiActorUtil() {
        // 인스턴스화 방지
    }

    // email만으로 Agent 생성
    public static XapiAgent createAgentWithMbox(String mbox) {
        if (mbox == null || mbox.isEmpty()) {
            throw new IllegalArgumentException("Invalid mbox: must not be null or empty.");
        }

        XapiAgent agent = new XapiAgent();
        agent.setMbox(mbox);
        return agent;
    }


    // name과 email로 Agent 생성
    public static XapiAgent createAgentWithNameAndMbox(String name, String mbox) {
        if (mbox == null || mbox.isEmpty()) {
            throw new IllegalArgumentException("Invalid mbox: must not be null or empty.");
        }

        XapiAgent agent = new XapiAgent();
        agent.setName(name);
        agent.setMbox(mbox);
        return agent;
    }

    // Account로 Agent 생성
    public static XapiAgent createAgentWithAccount(String actorName, String homePage) {
        XapiAccount account = new XapiAccount(actorName, homePage);
        if (!account.isValid()) {
            throw new IllegalArgumentException("Invalid Account: actorName or homePage is invalid.");
        }

        XapiAgent agent = new XapiAgent();
        agent.setAccount(account);
        return agent;
    }

    // name과 Account으로 Agent 생성
    public static XapiAgent createAgentWithNameAndAccount(String name, String accountName, String homePage) {
        XapiAccount account = new XapiAccount(accountName, homePage);
        if (!account.isValid()) {
            throw new IllegalArgumentException("Invalid Account: must have valid name and homePage.");
        }

        XapiAgent agent = new XapiAgent();
        agent.setName(name);
        agent.setAccount(account);
        return agent;
    }

    // name만으로 Group 생성
    public static XapiGroup createGroupWithName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Invalid group name: must not be null or empty.");
        }

        return new XapiGroup(name, null);
    }


    // Member 리스트로 Group 생성
    public static XapiGroup createGroupWithMembers(List<XapiAgent> members) {
        if (members == null || members.isEmpty()) {
            throw new IllegalArgumentException("Invalid members: must not be null or empty.");
        }

        return new XapiGroup(null, members);
    }

    // name과 Member 리스트로 Group 생성
    public static XapiGroup createGroupWithNameAndMembers(String name, List<XapiAgent> members) {
        if (members == null || members.isEmpty()) {
            throw new IllegalArgumentException("Invalid members: must not be null or empty.");
        }

        return new XapiGroup(name, members);
    }
}
