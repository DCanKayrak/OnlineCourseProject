package com.dcankayrak.OnlineClub;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Members API", version = "1.0", description = "Members Information"))
public class OnlineClubApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineClubApplication.class, args);
	}

}
