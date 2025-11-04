package com.metacoding.dockerserver.user;

import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserRepository userRepository;
    
    @GetMapping("/index")
    public String index() {
        return "<h1>hello docker</h1>";
    }

    @GetMapping("/api/users")
    public List<User> findAll() {
        return userRepository.findAll();
    }
}