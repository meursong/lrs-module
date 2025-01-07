package com.meursong.xapi.aop.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation for creating a Statement to be stored in LRS
 * -----------------------------------------------------------------------------------------
 * method : PUT (Creates a single statement), POST (Creates multiple statements)
 * actorKey : The key of the user who performed the action
 * verbKey : The key of the verb of an action
 * objectVariableKeyRequired : Whether the objectVariableKey is required or not ( Default : false )
 * objectKey : The key of the action's direct object
 * objectVariableKey : Variable key of the action's direct object
 * resultRequired : Whether the result is required or not ( Default : false )
 * resultkey : xapiResult key
 * contextRequired : Whether the context is required or not ( Default : false )
 * contextKey : xapiContext key
 * -----------------------------------------------------------------------------------------
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface XapiStatement {
    String method();

    String actorKey();

    String verbKey();

    String objectKey();

    boolean objectVariableKeyRequired() default true; // Object 변수 필수 여부
    String objectVariableKey() default "";

    boolean resultRequired() default false; // required 필수 여부
    String resultkey() default "";

    boolean contextRequired() default false; // xapiContext 필수 여부
    String contextKey() default "";
}
