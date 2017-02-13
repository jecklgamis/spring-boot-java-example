package com.jecklgamis.springboot.example.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class ExampleServiceImpl implements ExampleService {
    private Logger log = LoggerFactory.getLogger(ExampleServiceImpl.class);

    @Override
    public void someServiceMethod() {
        log.info("someServiceMethod()");
    }
}
