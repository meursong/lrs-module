package com.meursong.xapi.dto.element.xapiObject;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * 2024.12.24[susong]: 사용자 그룹을 표현
 * Object의 하위 클래스
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Group extends XapiObject {
    private String name;
    private List<Agent> members;
}