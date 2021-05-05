package com.peter.routing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication

@RestController
public class RoutingApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoutingApplication.class, args);
	
	}	
    
        @RestController
        
        @RequestMapping("/coding") 
        public class CodingController {
                @RequestMapping("")
                public String index(){
                        return "Hello Coding Dojo!";
                }

                @RequestMapping("/python")
                public String python(){
                        return "Python/Django was awesome!";
                }

                @RequestMapping("/java")
                public String java(){
                        return "Java/Spring is better!";
                }
        }
        
        @RestController
        public class DojoController {
                @RequestMapping("/x/{dojo}")
                public String dojo(@PathVariable("dojo") String dojo){
                        return "The " + dojo + " is awesome!";
                }

                @RequestMapping("/y/{burbank-dojo}")
                public String burbank(@PathVariable("burbank-dojo") String burbank){
                        return burbank + " is located in Southern California.";
                }

                @RequestMapping("/z/{san-jose}")
                public String sanjose(@PathVariable("san-jose") String sanjose){
                        return sanjose + " SJ Dojo is the headquarters!";
                }
        }
}