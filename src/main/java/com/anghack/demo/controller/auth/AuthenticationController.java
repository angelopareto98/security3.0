package com.anghack.demo.controller.auth;

import com.anghack.demo.entity.response.AuthenticationRequest;
import com.anghack.demo.entity.response.AuthenticationResponse;
import com.anghack.demo.entity.response.RegisterRequest;
import com.anghack.demo.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author anghack
 */
@RestController
@RequestMapping(path = "/api/v2/auth")
@RequiredArgsConstructor
public class AuthenticationController {
    private final AuthenticationService service;

    @PostMapping(path = "/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request){
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping(path = "/authenticate")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody AuthenticationRequest request){
                return ResponseEntity.ok(service.authenticate(request));

    }

}
