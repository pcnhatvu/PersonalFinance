package finance;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan("finance")
public class PersonalFinanceApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(PersonalFinanceApplication.class, args);
	}

}
