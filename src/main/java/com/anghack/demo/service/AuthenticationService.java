package com.anghack.demo.service;

import com.anghack.demo.config.JwtService;
import com.anghack.demo.entity.Role;
import com.anghack.demo.entity.User;
import com.anghack.demo.entity.response.AuthenticationRequest;
import com.anghack.demo.entity.response.AuthenticationResponse;
import com.anghack.demo.entity.response.RegisterRequest;
import com.anghack.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author anghack
 */
@Service
@RequiredArgsConstructor
public class AuthenticationService {
    
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    
    public AuthenticationResponse register(RegisterRequest request){
       var user = User.builder()
               .firstname(request.getFirstname())
               .lastname(request.getLastname())
               .email(request.getEmail())
               .password(passwordEncoder.encode(request.getPassword()))
               .role(Role.USER)
               .build();
       userRepository.save(user);
       
       var jwtToken = jwtService.generateToken(user);
       
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build()
                ;
    }
    
    public AuthenticationResponse authenticate(AuthenticationRequest request){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        
        var user = userRepository.findByEmail(request.getEmail()).orElseThrow();
        
          var jwtToken = jwtService.generateToken(user);
       
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build()
                ;
    }

}
