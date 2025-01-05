package com.meursong.xapi.aop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 2024.12.24[susong]: Lrs에 저장할 Statement를 생성하는 어노테이션
 * -----------------------------------------------------------------------------------------
 * method : PUT (단일 statement 생성), POST (다중 statement 생성)
 * actorKey : 액션을 수행한 사용자의 키 ( Default : 유저ID )
 * verbKey : 액션의 동사 키 ( XapiConstants.Verbs )
 * objectVariableKeyRequired : objectVariableKey가 필수인지 여부 ( Default : false )
 * objectKey : 액션의 목적어 키
 * objectVariableKey : 액션의 목적어의 변수 키 ( 동적변수가 필요없으면 ""로 설정하고 objectVariableKeyRequired를 false로 설정 )
 * resultRequired : result가 필수인지 여부 ( Default : false )
 * resultkey : xapiResult 키
 * contextRequired : context가 필수인지 여부 ( Default : false )
 * contextKey : xapiContext 키
 * -----------------------------------------------------------------------------------------
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface LrsStatement {
    String method();

    String actorKey();

    String verbKey();

    String objectKey();

    boolean objectVariableKeyRequired() default true; // Object 변수 필수 여부
    String objectVariableKey() default "";;

    boolean resultRequired() default false; // required 필수 여부
    String resultkey() default "";

    boolean contextRequired() default false; // xapiContext 필수 여부
    String contextKey() default "";
}
