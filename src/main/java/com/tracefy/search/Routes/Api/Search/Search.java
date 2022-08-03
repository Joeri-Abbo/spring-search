package com.tracefy.search.Routes.Api.Search;

import com.tracefy.search.JDBC.BusinessJDBCTemplate;
import com.tracefy.search.JDBC.UserJDBCTemplate;
import com.tracefy.search.Models.Business;
import com.tracefy.search.Models.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class Search {
    @GetMapping("api/search/businesses")
    public List<Business> businesses(@RequestParam(value = "s", defaultValue = "") String name, @RequestParam(value = "amount", defaultValue = "25") String amount) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        BusinessJDBCTemplate businessJDBCTemplate = (BusinessJDBCTemplate) context.getBean("businessJDBCTemplate");
        System.out.println("Search - businesses | name: " + name + " amount : " + amount);
        return businessJDBCTemplate.listBusinesses(name, Integer.parseInt(amount));
    }

    @GetMapping("api/search/users")
    public List<User> users(@RequestParam(value = "s", defaultValue = "") String name, @RequestParam(value = "amount", defaultValue = "25") String amount) {
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        UserJDBCTemplate userJDBCTemplate = (UserJDBCTemplate) context.getBean("userJDBCTemplate");
        System.out.println("Search - Users | name: " + name + " amount : " + amount);
        return userJDBCTemplate.listUsers(name, Integer.parseInt(amount));
    }
}
