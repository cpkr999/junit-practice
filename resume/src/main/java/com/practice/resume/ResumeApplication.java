package com.practice.resume;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class ResumeApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResumeApplication.class, args);
	}

	@Bean
	public Docket swaggerConfiguration()
	{
		return new Docket(DocumentationType.SWAGGER_2)
				   .select()
				   .paths(PathSelectors.ant("/topic/**/*"))
				   .apis(RequestHandlerSelectors.basePackage("com.practice.resume"))
				   .build()
				   .apiInfo(appDetails());
	}
	
	public ApiInfo appDetails()
	{
		return new ApiInfo(
			      "Topic API", 
			      "Sample API to practice sping boot", "1.0",
			      "http://www.appsdeveloperblof.com/service.html", new springfox.documentation.service.Contact("pradeep", "htpp://localhost:8585/topic", "a@b.com"), 
			      "Apache 2.0", "http://www.apache.org/licenses/LICENSE-2.0",Collections.emptyList());
	}
}
