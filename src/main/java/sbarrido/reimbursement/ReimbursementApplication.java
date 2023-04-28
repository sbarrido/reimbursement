package sbarrido.reimbursement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
//exclude = {DataSourceAutoConfiguration.class}
@SpringBootApplication
public class ReimbursementApplication {
	public static void main(String[] args) {
		SpringApplication.run(ReimbursementApplication.class, args);
	}

}
