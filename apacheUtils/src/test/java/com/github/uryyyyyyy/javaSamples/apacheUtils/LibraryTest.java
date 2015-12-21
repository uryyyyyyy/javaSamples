package com.github.uryyyyyyy.javaSamples.apacheUtils;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class LibraryTest {

    @Test public void testSomeLibraryMethod() {
        com.github.uryyyyyyy.javaSamples.javaIO.Library classUnderTest = new com.github.uryyyyyyy.javaSamples.javaIO.Library();
        assertTrue("someLibraryMethod should return 'true'", classUnderTest.someLibraryMethod());
    }
}