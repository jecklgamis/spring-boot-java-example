package spring.boot.java.example.controller;

import com.google.common.collect.ImmutableMap;
import io.micrometer.core.annotation.Timed;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(path = {"/probe"}, method = {GET}, produces = {"application/json"})
public class ProbeController {

    @RequestMapping(path = {"/live"}, method = {GET}, produces = {"application/json"})
    @Timed
    public Map<Object, Object> live() {
        return ImmutableMap.builder().put("message", "I'm alive!").build();
    }

    @RequestMapping(path = {"/ready"}, method = {GET}, produces = {"application/json"})
    @Timed
    public Map<Object, Object> ready() {
        return ImmutableMap.builder().put("message", "I'm ready!").build();
    }

}
