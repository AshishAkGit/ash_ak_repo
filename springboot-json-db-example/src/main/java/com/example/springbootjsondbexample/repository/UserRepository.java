package com.example.springbootjsondbexample.repository;

import com.example.springbootjsondbexample.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User,Long> {
}
