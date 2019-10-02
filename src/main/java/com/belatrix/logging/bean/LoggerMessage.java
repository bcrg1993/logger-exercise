package com.belatrix.logging.bean;

import com.belatrix.logging.util.enums.LoggerLevel;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoggerMessage {

	private LoggerLevel loggerLevel;
	private String message;

	public boolean isValid() {
		return loggerLevel != null && message != null && !message.isEmpty();
	}

}
