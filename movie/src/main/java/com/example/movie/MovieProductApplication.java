package com.example.movie;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//MapperScan indicate the package where the mapper interface is located in this project
// will scan the package and find the mapper interface automatically when project is running
@MapperScan("com.example.movie.mapper")
public class MovieProductApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieProductApplication.class, args);
	}
	
}
