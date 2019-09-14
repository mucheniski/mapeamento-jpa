package com.course.mapeamentojpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.course.mapeamentojpa.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
