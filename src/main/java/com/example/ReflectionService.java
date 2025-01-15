package com.example;

public class ReflectionService {
    private String privateField;

    private ReflectionService(String constructorArg) {
        this.privateField = constructorArg;
    }

    private void privateMethod(String parameter) {
        System.out.println("Private method called with parameter: " + parameter);
    }

    public String getPrivateField() {
        return privateField;
    }
}
