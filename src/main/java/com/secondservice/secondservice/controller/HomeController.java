package com.secondservice.secondservice.controller;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value = "HomeController", produces = MediaType.APPLICATION_JSON_VALUE)
public class HomeController {
    @Value("${app.version}")
    private String appVersion;


    @GetMapping
    @RequestMapping("/")
    public String getStatus() {
        return appVersion;
    }

}
