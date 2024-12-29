package com.bootlabs.sample.controller;

import com.bootlabs.sample.service.JwtService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

record Login(@NonNull String username, @NonNull String password) {
}

@RequiredArgsConstructor
@RestController
@RequestMapping("/authenticate")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;

    private final JwtService jwtService;

    @PostMapping()
    public ResponseEntity<Map<String, Object>> authenticate(@RequestBody Login login) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login.username(), login.password()));

        var token = jwtService.generateToken(login.username());

        return ResponseEntity.ok(Map.of("info", "Basic Auth", "token", token));

    }

}
