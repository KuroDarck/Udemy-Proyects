package com.example.HolaMundoSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class HolaMundoSpringApplication {

	@GetMapping("/FfirstHTMLwithSpringBoot")
	public  String FfirstHTMLwithSpringBoot(){
		return "index";
	}

	public static void main(String[] args) {
		SpringApplication.run(HolaMundoSpringApplication.class, args);
	}

}

