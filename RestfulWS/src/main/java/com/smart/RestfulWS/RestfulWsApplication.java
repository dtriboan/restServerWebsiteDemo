package com.smart.RestfulWS;

import com.smart.webmavenproject.domain.PersonalDetails;
import com.smart.webmavenproject.domain.User;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@RequestMapping("/person")
@CrossOrigin("*")
public class RestfulWsApplication {

    private final Map<Integer, User> users = new HashMap<>();
    
    public RestfulWsApplication(){
        users.put(1, new User(101, "Bob Davis", new Date(), 80, new PersonalDetails("address1", "20/01/1991", "+4471111111")));
        users.put(2, new User(102, "Ken Lenkein", new Date(), 104, new PersonalDetails("address1", "20/01/1991", "+4471111111")));
        users.put(3, new User(103, "James Tailor", new Date(), 104, new PersonalDetails("address1", "20/01/1991", "+4471111111")));
        users.put(4, new User(104, "Adam Best", new Date(), 104, new PersonalDetails("address1", "20/01/1991", "+4471111111")));
    }
    
    public static void main(String[] args) {
        SpringApplication.run(RestfulWsApplication.class, args);
    }
    
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        //http://localhost:8080/person/hello
        //http://localhost:8080/person/hello?name=tom
        return String.format("Hello %s!", name);
    }
    
    //@RequestMapping("/")
    @GetMapping(path="/getUsersList", produces=MediaType.APPLICATION_JSON_VALUE)
    public Map<Integer, User> getUsersList(@RequestParam(value = "id", defaultValue="") String id) {
        //http://localhost:8080/person/getUsersList
        //http://localhost:8080/person/getUsersList?id=1
        Integer value = 0;
        try{
            value = Integer.valueOf(id);
        }catch(NumberFormatException e){
            System.err.println("ID not passed");
        }
        Map<Integer, User> temp = new HashMap<>();
        if (value != 0) {
            User u = users.get(value);
            temp.put(value, u);
            return temp;
        } else {
            return users;
        }
    }

    
    @GetMapping("/getStatus")
    public String getStatus(@RequestParam(value = "url", defaultValue="empty") String url) {
        //http://localhost:8080/person/getStatus?url=abc
        if (url != null && !url.isEmpty()) {
            return "url not empty, value is : " + url;
        } else {
            return "url empty";
        }
    }
    
    @PutMapping("/putUser")
    public Boolean putUser(@RequestParam(value = "id", defaultValue="") String id, 
                        @RequestParam(value = "name", defaultValue="") String name) {
        //http://localhost:8080/person/putUser?id=1&name="Alice"
        Integer value = Integer.getInteger(id);
        if (value != null && !name.isEmpty()) {
            users.put(value, new User(value, name));
            return true;
        } else {
            return false;
        }
    }
}
