package com.course.mapeamentojpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.course.mapeamentojpa.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
