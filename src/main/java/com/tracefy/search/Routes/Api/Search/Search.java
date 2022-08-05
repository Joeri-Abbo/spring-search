package com.tracefy.search.Routes.Api.Search;

import com.tracefy.search.JDBC.BusinessJDBCTemplate;
import com.tracefy.search.JDBC.DeviceJDBCTemplate;
import com.tracefy.search.JDBC.UserJDBCTemplate;
import com.tracefy.search.Models.Business;
import com.tracefy.search.Models.Device;
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
        List<Business> businesses = businessJDBCTemplate.listBusinesses(name, Integer.parseInt(amount));
        System.out.println("Search - businesses | Loaded");

        return businesses;
    }

    @GetMapping("api/search/users")
    public List<User> users(@RequestParam(value = "s", defaultValue = "") String name, @RequestParam(value = "amount", defaultValue = "25") String amount) {
        System.out.println("Search - Users | name: " + name + " amount : " + amount);
        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
        UserJDBCTemplate userJDBCTemplate = (UserJDBCTemplate) context.getBean("userJDBCTemplate");
        List<User> users = userJDBCTemplate.listUsers(name, Integer.parseInt(amount));
        System.out.println("Search - Users | Loaded");
        return users;
    }

//    @GetMapping("api/search/devices")
//    public List<Device> devices(@RequestParam(value = "s", defaultValue = "") String name, @RequestParam(value = "amount", defaultValue = "25") String amount) {
//        System.out.println("Search - Devices | name: " + name + " amount : " + amount);
//        ApplicationContext context = new ClassPathXmlApplicationContext("Beans.xml");
//        DeviceJDBCTemplate deviceJDBCTemplate = (DeviceJDBCTemplate) context.getBean("deviceJDBCTemplate");
//        List<Device> devices = deviceJDBCTemplate.listDevices(name, Integer.parseInt(amount));
//        System.out.println("Search - Devices | Loaded");
//        return devices;
//    }
}
