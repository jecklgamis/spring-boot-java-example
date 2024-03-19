package spring.boot.java.example.controller;

import com.google.common.io.Resources;
import io.micrometer.core.annotation.Timed;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.charset.Charset;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class BuildInfoController {
    private static String buildInfo = loadBuildInfo();

    private static String loadBuildInfo() {
        try {
            return Resources.toString(Resources.getResource("build-info.json"), Charset.defaultCharset());
        } catch (IOException e) {
            return "{}";
        }
    }

    @RequestMapping(path = {"/buildInfo"}, method = {GET}, produces = {"application/json"})
    @Timed
    public ResponseEntity<String> buildInfo() {
        return ResponseEntity.ok().cacheControl(CacheControl.noStore()).body(buildInfo);
    }

}
