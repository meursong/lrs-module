package com.meursong.xapi.consonant;
import com.meursong.xapi.dto.element.xapiVerb.XapiVerb;

import java.util.Map;

public enum XapiVerbEnum {
    COMPLETED("http://adlnet.gov/expapi/verbs/completed",
            Map.of(Language.EN_US, "completed", Language.KO_KR, "완료하다")),
    VIEWED("http://id.tincanapi.com/verb/viewed",
            Map.of(Language.EN_US, "viewed", Language.KO_KR, "보다")),
    SHARED("http://adlnet.gov/expapi/verbs/shared",
            Map.of(Language.EN_US, "shared", Language.KO_KR, "공유하다")),
    APPLIED("https://w3id.org/xapi/dod-isd/verbs/applied",
            Map.of(Language.EN_US, "applied", Language.KO_KR, "신청하다")),
    CANCELED("http://activitystrea.ms/cancel",
            Map.of(Language.EN_US, "canceled", Language.KO_KR, "취소하다")),
    REJECTED("http://activitystrea.ms/reject",
            Map.of(Language.EN_US, "rejected", Language.KO_KR, "반려하다")),
    REGISTERED("http://adlnet.gov/expapi/verbs/registered",
            Map.of(Language.EN_US, "registered", Language.KO_KR, "승인하다")),
    SUBMITTED("https://w3id.org/xapi/dod-isd/verbs/submitted",
            Map.of(Language.EN_US, "submitted", Language.KO_KR, "제출하다")),
    UPDATED("https://w3id.org/xapi/dod-isd/verbs/updated",
            Map.of(Language.EN_US, "updated", Language.KO_KR, "수정하다")),
    CONFIRMED("https://w3id.org/xapi/dod-isd/verbs/confirmed",
            Map.of(Language.EN_US, "confirmed", Language.KO_KR, "확정하다")),
    ACHIEVED("https://w3id.org/xapi/dod-isd/verbs/achieved",
            Map.of(Language.EN_US, "achieved", Language.KO_KR, "달성하다")),
    SUSPENDED("http://adlnet.gov/expapi/verbs/suspended",
            Map.of(Language.EN_US, "suspended", Language.KO_KR, "중단하다")),
    RESUMED("http://adlnet.gov/expapi/verbs/resumed",
            Map.of(Language.EN_US, "resumed", Language.KO_KR, "재개하다")),
    ATTEMPTED("http://adlnet.gov/expapi/verbs/attempted",
            Map.of(Language.EN_US, "attempted", Language.KO_KR, "시작하다")),
    FAVORITED("http://activitystrea.ms/favorite",
            Map.of(Language.EN_US, "favorited", Language.KO_KR, "즐겨찾기하다")),
    CREATED("https://w3id.org/xapi/dod-isd/verbs/created",
            Map.of(Language.EN_US, "created", Language.KO_KR, "생성하다")),
    LOGGED_IN("https://w3id.org/xapi/adl/verbs/logged-in",
            Map.of(Language.EN_US, "logged-in", Language.KO_KR, "로그인하다")),
    LOGGED_OUT("https://w3id.org/xapi/adl/verbs/logged-out",
            Map.of(Language.EN_US, "logged-out", Language.KO_KR, "로그아웃하다"));

    private final String id;
    private final XapiVerb xapiVerb;

    XapiVerbEnum(String id, Map<Language, String> display) {
        this.id = id;
        this.xapiVerb = new XapiVerb(id, display);
    }

    public String getId() {
        return id;
    }

    public XapiVerb getXapiVerb() {
        return xapiVerb;
    }

    @Override
    public String toString() {
        return this.xapiVerb.toString();
    }
}
