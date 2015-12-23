package com.github.uryyyyyyy.javaSamples.javaLang.annotation.execute;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.github.uryyyyyyy.javaSamples.javaLang.annotation.impl.SampleTest;
import com.github.uryyyyyyy.javaSamples.javaLang.annotation.marker.TestAnnotation;

/**
 * 
 * JUnitテストの簡易実装。通常編
 */
public class TestRunner {
	public static void main(String[] args) throws Exception {
		int tests = 0;
		int passed = 0;

		@SuppressWarnings("rawtypes")
		Class testClass = SampleTest.class;
		for (Method m : testClass.getDeclaredMethods()) {
			if (m.isAnnotationPresent(TestAnnotation.class)) {
				tests++;
				try {
					m.invoke(null);
					passed++;
				} catch (InvocationTargetException wrappedExc) {
					Throwable exc = wrappedExc.getCause();
					System.out.println(m + " failed : " + exc);
				} catch (Exception exc) {
					System.out.println(" INVALID @TestAnnotation : " + m);
				}
			}
		}
		System.out.printf("Passed : %d， Failed : %d%n", passed, tests
				- passed);
	}
}