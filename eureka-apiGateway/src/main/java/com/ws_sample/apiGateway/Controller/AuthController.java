package com.ws_sample.apiGateway.Controller;

import com.ws_sample.apiGateway.Util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JwtUtil jwtUtil;

    // In-memory user storage for demonstration purposes
    private Map<String, String> users = Map.of(
            "user1", new BCryptPasswordEncoder().encode("password1"),
            "user2", new BCryptPasswordEncoder().encode("password2")
    );

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> credentials) {
        String username = credentials.get("username");
        String password = credentials.get("password");

        if (users.containsKey(username) && new BCryptPasswordEncoder().matches(password, users.get(username))) {
            String token = jwtUtil.generateToken(username);
            return ResponseEntity.ok(Map.of("token", token));
        } else {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
    }
}
