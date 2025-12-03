package com.metacoding.dockerserver.user;

import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserRepository userRepository;


    @PostMapping("/login")
    public User login(@RequestBody User user) {
        User findUser = userRepository.findByUsername(user.getUsername()).orElseThrow(() -> new RuntimeException("회원정보가 없습니다."));
        return findUser;
    }


    @GetMapping("/api/users")
    public List<User> findAll() {
        List<User> users = userRepository.findAll();
        return users;
    }
}
