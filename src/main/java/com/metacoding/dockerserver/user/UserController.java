package com.metacoding.dockerserver.user;

import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import java.util.List;
import org.springframework.http.*;
import com.metacoding.dockerserver.core.util.Resp;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("/api/users")
    public ResponseEntity<?> findAll() {
        List<User> users = userRepository.findAll();
        return Resp.ok(users);
    }
}
