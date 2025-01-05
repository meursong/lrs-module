package com.meursong.xapi.consonant;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * 2024.12.24[susong]: LRS 설계
 * 언어 코드 값을 상수화하여 저장하는 클래스
 * xAPI에서 사용되는 규격은 국제 표준 BCP 47(현재는 RFC 5646과 RFC 4647)에 따른 형식임 (en-US, ko-KR, fr-FR...)
 */
public enum Language {
    EN_US("en-US"),
    KO_KR("ko-KR"),
    FR_FR("fr-FR");

    private final String code;

    Language(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return code;
    }

    @JsonValue // 직렬화 시 code 필드를 사용
    public String getCode() {
        return code;
    }
}
