package org.wikimedia.ci.sonarqube.notifications;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class SonarqubeGerritNotificationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(SonarqubeGerritNotificationsApplication.class, args);
	}

}
