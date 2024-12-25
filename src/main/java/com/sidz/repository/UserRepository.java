package com.sidz.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sidz.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	List<User> findByName(String name);
}
