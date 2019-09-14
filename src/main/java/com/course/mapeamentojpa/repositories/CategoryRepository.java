package com.course.mapeamentojpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.course.mapeamentojpa.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
