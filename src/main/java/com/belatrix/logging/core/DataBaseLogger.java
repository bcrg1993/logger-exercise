package com.belatrix.logging.core;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.belatrix.logging.bean.LoggerMessage;
import com.belatrix.logging.exception.LoggerException;
import com.belatrix.logging.util.LocalDateTimeUtil;
import com.belatrix.logging.util.ResourceProvider;
import com.belatrix.logging.util.constant.LoggerConstant;

public class DataBaseLogger extends AbstractLogger {

	private Connection connection;

	@Override
	public void loadConfiguration() {
		Properties properties = ResourceProvider.getProperties(LoggerConstant.DATABASE_FILE_NAME);

		try {
			connection = DriverManager.getConnection(properties.getProperty("url"), 
					properties.getProperty("user"),
					properties.getProperty("password"));
		} catch (Exception e) {
			throw new LoggerException(e.getMessage(), e);
		}
	}

	@Override
	public void writeLog(LoggerMessage loggerMessage) {
		Statement stmt = null;

		try {
			stmt = connection.createStatement();
			stmt.executeUpdate("insert into logger_tbl(id, message, level, execution_time) " + "values(NULL, '"
					+ loggerMessage.getMessage() + "', " + "'"
					+ String.valueOf(loggerMessage.getLoggerLevel().getLoggerLevelId()) + "', " + "'"
					+ LocalDateTimeUtil.getCurrentLocalDateTime() + "')");
		} catch (SQLException e) {
			throw new LoggerException(e.getMessage(), e);
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				throw new LoggerException(e.getMessage(), e);
			}
		}
	}

	@Override
	public void closeResources() {
		try {
			connection.close();
		} catch (SQLException e) {
			throw new LoggerException(e.getMessage(), e);
		}
	}

}
