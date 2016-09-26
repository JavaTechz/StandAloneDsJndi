package com.example.standalonedsjndi;

import org.junit.Test;

import com.example.standalonedsjndi.properties.PropertyLoader;

public class AppTest {

	@Test
	public void testLengthOfTheUniqueKey() {
		PropertyLoader.loadProps();
		System.out.println("Default Test template");

	}
}
