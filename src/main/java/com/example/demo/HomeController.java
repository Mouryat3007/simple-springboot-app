package main.java.com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String home() {
        return "Hello, This is create by Mourya.This is running on port 3031. This is triggred by github webhook which is CI/CD. This is deployed using docker container";
    }
}
