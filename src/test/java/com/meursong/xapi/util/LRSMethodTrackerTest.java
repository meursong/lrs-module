package com.meursong.xapi.util;

import com.meursong.xapi.annotation.TrackLRS;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LRSMethodTrackerTest {

    static class TestService {
        @TrackLRS(description = "Test method 1 description")
        public void lrsMethod1() {}

        @TrackLRS(description = "Test method 2 description")
        public void lrsMethod2() {}

        public void nonLrsMethod() {}
    }

    @Test
    void testGetTrackedMethodsWithDescriptions() {
        TestService service = new TestService();

        // Get the tracked methods
        List<String> trackedMethods = LRSMethodTracker.getTrackedMethodsWithDescriptions(service);

        // Assertions
        assertEquals(2, trackedMethods.size(), "There should be 2 tracked methods");
        assertTrue(trackedMethods.contains("lrsMethod1 - Test method 1 description"),
                "testMethod1 should be tracked with the correct description");
        assertTrue(trackedMethods.contains("lrsMethod2 - Test method 2 description"),
                "testMethod2 should be tracked with the correct description");
        assertFalse(trackedMethods.contains("nonLrsMethod"),
                "nonTrackedMethod should not be included in the tracked methods");
    }
}