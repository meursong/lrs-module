package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class ReflectionServiceTest {
    @Test
    public void ClassNameTest() {
        try {
            Class<?> clazz = Class.forName("com.example.ReflectionService");
            System.out.println("Class found: " + clazz.getName());
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found: " + e.getMessage());
        }
    }

}