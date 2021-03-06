package com.example.standalonedsjndi.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PropertyLoader {
	private static final Logger logger = LoggerFactory.getLogger(PropertyLoader.class);

	public static Properties getProps() {

		Properties prop = new Properties();
		InputStream input = null;

		try {

			String filename = "config.properties";
			input = PropertyLoader.class.getClassLoader().getResourceAsStream(
					filename);
			if (input == null) {
				System.out.println("Sorry, unable to find " + filename);
				return prop;
			}

			// load a properties file from class path, inside static method
			prop.load(input);

			// get the property value and print it out
			System.out.println(prop.getProperty("database"));
			System.out.println(prop.getProperty("dbuser"));
			System.out.println(prop.getProperty("dbpassword"));
			return prop;
		} catch (IOException ex) {
			logger.info("loggin");
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
		return prop;

	}

	public static void loadProps() {
		Properties prop = new Properties();
		InputStream input = null;

		try {

			String filename = "config.properties";
			input = PropertyLoader.class.getClassLoader().getResourceAsStream(
					filename);
			if (input == null) {
				logger.error("Sorry, unable to find " + filename);
				System.out.println("Sorry, unable to find " + filename);
				return;
			}

			// load a properties file from class path, inside static method
			prop.load(input);

			// get the property value and print it out
			System.out.println(prop.getProperty("database"));
			System.out.println(prop.getProperty("dbuser"));
			System.out.println(prop.getProperty("dbpassword"));

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}
}
