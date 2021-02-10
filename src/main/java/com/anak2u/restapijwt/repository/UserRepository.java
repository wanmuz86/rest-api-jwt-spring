package com.anak2u.restapijwt.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.anak2u.restapijwt.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	Optional<User> findByUsername(String username);
}
