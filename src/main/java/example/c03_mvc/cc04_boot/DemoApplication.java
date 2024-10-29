package example.c03_mvc.cc04_boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:/c03_04/application.properties")
public class DemoApplication {
	public static void main(String[] args) {
		System.out.println("Hello world! ");
		SpringApplication.run(DemoApplication.class, args);
	}
}
