package com.example.standalonedsjndi;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.standalonedsjndi.properties.PropertyLoader;

public class AppTest {
	private static final Logger logger = LoggerFactory.getLogger(AppTest.class);

	@Test
	public void testLengthOfTheUniqueKey() {
		logger.debug("Logger working !!!");
		PropertyLoader.loadProps();
		System.out.println("Default Test template");

	}
}
