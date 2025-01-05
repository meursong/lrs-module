package com.meursong.xapi.dto.element.xapiObject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * 2024.12.24[susong]: xAPI 규격의 Object를 정의하는 추상클래스
 * 새로운 Object 유형이 필요할 경우, 이 추상 클래스를 상속받아 새로운 하위 클래스를 정의하고 {@code @JsonSubTypes}에 해당 클래스와 매핑 이름을 추가할 것
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
        isValidate = validate;
    }

    public boolean isValidate() {
        return isValidate;
    }

    @JsonIgnore
    private boolean isValidate = true;
}
