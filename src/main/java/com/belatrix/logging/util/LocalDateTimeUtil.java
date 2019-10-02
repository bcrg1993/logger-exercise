package com.belatrix.logging.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import com.belatrix.logging.util.constant.LoggerConstant;

public class LocalDateTimeUtil {

	public static String getCurrentLocalDateTime() {
		LocalDateTime localDateTime = LocalDateTime.now();
		return localDateTime.format(DateTimeFormatter.ofPattern(LoggerConstant.LOCAL_DATE_TIME_PATTERN));
	}

}
