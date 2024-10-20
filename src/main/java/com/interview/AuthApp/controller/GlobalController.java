package com.interview.AuthApp.controller;

import com.interview.AuthApp.model.Login;
import com.interview.AuthApp.model.Register;
import com.interview.AuthApp.service.AuthenticationAndAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class GlobalController {


    @Autowired
    private AuthenticationAndAuthorizationService authenticationAndAuthorizationService;


    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Register register) {
        System.out.println(register+"register");

        Register registerResponse=authenticationAndAuthorizationService.registerEmployee(register);
        if(register!=null) {
            return ResponseEntity.ok(registerResponse);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("CFL not registered");
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Login login) {
        System.out.println(login.getUserName()+" "+login.getUserPassword());
        Authentication auth=authenticationAndAuthorizationService.loginEmployee(login);

        if(auth!=null) {
            // step 9
            return ResponseEntity.ok(auth);
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not login");
        }
    }
}
