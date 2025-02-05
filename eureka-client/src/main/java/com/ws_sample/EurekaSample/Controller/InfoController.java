package com.ws_sample.EurekaSample.Controller;

import com.netflix.discovery.DiscoveryClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class InfoController {

    @Autowired
    public static DiscoveryClient discoveryClient;

    @GetMapping("/info")
    public static String info(){
        return("This webpage contains information about the EurekaClient Application");
    }

    @GetMapping("/health")
    public static ResponseEntity health(){
        return(ResponseEntity.ok("The server appears to be in optimal condition"));
    }

    @GetMapping("/clients")
    public static String getClients(){
        return ("Clients");
    }
}
