package com.meursong.xapi.dto.element.xapiActor;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 2024.12.24[susong]: xAPI의 Actor를 표현하는 클래스
 * Agent와 Group을 모두 표현할 수 있음 (Default: Agent로 사용할 것)
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public interface XapiActor {
    String getObjectType(); // "Agent" 또는 "Group"

    boolean isValidate();   // 유효성 검사 메서드
}
