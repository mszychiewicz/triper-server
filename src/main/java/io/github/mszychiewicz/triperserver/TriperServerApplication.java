package io.github.mszychiewicz.triperserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
public class TriperServerApplication {

  public static void main(String[] args) {
    SpringApplication.run(TriperServerApplication.class, args);
  }

}
