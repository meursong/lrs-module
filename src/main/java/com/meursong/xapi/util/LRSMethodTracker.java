package com.meursong.xapi.util;

import com.meursong.xapi.annotation.TrackLRS;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class LRSMethodTracker {
//    public static void executeTrackedMethod(Object instance, String methodName, Object... args) throws Exception {
//        Method method = instance.getClass().getMethod(methodName, getParameterTypes(args));
//        if (method.isAnnotationPresent(TrackLRS.class)) {
//            TrackLRS annotation = method.getAnnotation(TrackLRS.class);
//            System.out.println("LRS Tracking Started - Method: " + methodName);
//            if (!annotation.description().isEmpty()) {
//                System.out.println("LRS Annotation Value: " + annotation.description());
//            }
//            // Execute the actual method
//            method.invoke(instance, args);
//            System.out.println("LRS Tracking Completed - Method: " + methodName);
//        } else {
//            // Execute without tracking
//            method.invoke(instance, args);
//        }
//    }

    public static List<String> getTrackedMethodsWithDescriptions(Object instance) {
        List<String> trackedMethods = new ArrayList<>();
        for (Method method : instance.getClass().getDeclaredMethods()) {
            if (method.isAnnotationPresent(TrackLRS.class)) {
                TrackLRS annotation = method.getAnnotation(TrackLRS.class);
                trackedMethods.add(method.getName() + " - " + annotation.description());
            }
        }
        return trackedMethods;
    }

    private static Class<?>[] getParameterTypes(Object... args) {
        return java.util.Arrays.stream(args)
                .map(Object::getClass)
                .toArray(Class<?>[]::new);
    }
}
