package com.tracefy.search.Routes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Root {
    @GetMapping("/")
    public String response() {
        return "Search service running... \uD83E\uDD95";
    }
}
