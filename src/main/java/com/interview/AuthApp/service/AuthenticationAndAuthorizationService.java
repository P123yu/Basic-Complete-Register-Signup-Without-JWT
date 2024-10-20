package com.interview.AuthApp.service;
import com.interview.AuthApp.model.Login;
import com.interview.AuthApp.model.Register;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public interface AuthenticationAndAuthorizationService {

    // register a new employee
    Register registerEmployee(Register register);

    // login
    Authentication loginEmployee(Login login);
}
