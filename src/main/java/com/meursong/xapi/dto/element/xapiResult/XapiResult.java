package com.meursong.xapi.dto.element.xapiResult;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Map;

/**
 * 2024.12.24[susong]: LRS 설계
 * xAPI 규격의 Result를 정의하는 클래스 (전부 Optional)
 * 점수, 성공여부, 완료여부, 응답, 소요시간, 확장정보 포함
 * Result가 필요 할 경우 어노테이션의 resultRequired값을 true로 설정하고 Result를 정의할 것
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class XapiResult {
    private Object score;
    private Boolean success;
    private Boolean completion;
    private String response;
    private String duration;
    private Map<String, Object> extensions;

    @JsonIgnore
    private boolean isValid = true;


    public Object getScore() {
        return score;
    }

    public Boolean getSuccess() {
        return success;
    }

    public Boolean getCompletion() {
        return completion;
    }

    public String getResponse() {
        return response;
    }

    public String getDuration() {
        return duration;
    }

    public Map<String, Object> getExtensions() {
        return extensions;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setScore(Object score) {
        this.score = score;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public void setCompletion(Boolean completion) {
        this.completion = completion;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public void setExtensions(Map<String, Object> extensions) {
        this.extensions = extensions;
    }

    public void setValidate(boolean validate) {
        isValid = validate;
    }
}
