package com.meursong.xapi.elements.object;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 2024.12.24[susong]: xAPI의 SubStatement를 표현하는 클래스
 * Object의 하위 클래스로서 statement자체가 Object로 사용될 수 있음
 * StatementRef등으로 이미 존재하는 Statement를 참조할 수 있음
 * 당장은 복잡성 문제로 Activity만 사용하기로 함
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SubStatement extends XapiObject {
    private XapiObject actor;
    private Verb verb;
    private XapiObject xapiObject;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    public static class Verb {
        private String id;
        private String display;
    }
}
