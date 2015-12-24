package com.github.uryyyyyyy.javaSamples.commonsLang;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import java.text.ParseException;
import java.util.Date;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class LibraryTest {

	@Test
	public void testSomeLibraryMethod() {
		String str1 = "";
		String str2 = null;
		String str3 = "haha";
		assertThat(StringUtils.isEmpty(str1), is(true));
		assertThat(StringUtils.isEmpty(str2), is(true));
		assertThat(StringUtils.isEmpty(str3), is(false));
	}

	@Test
	public void testDateUtils() throws ParseException {
		String[] acceptFormats = { "yyyy-MM-dd" }; //書式は複数指定できる
		Date d = DateUtils.parseDateStrictly("2013-04-06", acceptFormats);
		System.out.println(d);
	}

	@Test(expected = ParseException.class)
	public void testDateUtils2() throws ParseException {
		String[] acceptFormats = { "yyyy-MM-dd" };
		Date d = DateUtils.parseDateStrictly("2013-04-32", acceptFormats);
		System.out.println(d);
	}

	@Test
	public void testNumberUtils() {
		boolean b1 = NumberUtils.isDigits("12345");
		System.out.println(b1);
	}

}