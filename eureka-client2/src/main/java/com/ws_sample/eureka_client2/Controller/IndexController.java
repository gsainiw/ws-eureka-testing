package com.ws_sample.eureka_client2.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

    @GetMapping
    public static String greetClient2(){
        return("Hello from client number two!");
    }
}
