package by.htp.les04;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@ImportResource("classpath:applicationContext.xml")
public class App {
	
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

}
