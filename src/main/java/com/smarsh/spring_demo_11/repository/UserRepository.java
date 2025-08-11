package com.smarsh.spring_demo_11.repository;

import com.smarsh.spring_demo_11.model.UserDB;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserDB, Long> {
}
