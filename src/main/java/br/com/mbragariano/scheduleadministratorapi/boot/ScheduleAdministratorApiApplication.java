package br.com.mbragariano.scheduleadministratorapi.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "br.com.mbragariano")
public class ScheduleAdministratorApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScheduleAdministratorApiApplication.class, args);
	}

}
