package com.meursong.xapi.elements.object;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;


/**
 * XapiObject is an abstract class that represents a generic object in the xAPI specification.
 * It provides common properties and methods that are shared among different types of xAPI objects.
 * This class is intended to be extended by more specific xAPI object classes such as Activity, Agent, Group, and SubStatement.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "objectType",
        visible = true
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Activity.class, name = "Activity"),
        @JsonSubTypes.Type(value = Agent.class, name = "Agent"),
        @JsonSubTypes.Type(value = SubStatement.class, name = "SubStatement"),
        @JsonSubTypes.Type(value = Group.class, name = "Group")
})
public abstract class XapiObject {
    private String objectType; // xAPI 스펙에서 정의된 "objectType" 속성
    private String id;

    public String getObjectType() {
        return objectType;
    }

    public String getId() {
        return id;
    }

    public void setObjectType(String objectType) {
        this.objectType = objectType;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setValidate(boolean validate) {
        isValid = validate;
    }

    public boolean isValid() {
        return isValid;
    }

    @JsonIgnore
    private boolean isValid = true;
}
