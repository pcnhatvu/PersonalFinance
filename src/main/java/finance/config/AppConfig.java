package finance.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class AppConfig {

	@Bean
	public DataSource dataSource() {
		return new DriverManagerDataSource("jdbc:mysql://localhost:3306/personal_finance", "root", "123456");
	}
}
