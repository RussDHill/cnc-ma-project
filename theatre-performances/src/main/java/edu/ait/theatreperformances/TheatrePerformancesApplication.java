package edu.ait.theatreperformances;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TheatrePerformancesApplication {

	public static void main(String[] args) {
		SpringApplication.run(TheatrePerformancesApplication.class, args);
	}

}
