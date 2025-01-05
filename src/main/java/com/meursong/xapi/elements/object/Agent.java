package com.meursong.xapi.elements.object;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 2024.12.24[susong]: 사용자나 시스템과 같은 개별 액터를 표현
 * Object의 하위 클래스
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Agent extends XapiObject {
    private String name;
    private String mbox; // mailto: 이메일 형식
}
