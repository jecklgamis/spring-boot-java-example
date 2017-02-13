package com.jecklgamis.springboot.example.controller;

import com.google.common.collect.ImmutableMap;
import com.jecklgamis.springboot.example.service.ExampleService;

import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class RootController {
    @Autowired
    private ExampleService exampleService;

    @Autowired
    public RootController(ExampleService exampleService) {
        this.exampleService = exampleService;
    }

    @RequestMapping(path = {"/"}, method = {GET}, produces = {"application/json"})
    public Map example() {
        exampleService.someServiceMethod();
        return ImmutableMap.builder()
                .put("message", "Java rocks!")
                .put("today", LocalDateTime.now().toString())
                .build();
    }
}
