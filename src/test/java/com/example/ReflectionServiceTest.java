package com.example;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;


public class ReflectionServiceTest {
    @Test
    public void test() throws Exception {

        System.out.println("----------------------------------------------------------------------------");

        // 1. 클래스 로드
        // clazz는 "이 변수는 클래스를 나타내는 객체" 라고 알수있도록 한 관습임 spring이나 hibernate에도 너리 사용
        // 이렇게 가져온 Class객체가 리플렉션의 핵심임. 런타임에 클래스의 정보를 가져오고 조작하는 엔트리 포인트
        // 이 객체는 자바에서 클래스 메타데이터를 표현하며 플렉션을 통해 실행 중에 클래스의 구조(필드, 메서드, 생성자 등)를 탐색하고 조작할 수 있도록 함
        // 리플렉션의 모든 주요 기능은 이 Class 객체를 기반으로 동작
        Class<?> clazz = Class.forName("com.example.ReflectionService");
        System.out.println("클래스 이름 :" + clazz.getName());

        System.out.println("----------------------------------------------------------------------------");

        // 2. 생성자를 사용해 인스턴스 생성
        Constructor<?> constructor = clazz.getDeclaredConstructor(String.class);
        constructor.setAccessible(true); // private 생성자 접근 허용
        Object instance = constructor.newInstance("initialValue");

        System.out.println("----------------------------------------------------------------------------");

        // 3. 필드 접근 및 값 수정
        Field field = clazz.getDeclaredField("privateField");
        field.setAccessible(true); // private 필드 접근 허용
        System.out.println("Original field value: " + field.get(instance));
        field.set(instance, "newValue");
        System.out.println("Updated field value: " + field.get(instance));

        System.out.println("----------------------------------------------------------------------------");

        // 4. 메서드 호출
        Method method = clazz.getDeclaredMethod("privateMethod", String.class);
        method.setAccessible(true); // private 메서드 접근 허용
        method.invoke(instance, "testParameter");

        System.out.println("----------------------------------------------------------------------------");
    }

}