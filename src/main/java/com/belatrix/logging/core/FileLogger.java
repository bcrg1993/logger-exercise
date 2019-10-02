package com.belatrix.logging.core;

import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.belatrix.logging.bean.LoggerMessage;
import com.belatrix.logging.exception.LoggerException;
import com.belatrix.logging.util.constant.LoggerConstant;
import com.belatrix.logging.util.enums.LoggerLevel;

public class FileLogger extends AbstractLogger {
	
	private static final Logger logger = Logger.getLogger(FileLogger.class.getName());

	@Override
	public void loadConfiguration() {
		try {
			FileHandler fileHandler = new FileHandler(LoggerConstant.LOG_OUTPUT_LOCATION);
			
			super.formattedLogMessage(fileHandler);
			logger.addHandler(fileHandler);
			logger.setUseParentHandlers(false);
		} catch (Exception e) {
			throw new LoggerException(e.getMessage(), e);
		}
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
