package com.codewithz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codewithz.model.StudentIdCard;

@Repository
public interface StudentIdCardRepository extends JpaRepository<StudentIdCard,Long> {
}
