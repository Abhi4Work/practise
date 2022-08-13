package com.abhi4work.receiptmanagementsystem.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.StringUtils;

import javax.sql.DataSource;
import java.sql.SQLException;

//@Configuration
public class DataSourceConfig
{
//	@Autowired
//	ConfigProperties receiptProperties;
//
//
//	@Bean(name = "receipt_db_config")
//	public javax.sql.DataSource dataSource() throws SQLException
//	{
//		HikariConfig config = new HikariConfig();
//		config.setJdbcUrl(receiptProperties.getConfigValue("database.db_url"));
//		config.setDriverClassName(receiptProperties.getConfigValue("database.db_driver"));
//		config.setUsername(receiptProperties.getConfigValue("database.db_user"));
//		config.setPassword(receiptProperties.getConfigValue("database.db_password"));
//		String maxPoolSize = receiptProperties.getConfigValue("database.maximum_pool_size");
//		String poolName = receiptProperties.getConfigValue("database.pool_name");
//		String minimumIdle = receiptProperties.getConfigValue("database.minimum_idle");
//
//		if (!StringUtils.isEmpty(maxPoolSize))
//		{
//			config.setMaximumPoolSize(Integer.parseInt(maxPoolSize));
//		}
//		if (!StringUtils.isEmpty(poolName))
//		{
//			config.setPoolName(poolName);
//		}
//		if (!StringUtils.isEmpty(minimumIdle))
//		{
//			config.setMinimumIdle(Integer.parseInt(minimumIdle));
//		}
//		return new HikariDataSource(config);
//	}
//
//	@Bean(name = "jdbcTemplate-receipt")
//	public JdbcTemplate jdbcTemplate(@Qualifier("receipt_db_config") DataSource dataSource)
//	{
//		return new JdbcTemplate(dataSource);
//	}

}
