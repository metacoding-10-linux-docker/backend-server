package com.metacoding.dockerserver.user;

import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserRepository userRepository;
    
    @GetMapping("/")
    public String index() {
        return "<h1>hello docker</h1>";
    }

    @GetMapping("/api/users")
    public List<User> findAll() {
        List<User> users = userRepository.findAll();
        System.out.println(users);
        return users;
    }
}
