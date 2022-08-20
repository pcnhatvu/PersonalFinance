package finance;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("finance")
public class PersonalFinanceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PersonalFinanceApplication.class, args);
	}

}
