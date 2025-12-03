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

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        User findUser = userRepository.findByUsername(user.getUsername()).orElseThrow(() -> new RuntimeException("회원정보가 없습니다."));
        if (!findUser.getPassword().equals(user.getPassword())) {
            return Resp.fail(HttpStatus.UNAUTHORIZED, "비밀번호가 일치하지 않습니다.");
        }
        return Resp.ok(findUser);
    }

    @GetMapping("/api/users")
    public ResponseEntity<?> findAll() {
        List<User> users = userRepository.findAll();
        return Resp.ok(users);
    }
}
