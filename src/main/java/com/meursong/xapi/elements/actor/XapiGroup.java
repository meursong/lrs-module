package com.meursong.xapi.elements.actor;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class XapiGroup implements XapiActor {
    private final String objectType = "Group";
    private String name;
    private List<XapiAgent> members;

    public XapiGroup() {}

    public XapiGroup(String name, List<XapiAgent> members) {
        this.name = name;
        this.members = members;
    }

    @Override
    public String getObjectType() {
        return objectType;
    }

    @Override
    public boolean isValid() {
        return members != null && !members.isEmpty();
    }

    // Getter & Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<XapiAgent> getMembers() {
        return members;
    }

    public void setMembers(List<XapiAgent> members) {
        this.members = members;
    }
}
