package br.com.gna.sgcondominio.configuration.jdbc;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

@Configuration
public class HikariConfiguration {

	@Value("${spring.datasource.driver-class-name}")
	private String driver;

	@Value("${spring.datasource.hikari.connection-timeout}")
	private Long connectionTimeout;

	@Value("${spring.datasource.hikari.maximum-pool-size}")
	private Integer maximumPollSize;

	@Value("${spring.datasource.hikari.pool-name}")
	private String poolName;

	@Value("${spring.datasource.username}")
	private String username;

	@Value("${spring.datasource.password}")
	private String password;

	@Value("${spring.datasource.url}")
	private String url;

	@Bean
	public DataSource dataSource() {

		final HikariConfig hikariConfig = new HikariConfig();

		hikariConfig.setDriverClassName(driver);
		hikariConfig.setConnectionTimeout(connectionTimeout);
		hikariConfig.setMaximumPoolSize(maximumPollSize);
		hikariConfig.setPoolName(poolName);
		hikariConfig.setJdbcUrl(url);
		hikariConfig.setUsername(username);
		hikariConfig.setPassword(password);

		return new HikariDataSource(hikariConfig);
	}

}
