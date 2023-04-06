package com.anghack.demo.controller.auth;

import com.anghack.demo.entity.response.AuthenticationRequest;
import com.anghack.demo.entity.response.AuthenticationResponse;
import com.anghack.demo.entity.response.RegisterRequest;
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
public class AuthenticationController {

    @PostMapping(path = "/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request){
        //
    }

    @PostMapping(path = "/authenticate")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody AuthenticationRequest request){
        //
    }

}
