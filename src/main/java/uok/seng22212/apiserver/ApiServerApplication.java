package uok.seng22212.apiserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import uok.seng22212.apiserver.configurations.FirebaseConfigurations;

import java.io.IOException;

@SpringBootApplication
public class ApiServerApplication {

	public static void main(String[] args) throws IOException {
		FirebaseConfigurations.initializeFirebase();
		SpringApplication.run(ApiServerApplication.class, args);
	}

}
