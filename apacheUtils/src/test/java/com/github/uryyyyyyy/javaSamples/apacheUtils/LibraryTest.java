package com.github.uryyyyyyy.javaSamples.apacheUtils;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class LibraryTest {

    @Test public void testSomeLibraryMethod() {
        int i = 2 + 3;
        assertThat(i, is(5));
    }
}