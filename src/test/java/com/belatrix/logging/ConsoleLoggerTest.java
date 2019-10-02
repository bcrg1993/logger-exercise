package com.belatrix.logging;

import org.junit.Test;

import com.belatrix.logging.bean.LoggerMessage;
import com.belatrix.logging.core.AbstractLogger;
import com.belatrix.logging.core.LoggerFactory;
import com.belatrix.logging.exception.LoggerException;
import com.belatrix.logging.util.enums.LoggerLevel;
import com.belatrix.logging.util.enums.LoggerType;

public class ConsoleLoggerTest {

	private static final AbstractLogger logger = LoggerFactory.getLogger(LoggerType.CONSOLE);

	@Test
	public void printConsoleLogger() {
		String message = "This is a message with ConsoleLogger";

		logger.print(new LoggerMessage(LoggerLevel.MESSAGE, ""));
		logger.print(new LoggerMessage(LoggerLevel.SEVERE, message));
		logger.print(new LoggerMessage(LoggerLevel.WARNING, message));
	}

	@Test(expected = LoggerException.class)
	public void printConsoleLoggerWithException() {
		logger.print(new LoggerMessage(LoggerLevel.MESSAGE, ""));
	}
}
