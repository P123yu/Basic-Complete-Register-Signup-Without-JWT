package com.interview.AuthApp.repository;

import com.interview.AuthApp.model.Register;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterRepository extends JpaRepository<Register,Long> {
    Register findByUserName(String username);
}
