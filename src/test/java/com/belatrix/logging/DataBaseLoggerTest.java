package com.belatrix.logging;

import org.junit.After;
import org.junit.Test;

import com.belatrix.logging.bean.LoggerMessage;
import com.belatrix.logging.core.AbstractLogger;
import com.belatrix.logging.core.LoggerFactory;
import com.belatrix.logging.exception.LoggerException;
import com.belatrix.logging.util.enums.LoggerLevel;
import com.belatrix.logging.util.enums.LoggerType;

public class DataBaseLoggerTest {

	private static final AbstractLogger logger = LoggerFactory.getLogger(LoggerType.DATABASE);

	@Test
	public void printDataBaseLogger() {
		String message = "This is a message with DataBaseLogger";

		logger.print(new LoggerMessage(LoggerLevel.MESSAGE, message));
		logger.print(new LoggerMessage(LoggerLevel.SEVERE, message));
		logger.print(new LoggerMessage(LoggerLevel.WARNING, message));
	}

	@Test(expected = LoggerException.class)
	public void printDataBaseLoggerWithException() {
		logger.print(new LoggerMessage(LoggerLevel.MESSAGE, ""));
	}

	@After
	public void closeResources() {
		logger.closeResources();
	}

}
