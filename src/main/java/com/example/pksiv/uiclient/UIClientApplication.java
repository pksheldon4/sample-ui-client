package com.example.pksiv.uiclient;

import com.example.pksiv.uiclient.spring.WebMvcConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.pksiv.uiclient")
public class UIClientApplication {
    
    public static void main(String[] args) throws Exception {
        SpringApplication.run(new Class[] { UIClientApplication.class }, args);
    }

}
