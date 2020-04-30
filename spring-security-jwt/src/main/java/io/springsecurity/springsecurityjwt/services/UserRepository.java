package io.springsecurity.springsecurityjwt.services;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import io.springsecurity.springsecurityjwt.model.User;

public interface UserRepository  extends JpaRepository<User, Integer>{

	Optional<User> findByUserName(String userName);
}
