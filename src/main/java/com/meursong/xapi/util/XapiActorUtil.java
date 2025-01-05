package com.meursong.xapi.util;

import com.meursong.xapi.dto.element.xapiActor.XapiAccount;
import com.meursong.xapi.dto.element.xapiActor.XapiAgent;
import com.meursong.xapi.dto.element.xapiActor.XapiGroup;

import java.util.List;

public class XapiActorUtil {

    public static XapiAgent createAgentWithAccount(String actorName, String homePage) {
        XapiAccount account = new XapiAccount(actorName, homePage);
        if (!account.isValid()) {
            throw new IllegalArgumentException("Invalid Account: actorName or homePage is invalid.");
        }

        XapiAgent agent = new XapiAgent();
        agent.setAccount(account);
        return agent;
    }

    public static XapiGroup createGroup(String groupName, List<XapiAgent> members) {
        if (members == null || members.isEmpty()) {
            throw new IllegalArgumentException("Invalid Group: members cannot be null or empty.");
        }

        return new XapiGroup(groupName, members);
    }
}
