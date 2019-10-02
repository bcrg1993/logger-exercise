package com.belatrix.logging.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.belatrix.logging.core.DataBaseLogger;
import com.belatrix.logging.exception.LoggerException;

public class ResourceProvider {

	public static Properties getProperties(String propertiesFileName) {
		Properties properties = new Properties();

		try (InputStream input = DataBaseLogger.class.getClassLoader().getResourceAsStream(propertiesFileName)) {
			if (input == null) {
				throw new LoggerException("Sorry, unable to find " + propertiesFileName);
			}
			properties.load(input);
		} catch (IOException e) {
			throw new LoggerException(e.getMessage(), e);
		}

		return properties;
	}
}
