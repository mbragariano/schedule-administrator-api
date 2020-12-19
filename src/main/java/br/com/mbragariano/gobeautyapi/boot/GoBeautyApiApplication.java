package br.com.mbragariano.gobeautyapi.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "br.com.mbragariano")
public class GoBeautyApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoBeautyApiApplication.class, args);
	}

}
