package com.tracefy.search.Routes;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tracefy.search.JDBC.BusinessJDBCTemplate;
import com.tracefy.search.Models.Business;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Search {
    @GetMapping("/businesses")
    public String businesses(@RequestParam(value = "s", defaultValue = "") String name, @RequestParam(value = "amount", defaultValue = "25") String amount) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        BusinessJDBCTemplate businessJDBCTemplate = (BusinessJDBCTemplate) context.getBean("businessJDBCTemplate");

        System.out.println("Searching for businesses with name: " + name + ' ' + amount);
        List<Business> businesses = businessJDBCTemplate.listBusinesses(name, Integer.parseInt(amount));

        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(businesses);
        } catch (JsonProcessingException e) {
            //
        }
        return " O No something went really wrong";
    }
}
