package com.example.standalonedsjndi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.core.util.StatusPrinter;

import com.example.standalonedsjndi.properties.PropertyLoader;

/**
 * Generate a unique number
 *
 */
public class App {
	private static final Logger logger = LoggerFactory.getLogger(App.class);

	public static void main(String[] args) {
		LoggerContext lc = (LoggerContext) LoggerFactory.getILoggerFactory();
		// print logback's internal status
		StatusPrinter.print(lc);
		logger.debug("logger workingin main app");
		System.out.println("Date : " + new java.util.Date());
		PropertyLoader.getProps();
	}

}
