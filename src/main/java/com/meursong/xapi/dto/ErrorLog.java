package com.meursong.xapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * 2024.12.24[susong]: LRS저장 실패시 저장되는 ErrorLog DTO
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorLog {

    // 로그 ID
    private Long logId;

    // HTTP 요청 메서드
    private String requestMethod;

    // 요청 URL
    private String url;

    // 요청 데이터 (JSON 형식)
    private String payload;

    // 응답 코드
    private Integer responseCode;

    // 응답 메시지
    private String responseMessage;

    // 로그 생성 시간
    private LocalDateTime createdAt;

}
