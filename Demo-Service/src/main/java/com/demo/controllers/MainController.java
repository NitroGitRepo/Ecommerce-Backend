package com.demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@RestController
@RequestMapping("/demo")
public class MainController {

    @GetMapping("/")
    public String checkApplication(){
        log.info("INFO SEVERITY");
        log.warn("WARN SEVERITY");
        log.error("ERROR SEVERITY");
        log.debug("DEBUG SEVERITY");
        log.trace("TRACE SERVRITY");
        return "Application Demo Running";
    }
}
