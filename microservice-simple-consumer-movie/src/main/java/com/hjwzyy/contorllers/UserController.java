package com.hjwzyy.contorllers;

import com.hjwzyy.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author
 * @version 1.0
 * @name
 * @description
 * @date 2018/6/13 0013.
 */
@RestController
public class UserController {
    @Autowired
    private RestTemplate restTemplate;
    @Value("${user.userServiceUrl}")
    private String userServiceUrl;

    @GetMapping("/user/{id}")
    public User findById(@PathVariable Long id){
        return this.restTemplate.getForObject(this.userServiceUrl + id,User.class);
    }
}
