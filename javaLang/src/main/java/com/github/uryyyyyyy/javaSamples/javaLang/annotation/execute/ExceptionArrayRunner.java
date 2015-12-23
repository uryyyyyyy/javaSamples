package com.github.uryyyyyyy.javaSamples.javaLang.annotation.execute;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.github.uryyyyyyy.javaSamples.javaLang.annotation.impl.ExceptionArrayTest;
import com.github.uryyyyyyy.javaSamples.javaLang.annotation.marker.ExceptionArrayAnnotation;

public class ExceptionArrayRunner {
	public static void main(String[] args) throws Exception {
		int tests = 0;
		int passed = 0;

		@SuppressWarnings("rawtypes")
		Class testClass = ExceptionArrayTest.class;
		for (Method m : testClass.getDeclaredMethods()) {
			if (m.isAnnotationPresent(ExceptionArrayAnnotation.class)) {
				tests++;
				try {
					m.invoke(null);
					System.out.printf("Test %s failed : no exception%n", m);
				} catch (InvocationTargetException wrappedExc) {
					Throwable exc = wrappedExc.getCause();
					Class<? extends Exception>[] excTypes = m.getAnnotation(
							ExceptionArrayAnnotation.class).value();
					int oldPassed = passed;
					for (Class<? extends Exception> excType : excTypes) {
						if (excType.isInstance(exc)) {
							passed++;
							break;
						}
					}
					if (passed == oldPassed)
						System.out.printf("Test %s failed : %s %n", m, exc);
				} catch (Exception exc) {
					System.out.println(" INVALID @TestAnnotation : " + m);
				}
			}
		}
		System.out.printf("Passed : %d， Failed : %d%n", passed, tests - passed);
	}
}