package com.belatrix.logging.core;

import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;
import java.util.logging.StreamHandler;

import com.belatrix.logging.bean.LoggerMessage;
import com.belatrix.logging.exception.LoggerException;
import com.belatrix.logging.util.constant.LoggerConstant;

public abstract class AbstractLogger {
	
	public void print(LoggerMessage loggerMessage) {
		if(!loggerMessage.isValid()) {
			throw new LoggerException("Invalid configuration");
		}		
		
		this.writeLog(loggerMessage);
	}
	
	protected void formattedLogMessage(StreamHandler streamHandler) {
		streamHandler.setFormatter(new Formatter() {
			
			@Override
			public String format(LogRecord record) {
				return String.format(LoggerConstant.LOG_MESSAGE_PATTERN, new Date(record.getMillis()), 
						record.getLevel(), record.getMessage());
			}
		});
	}
	
	public abstract void loadConfiguration();
	public abstract void writeLog(LoggerMessage loggerMessage);
	public abstract void closeResources();

}
