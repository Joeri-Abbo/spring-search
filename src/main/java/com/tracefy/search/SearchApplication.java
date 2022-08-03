package com.tracefy.search;

import com.tracefy.search.Helpers.Url;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SearchApplication {
    public static void main(String[] args) {
        SpringApplication.run(SearchApplication.class, args);
        System.out.println("Backoffice runs on : " + Url.getBackofficeUrl());
    }
}
