package com.meursong.xapi.consonant;


/**
 * 2024.12.24[susong]: LRS 설계
 * xAPI 규격의 Object요소의 id설계를 규격화하는 enum클래스
 *
 */
public enum XapiObjectType {
    CONSULTANT("/consultant"),
    CONSULTING_SCHEDULE("/consulting/schedule"),
    MENTOR("/mentor"),
    ROADMAP("/roadmap"),
    CAREER("/career"),
    EXPERIENCE_PROGRAM("/experience/program"),
    ONLINE_COUNSELING("/online/counseling"),
    PARENT_CHILD_CONNECTION("/parent-child/connection"),
    JOB("/job"),
    MAJOR("/major"),
    SCHOOL("/school"),
    CLUB("/club");

    private final String endpoint;

    public String getEndpoint() {
        return endpoint;
    }

    XapiObjectType(String endpoint) {
        this.endpoint = endpoint;
    }

}