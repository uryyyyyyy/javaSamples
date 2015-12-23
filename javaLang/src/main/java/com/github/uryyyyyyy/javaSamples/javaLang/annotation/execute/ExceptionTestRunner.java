package com.github.uryyyyyyy.javaSamples.javaLang.annotation.execute;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.github.uryyyyyyy.javaSamples.javaLang.annotation.impl.ExceptionTest;
import com.github.uryyyyyyy.javaSamples.javaLang.annotation.marker.ExceptionTestAnnotation;

/**
 * 
 * JUnitテストの簡易実装。例外編
 */
public class ExceptionTestRunner {
	public static void main(String[] args) throws Exception {
		int tests = 0;
		int passed = 0;

		@SuppressWarnings("rawtypes")
		Class testClass = ExceptionTest.class;
		for (Method m : testClass.getDeclaredMethods()) {
			if (m.isAnnotationPresent(ExceptionTestAnnotation.class)) {
				tests++;
				try {
					m.invoke(null);
					System.out.printf("Test %s failed : no exception%n", m);
				} catch (InvocationTargetException wrappedExc) {
					Throwable exc = wrappedExc.getCause();
					Class<? extends Exception> excType = m.getAnnotation(
							ExceptionTestAnnotation.class).value();
					if (excType.isInstance(exc)) {
						passed++;
					} else {
						System.out.printf(
								"Test %s failed : expected %s， got %s%n", m,
								excType.getName(), exc);
					}
				} catch (Exception exc) {
					System.out.println(" INVALID @TestAnnotation : " + m);
				}
			}
		}
		System.out.printf("Passed : %d， Failed : %d%n", passed, tests - passed);
	}
}