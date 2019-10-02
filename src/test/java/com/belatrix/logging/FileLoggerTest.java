package com.belatrix.logging;

import org.junit.Test;

import com.belatrix.logging.bean.LoggerMessage;
import com.belatrix.logging.core.AbstractLogger;
import com.belatrix.logging.core.LoggerFactory;
import com.belatrix.logging.exception.LoggerException;
import com.belatrix.logging.util.enums.LoggerLevel;
import com.belatrix.logging.util.enums.LoggerType;

public class FileLoggerTest {

	private static final AbstractLogger logger = LoggerFactory.getLogger(LoggerType.FILE);

	@Test
	public void printFileLogger() {
		String message = "This is a message with FileLogger";

		logger.print(new LoggerMessage(LoggerLevel.MESSAGE, message));
		logger.print(new LoggerMessage(LoggerLevel.SEVERE, message));
		logger.print(new LoggerMessage(LoggerLevel.WARNING, message));
	}

	@Test(expected = LoggerException.class)
	public void printFileLoggerWithException() {
		logger.print(new LoggerMessage(LoggerLevel.MESSAGE, ""));
	}

}
