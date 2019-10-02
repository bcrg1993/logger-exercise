package com.belatrix.logging.core;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.belatrix.logging.bean.LoggerMessage;
import com.belatrix.logging.exception.LoggerException;
import com.belatrix.logging.util.enums.LoggerLevel;

public class ConsoleLogger extends AbstractLogger {

	private static final Logger logger = Logger.getLogger(ConsoleLogger.class.getName());

	@Override
	public void loadConfiguration() {
		ConsoleHandler consoleHandler = new ConsoleHandler();
		
		super.formattedLogMessage(consoleHandler);
		logger.addHandler(consoleHandler);
		logger.setUseParentHandlers(false);
	}

	@Override
	public void writeLog(LoggerMessage loggerMessage) {
		if (loggerMessage.getLoggerLevel().equals(LoggerLevel.MESSAGE)) {
			logger.log(Level.INFO, loggerMessage.getMessage());
		} else if (loggerMessage.getLoggerLevel().equals(LoggerLevel.SEVERE)) {
			logger.log(Level.SEVERE, loggerMessage.getMessage());
		} else if (loggerMessage.getLoggerLevel().equals(LoggerLevel.WARNING)) {
			logger.log(Level.WARNING, loggerMessage.getMessage());
		} else {
			throw new LoggerException("Invalid configuration");
		}
	}

	@Override
	public void closeResources() {
		return;
	}

}
