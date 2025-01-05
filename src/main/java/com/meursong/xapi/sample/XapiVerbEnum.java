package com.meursong.xapi.sample;
import com.meursong.xapi.common.Language;
import com.meursong.xapi.elements.verb.XapiVerb;

import java.util.Map;

public enum XapiVerbEnum {
    COMPLETED("http://adlnet.gov/expapi/verbs/completed",
            Map.of(
                    Language.EN_US, "completed",
                    Language.KO_KR, "완료하다",
                    Language.FR_FR, "terminé",
                    Language.ES_ES, "completado",
                    Language.JA_JP, "完了した",
                    Language.ZH_CN, "已完成"
            )),
    VIEWED("http://id.tincanapi.com/verb/viewed",
            Map.of(
                    Language.EN_US, "viewed",
                    Language.KO_KR, "보다",
                    Language.FR_FR, "vu",
                    Language.ES_ES, "visto",
                    Language.JA_JP, "見た",
                    Language.ZH_CN, "查看"
            )),
    SHARED("http://adlnet.gov/expapi/verbs/shared",
            Map.of(
                    Language.EN_US, "shared",
                    Language.KO_KR, "공유하다",
                    Language.FR_FR, "partagé",
                    Language.ES_ES, "compartido",
                    Language.JA_JP, "共有した",
                    Language.ZH_CN, "共享"
            )),
    APPLIED("https://w3id.org/xapi/dod-isd/verbs/applied",
            Map.of(
                    Language.EN_US, "applied",
                    Language.KO_KR, "신청하다",
                    Language.FR_FR, "appliqué",
                    Language.ES_ES, "aplicado",
                    Language.JA_JP, "申し込んだ",
                    Language.ZH_CN, "申请"
            )),
    UPDATED("https://w3id.org/xapi/dod-isd/verbs/updated",
            Map.of(
                    Language.EN_US, "updated",
                    Language.KO_KR, "수정하다",
                    Language.FR_FR, "mis à jour",
                    Language.ES_ES, "actualizado",
                    Language.JA_JP, "更新した",
                    Language.ZH_CN, "更新"
            ));


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
