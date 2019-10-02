package com.belatrix.logging.util.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum LoggerLevel {

	MESSAGE ("MESSAGE", 1),
	SEVERE ("SEVERE", 2),
	WARNING ("WARNING", 3);
	
	private String loggerLevelName;
	private Integer loggerLevelId;
}
