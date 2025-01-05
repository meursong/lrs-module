package com.meursong.xapi.elements.actor;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 2024.12.24[susong]: xAPI의 Actor를 표현하는 클래스
 * Agent와 Group을 모두 표현할 수 있음
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public interface XapiActor {
    
    String getObjectType(); // "Agent" 또는 "Group"

    boolean isValid();   // 유효성 검사 메서드
}
