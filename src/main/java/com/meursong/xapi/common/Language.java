package com.meursong.xapi.common;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Enum representing various language codes.
 * Usage of international standard format BCP 47 (currently RFC 5646 and RFC 4647) in xAPI (such as en-US, ko-KR, fr-FR...)
 */
public enum Language {
    AF("af"),
    AF_ZA("af-ZA"),
    AR("ar"),
    AR_AE("ar-AE"),
    AR_BH("ar-BH"),
    AR_DZ("ar-DZ"),
    AR_EG("ar-EG"),
    AR_IQ("ar-IQ"),
    AR_JO("ar-JO"),
    AR_KW("ar-KW"),
    AR_LB("ar-LB"),
    AR_LY("ar-LY"),
    AR_MA("ar-MA"),
    AR_OM("ar-OM"),
    AR_QA("ar-QA"),
    AR_SA("ar-SA"),
    AR_SY("ar-SY"),
    AR_TN("ar-TN"),
    AR_YE("ar-YE"),
    AZ("az"),
    AZ_AZ("az-AZ"),
    AZ_CYRL_AZ("az-Cyrl-AZ"),
    BE("be"),
    BE_BY("be-BY"),
    BG("bg"),
    BG_BG("bg-BG"),
    BS_BA("bs-BA"),
    CA("ca"),
    CA_ES("ca-ES"),
    CS("cs"),
    CS_CZ("cs-CZ"),
    CY("cy"),
    CY_GB("cy-GB"),
    DA("da"),
    DA_DK("da-DK"),
    DE("de"),
    DE_AT("de-AT"),
    DE_CH("de-CH"),
    DE_DE("de-DE"),
    DE_LI("de-LI"),
    DE_LU("de-LU"),
    DV("dv"),
    DV_MV("dv-MV"),
    EL("el"),
    EL_GR("el-GR"),
    EN("en"),
    EN_AU("en-AU"),
    EN_BZ("en-BZ"),
    EN_CA("en-CA"),
    EN_CB("en-CB"),
    EN_GB("en-GB"),
    EN_IE("en-IE"),
    EN_JM("en-JM"),
    EN_NZ("en-NZ"),
    EN_PH("en-PH"),
    EN_TT("en-TT"),
    EN_US("en-US"),
    EN_ZA("en-ZA"),
    EN_ZW("en-ZW"),
    EO("eo"),
    ES("es"),
    ES_AR("es-AR"),
    ES_BO("es-BO"),
    ES_CL("es-CL"),
    ES_CO("es-CO"),
    ES_CR("es-CR"),
    ES_DO("es-DO"),
    ES_EC("es-EC"),
    ES_ES("es-ES"),
    ES_GT("es-GT"),
    ES_HN("es-HN"),
    ES_MX("es-MX"),
    ES_NI("es-NI"),
    ES_PA("es-PA"),
    ES_PE("es-PE"),
    ES_PR("es-PR"),
    ES_PY("es-PY"),
    ES_SV("es-SV"),
    ES_UY("es-UY"),
    ES_VE("es-VE"),
    ET("et"),
    ET_EE("et-EE"),
    EU("eu"),
    EU_ES("eu-ES"),
    FA("fa"),
    FA_IR("fa-IR"),
    FI("fi"),
    FI_FI("fi-FI"),
    FO("fo"),
    FO_FO("fo-FO"),
    FR("fr"),
    FR_BE("fr-BE"),
    FR_CA("fr-CA"),
    FR_CH("fr-CH"),
    FR_FR("fr-FR"),
    FR_LU("fr-LU"),
    FR_MC("fr-MC"),
    GL("gl"),
    GL_ES("gl-ES"),
    GU("gu"),
    GU_IN("gu-IN"),
    HE("he"),
    HE_IL("he-IL"),
    HI("hi"),
    HI_IN("hi-IN"),
    HR("hr"),
    HR_BA("hr-BA"),
    HR_HR("hr-HR"),
    HU("hu"),
    HU_HU("hu-HU"),
    HY("hy"),
    HY_AM("hy-AM"),
    ID("id"),
    ID_ID("id-ID"),
    IS("is"),
    IS_IS("is-IS"),
    IT("it"),
    IT_CH("it-CH"),
    IT_IT("it-IT"),
    JA("ja"),
    JA_JP("ja-JP"),
    KA("ka"),
    KA_GE("ka-GE"),
    KK("kk"),
    KK_KZ("kk-KZ"),
    KN("kn"),
    KN_IN("kn-IN"),
    KO("ko"),
    KO_KR("ko-KR"),
    LT("lt"),
    LT_LT("lt-LT"),
    LV("lv"),
    LV_LV("lv-LV"),
    MI("mi"),
    MI_NZ("mi-NZ"),
    MK("mk"),
    MK_MK("mk-MK"),
    MN("mn"),
    MN_MN("mn-MN"),
    MS("ms"),
    MS_MY("ms-MY"),
    MT("mt"),
    MT_MT("mt-MT"),
    NL("nl"),
    NL_BE("nl-BE"),
    NL_NL("nl-NL"),
    NO("no"),
    PL("pl"),
    PL_PL("pl-PL"),
    PT("pt"),
    PT_BR("pt-BR"),
    PT_PT("pt-PT"),
    RU("ru"),
    RU_RU("ru-RU"),
    SV("sv"),
    SV_SE("sv-SE"),
    ZH("zh"),
    ZH_CN("zh-CN"),
    ZH_TW("zh-TW");

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
