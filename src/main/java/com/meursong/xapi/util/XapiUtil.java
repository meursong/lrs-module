package com.meursong.xapi.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.meursong.xapi.consonant.ContextActivityType;
import com.meursong.xapi.dto.element.xapiActor.XapiAccount;
import com.meursong.xapi.dto.element.xapiActor.XapiActor;
import com.meursong.xapi.dto.element.xapiActor.XapiAgent;
import com.meursong.xapi.dto.element.xapiContext.XapiContext;
import com.meursong.xapi.dto.element.xapiObject.Activity;

import java.util.Map;
import java.util.UUID;

/**
 * 2024.12.24[susong]: xAPI와 관련된 유틸리티 클래스
 * xAPI 스펙에 맞는 Actor, XapiVerb, Object, Context, Statement를 생성하는 메서드를 제공
 */
public class XapiUtil {

    private XapiUtil() {
        // 인스턴스화 방지
    }

    // statement ID에 사용되는 UUID 생성 메서드
    public static String generateId() {
        return UUID.randomUUID().toString();
    }

    /**
     * 2024.12.24[susong]: Actor 객체 생성
     * @param actorName 액터 이름
     * @param homePage 홈 페이지 URL
     * @return Actor 객체
     */
    public static XapiActor createAgentWithAccount(String actorName, String homePage) {
        XapiAgent agent = new XapiAgent();

        XapiAccount xapiAccount = new XapiAccount();
        xapiAccount.setName(actorName);
        xapiAccount.setHomePage(homePage);
        agent.setAccount(xapiAccount);

        if (!agent.isValid()) {
            throw new IllegalArgumentException("Invalid Agent: XapiAccount must have valid actorName and homePage.");
        }

        return agent;
    }

    /**
     * 2024.12.24[susong]: Activity(Object) 객체 생성
     * @param objectId 객체 ID
     * @param objectDefinition 객체 메타데이터
     * @return Activity 객체
     */
    public static Activity createActivityObject(Activity activity, String objectId, Activity.ActivityDefinition objectDefinition) {
        activity.setId(objectId);
        activity.setObjectType("Activity");
        activity.setDefinition(objectDefinition);

        return activity;
    }

    public static Activity createActivity(String objectBaseUrl, String endpoint , String entityId, Activity.ActivityDefinition objectDefinition) {

        Activity activity = new Activity();

        // 유효성 검증
        boolean isValid = true;

        if (objectBaseUrl == null || objectBaseUrl.isEmpty()) {
            isValid = false;
        }

        if (endpoint  == null || endpoint .isEmpty()) {
            isValid = false;
        }

        activity.setValidate(isValid);

        StringBuilder url = new StringBuilder(objectBaseUrl)
                .append(endpoint );

        if (entityId != null && !entityId.isEmpty()) {
            url.append("/").append(entityId);
        }

        String objectId = url.toString();

        return createActivityObject(activity, objectId, objectDefinition);
    }

    /**
     * TODO: Context는 타입이 다양하여 추후에 추가 구현 필요
     * 2024.12.24[susong]: XapiContext 객체 생성
     * @param platform 플랫폼
     * @param language 언어
     * @param contextActivities 컨텍스트 활동 맵
     * @return XapiContext 객체
     */
    public static XapiContext createXapiContext(String platform, String language, Map<ContextActivityType, Object> contextActivities) {
        XapiContext xapiContext = new XapiContext();
        xapiContext.setPlatform(platform);
        xapiContext.setLanguage(language);
        xapiContext.setContextActivities(contextActivities);
        return xapiContext;
    }

    // JSON 직렬화 유틸리티
    private static String convertToJson(Object object) {
        try {
            return new ObjectMapper().writeValueAsString(object);
        } catch (JsonProcessingException e) {
            return "{}"; // 직렬화 실패 시 빈 JSON 반환
        }
    }

    // Object Id 빌더
    public static String buildObjectId(String objectBaseUrl, String targetObject, String variable) {

        // 유효성 검증
        boolean isValid = true;

        if (objectBaseUrl == null || objectBaseUrl.isEmpty()) {
            isValid = false;
        }

        if (targetObject == null || targetObject.isEmpty()) {
            isValid = false;
        }

        if (!isValid) {
            throw new IllegalArgumentException("Invalid arguments for building xapiObject ID");
        }

        StringBuilder url = new StringBuilder(objectBaseUrl)
                .append(targetObject);

        if (variable != null && !variable.isEmpty()) {
            url.append("/").append(variable);
        }

        return url.toString();
    }

    // Object Id 빌더
    public static String buildObjectId(String objectBaseUrl, String targetObject) {
        StringBuilder url = new StringBuilder(objectBaseUrl)
                .append(targetObject);


        return url.toString();
    }


    // 메서드 파라미터에서 params(CommandMap)를 찾기위함
    public static Map<String, Object> findMapInArguments(Object[] args) {
        for (Object arg : args) {
            if (arg instanceof Map) {
                return (Map<String, Object>) arg;
            }
        }
        return null;
    }
}
