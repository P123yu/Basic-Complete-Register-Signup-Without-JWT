package com.interview.AuthApp.service.impl;

import com.interview.AuthApp.model.Login;
import com.interview.AuthApp.model.Register;
import com.interview.AuthApp.repository.RegisterRepository;
import com.interview.AuthApp.service.AuthenticationAndAuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationAndAuthorizationServiceImpl implements AuthenticationAndAuthorizationService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private RegisterRepository registerRepository;

    @Override
    public Register registerEmployee(Register register) {
        System.out.println(register+"register12");
        Register registerObj=new Register();
        String encodedPassword=passwordEncoder.encode(register.getUserPassword());
        registerObj.setUserName(register.getUsername());
        registerObj.setUserPassword(encodedPassword);
        return registerRepository.save(registerObj);
    }

    @Autowired
    AuthenticationManager authenticationManager;

    @Override
    public Authentication loginEmployee(Login login) {
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(login.getUserName(), login.getUserPassword());
        Authentication authentication = authenticationManager.authenticate(authToken);
        return authentication;
    }
}
