package com.sofency.springbootshiro;

import com.sofency.springbootshiro.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootTest
class SpringbootShiroApplicationTests {
    private static List<User> list= new ArrayList<>();
    static {
        User user = new User(1,"sofency","121212","user:add");
        User user1 = new User(2,"alice","1234","user:delete");
        list.add(user);
        list.add(user1);
    }
    @Test
    void contextLoads() {

        List<User> collect = list.stream().filter(user -> user.getUsername() == "sofency").collect(Collectors.toList());
        System.out.println(collect.get(0).getUsername());
    }

}
