package com.java;

import com.java.config.ApplicationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EnableConfigurationProperties({ApplicationProperties.class})
public class SpringbootMasterApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMasterApplication.class, args);
	}

}

@Component
class AppInitializer implements CommandLineRunner{

@Value("${app.version}")
	private String appVersion;

@Autowired
ApplicationProperties applicationProperties;
	@Override
	public void run(String... args) throws Exception {
		System.out.println("The app version is "+appVersion);
		System.out.println("App latest version is "+applicationProperties.getVersion());
		System.out.println("application properties "+applicationProperties);
	}
}
