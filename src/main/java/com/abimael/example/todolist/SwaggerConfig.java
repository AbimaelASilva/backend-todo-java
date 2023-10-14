package com.abimael.example.todolist;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/*
https://stackoverflow.com/questions/74776863/404-error-on-swagger-ui-with-spring-springdoc-openapi-configuration
 With spring boot 3 you need to use springdoc-openapi v2.
For the integration between spring-boot and swagger-ui, add the library to the list of your project dependencies (No additional configuration is needed)

Só funcionou quando adicionei esta dependência 
<dependency>
      <groupId>org.springdoc</groupId>
      <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
      <version>2.0.4</version>
   </dependency>
  
 */

@Configuration
public class SwaggerConfig {                                    
    @Bean
    public Docket swagger() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
         .apis(RequestHandlerSelectors.any())              
                  
          .paths(PathSelectors.any())                          
          .build();                                           
    }
}

