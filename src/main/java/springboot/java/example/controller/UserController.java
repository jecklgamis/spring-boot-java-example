package springboot.java.example.controller;

import springboot.java.example.api.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
@RequestMapping(path = {"/user"})
class UserController {
    private Logger log = LoggerFactory.getLogger(UserController.class);

    @RequestMapping(path = {"/{id}"}, method = {GET}, produces = {"application/json", "application/xml"})
    public User get(@PathVariable String id) {
        return new User("me", "me@example.com");
    }

    @RequestMapping(method = {PUT, POST}, produces = {"application/json", "application/xml"},
            consumes = {"application/json", "application/xml"})
    public String put(@RequestBody User user) {
        log.info("Received ${}", user);
        return UUID.randomUUID().toString();
    }

}
