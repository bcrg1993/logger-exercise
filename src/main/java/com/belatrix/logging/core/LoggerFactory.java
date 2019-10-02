package com.belatrix.logging.core;

import com.belatrix.logging.exception.LoggerException;
import com.belatrix.logging.util.enums.LoggerType;

public class LoggerFactory {

	public static AbstractLogger getLogger(LoggerType loggerType) {
		AbstractLogger abstractLogger = null;

		switch (loggerType) {
		case CONSOLE:
			abstractLogger = new ConsoleLogger();
			break;
		case FILE:
			abstractLogger = new FileLogger();
			break;
		case DATABASE:
			abstractLogger = new DataBaseLogger();
			break;
		default:
			throw new LoggerException("Invalid configuration");
		}
		
		abstractLogger.loadConfiguration();
		
		return abstractLogger;
	}
}
