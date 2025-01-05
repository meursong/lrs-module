package com.meursong.xapi.consonant;

import com.meursong.xapi.dto.element.xapiVerb.XapiVerb;

import java.util.Map;

/**
 * 2024.12.24[susong]: LRS 설계
 * xAPI스펙의 XapiVerb규격을 준수하고 재사용하기위해 상수화한 클래스
 */
public class XapiVerbConstants {

        public static final Map<String,XapiVerb> xapiVerbS = Map.ofEntries(
                Map.entry("COMPLETED", new XapiVerb(
                        "http://adlnet.gov/expapi/XapiVerbs/completed",
                        Map.of(
                                Language.EN_US, "completed",
                                Language.KO_KR, "완료하다"
                        )
                )),
                Map.entry("VIEWED", new XapiVerb(
                        "http://id.tincanapi.com/XapiVerb/viewed",
                        Map.of(
                                Language.EN_US, "viewed",
                                Language.KO_KR, "보다"
                        )
                )),
                Map.entry("SHARED", new XapiVerb(
                        "http://adlnet.gov/expapi/XapiVerbs/shared",
                        Map.of(
                                Language.EN_US, "shared",
                                Language.KO_KR, "공유하다"
                        )
                )),
                Map.entry("APPLIED", new XapiVerb(
                        "https://w3id.org/xapi/dod-isd/XapiVerbs/applied",
                        Map.of(
                                Language.EN_US, "applied",
                                Language.KO_KR, "신청하다"
                        )
                )),
                Map.entry("CANCELED", new XapiVerb(
                        "http://activitystrea.ms/cancel",
                        Map.of(
                                Language.EN_US, "canceled",
                                Language.KO_KR, "취소하다"
                        )
                )),
                Map.entry("REJECTED", new XapiVerb(
                        "http://activitystrea.ms/reject",
                        Map.of(
                                Language.EN_US, "rejected",
                                Language.KO_KR, "반려하다"
                        )
                )),
                Map.entry("SUBMITTED", new XapiVerb(
                        "https://w3id.org/xapi/dod-isd/XapiVerbs/submitted",
                        Map.of(
                                Language.EN_US, "submitted",
                                Language.KO_KR, "제출하다"
                        )
                )),
                Map.entry("UPDATED", new XapiVerb(
                        "https://w3id.org/xapi/dod-isd/XapiVerbs/updated",
                        Map.of(
                                Language.EN_US, "updated",
                                Language.KO_KR, "수정하다"
                        )
                )),
                Map.entry("CONFIRMED", new XapiVerb(
                        "https://w3id.org/xapi/dod-isd/XapiVerbs/confirmed",
                        Map.of(
                                Language.EN_US, "confirmed",
                                Language.KO_KR, "확정하다"
                        )
                )),
                Map.entry("ACHIEVED", new XapiVerb(
                        "https://w3id.org/xapi/dod-isd/XapiVerbs/achieved",
                        Map.of(
                                Language.EN_US, "achieved",
                                Language.KO_KR, "달성하다"
                        )
                )),
                Map.entry("SUSPENDED", new XapiVerb(
                        "http://adlnet.gov/expapi/XapiVerbs/suspended",
                        Map.of(
                                Language.EN_US, "suspended",
                                Language.KO_KR, "중단하다"
                        )
                )),
                Map.entry("RESUMED", new XapiVerb(
                        "http://adlnet.gov/expapi/XapiVerbs/resumed",
                        Map.of(
                                Language.EN_US, "resumed",
                                Language.KO_KR, "재개하다"
                        )
                )),
                Map.entry("FAVORITED", new XapiVerb(
                        "http://activitystrea.ms/favorite",
                        Map.of(
                                Language.EN_US, "favorited",
                                Language.KO_KR, "즐겨찾기하다"
                        )
                )),
                Map.entry("CREATED", new XapiVerb(
                        "https://w3id.org/xapi/dod-isd/XapiVerbs/created",
                        Map.of(
                                Language.EN_US, "created",
                                Language.KO_KR, "생성하다"
                        )
                )),
                Map.entry("LOGGED-IN", new XapiVerb(
                        "https://w3id.org/xapi/adl/XapiVerbs/logged-in",
                        Map.of(
                                Language.EN_US, "logged-in",
                                Language.KO_KR, "로그인하다"
                        )
                )),
                Map.entry("LOGGED-OUT", new XapiVerb(
                        "https://w3id.org/xapi/adl/XapiVerbs/logged-out",
                        Map.of(
                                Language.EN_US, "logged-out",
                                Language.KO_KR, "로그아웃하다"
                        )
                ))
        );

}

