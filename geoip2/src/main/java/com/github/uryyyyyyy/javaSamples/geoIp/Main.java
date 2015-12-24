package com.github.uryyyyyyy.javaSamples.geoIp;

import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CityResponse;
import com.maxmind.geoip2.model.CountryResponse;

import javax.naming.AuthenticationException;
import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.*;
import java.io.File;
import java.io.IOException;
import java.net.InetAddress;
import java.util.*;

public class Main {

	public static final String countryDBPath = "/path/to/GeoLite2-Country.mmdb";
	public static final String cityDBPath = "/path/to/Downloads/GeoLite2-City.mmdb";

	public static void main(String[] args) throws IOException, GeoIp2Exception {
		List<String> countryList = Arrays.asList("ja");
		DatabaseReader reader = new DatabaseReader.Builder(new File(countryDBPath)).locales(countryList).build();
		InetAddress ipAddress = InetAddress.getByName("173.194.38.201");
		CountryResponse cRes =  reader.country(ipAddress);
		System.out.println(cRes.toJson());
		System.out.println(cRes.getCountry().getName());

		DatabaseReader reader2 = new DatabaseReader.Builder(new File(cityDBPath)).locales(countryList).build();
		InetAddress ipAddress2 = InetAddress.getByName("173.194.38.201");
		CityResponse cRes2 =  reader2.city(ipAddress2);
		System.out.println(cRes2.toJson());
		System.out.println(cRes2.getCity().getName());
	}

}